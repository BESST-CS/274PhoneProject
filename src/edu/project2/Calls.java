package edu.project2;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author - Sean Curley - seancurley007@gmail.com
 * @author - Hunter Davis - huntertigerdavis@gmail.com
 * @author - Yosselin Velasco - yosselin.velasco@gmail.com
 *
 * @version - 1.0.0
 * @since - 3/1/2018
 *
 * Handles Call data to contacts including call log.
 */
public class Calls {
    private HashMap<String, ArrayList<String>> log;
    Contacts contacts;

    /**
     * Constructor for the Calls object that includes a
     * Contacts database object.
     * @param contacts hold the reference to a database
     *                 of Contact objects to reference.
     */
    public Calls(Contacts contacts){
        log = new HashMap<>();
        this.contacts = contacts;
    }

    /**
     * Returns the date as a String in the 12-Hour formatting
     * along with AM/PM designation based on the 24 hour format.
     * @return Date as a String in 12-Hour format, with AM/PM
     * designator attached
     */
    private String getDate(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm:ss");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm:ss");
        String concat;
        // 11-13 non-inclusive
        if(Integer.parseInt(format.format(LocalDateTime.now()).toString().substring(11, 13)) <= 12){
            concat = "AM";
        }else{
            concat = "PM";
        }
        return format2.format(LocalDateTime.now()) + " " + concat;
    }

    /**
     * Modifies a phone number to appear in the (XXX) XXX-XXXX format.
     * @param num Number to be modified
     * @return Returns a value in the proper format.
     */
    private String modNumber(String num){
        if(num.length() == 10) {
            return "(" + num.substring(0, 3) + ") " + num.substring(3, 6) + "-" + num.substring(6);
        }else if(num.length() == 7){
            return num.substring(0,3)+"-"+num.substring(3);
        }
        return null;
    }

    /**
     * Adds a call to the log.
     * @param target The target number or contact to recieve from or send to.
     * @param direction Refers to incoming or outgoing
     */
    public void makeCall(String target, String direction){
        if(direction.equals("OUTGOING") && target.length() == 1){
            target = contacts.favorites.get(Integer.valueOf(target)-1).getNumber();
        }
        else if(target.matches("[a-zA-Z]+")){
            for(Contact c : contacts.list){
                if(target.equals(c.getName())){
                    target = c.getNumber();
                }
            }
            for(Contact c : contacts.favorites){
                if(target.equals(c.getName())){
                    target = c.getNumber();
                }
            }
        }else {
            target = modNumber(target);
        }

        if(log.containsKey(target)){
            log.get(target).add(getDate().concat("          "+direction));
        }else{
            log.put(target, new ArrayList<>());
            log.get(target).add(getDate().concat("          "+direction));
        }
    }

    /**
     * Displays the call log using the lists from static Contacts objects.
     * Serializes the maps in this class and references keys to access
     * values in terms of ArrayLists and generate a call log from those
     * ArrayLists.
     */
    public void displayLog(){
        Scanner k = new Scanner(System.in);
        boolean hasContact = false;
        Contact place = new Contact();
        int iter = 0;
        int select;
        while(true){
            for(String i : log.keySet()){
                hasContact = false;
                if(i.matches("[0-9]+")){
                    i = modNumber(i);
                }else{
                    for(Contact c : contacts.list){
                        if(c.getNumber().equals(i)){
                            hasContact = true;
                            place = c;
                        }
                    }
                    for(Contact c : contacts.favorites){
                        if(c.getNumber().equals(i)){
                            hasContact = true;
                            place = c;
                        }
                    }
                }
                if(hasContact){
                    System.out.println(place.toString()+":\t\t("+log.get(i).size()+")");
                }else{
                    System.out.println(i+":\t\t("+log.get(i).size()+")");
                }
            }
            System.out.println("If you would like to expand a call, enter its number in the list:\nEnter 0 to exit.\n>>");
            select = k.nextInt();
            if(select != 0 && select-1 <= log.keySet().size()){
                System.out.println(log.keySet().toArray()[select-1]+":");
                for(String s : log.get(log.keySet().toArray()[select-1])){
                    System.out.println("\t"+s);
                }
            }
            else if(select == 0){
                break;
            }
            else{
                System.out.println("Invalid Input.");
            }
        }
    }
}

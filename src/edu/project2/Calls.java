package edu.project2;
//Created by Sean C. on 3/1/2018

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Handles Call data to contacts including call log.
 */
public class Calls {
    private HashMap<String, ArrayList<String>> log;
    Contacts contacts;

    public Calls(Contacts contacts){
        log = new HashMap<>();
        this.contacts = contacts;
    }

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

    private String modNumber(String num){
        return "(" + num.substring(0, 3) + ") " + num.substring(3, 6) + "-" + num.substring(6);
    }

    /**
     * Adds a call to the log.
     * @param number
     * @param direction
     */
    public void makeCall(String number, String direction){
        if(direction.equals("OUTGOING") && number.length() == 1){
            number = contacts.favorites.get(Integer.valueOf(number)).getNumber();
        }
        if(!log.keySet().contains(number)){
            log.put(number, new ArrayList<>());
            log.get(number).add(getDate().concat("          "+direction));
        }
        else{
            log.get(number).add(getDate().concat("          "+direction));
        }
    }

    public void displayLog(){
        Scanner k = new Scanner(System.in);
        boolean hasContact = false;
        Contact place = new Contact();
        int iter = 0;
        int select;
        while(true){
            for(String i : log.keySet()){
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

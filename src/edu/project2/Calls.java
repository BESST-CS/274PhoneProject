package edu.project2;
//Created by Sean C. on 3/1/2018

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
//thisNum = "(" + personalNum.substring(0, 3) + ") " + personalNum.substring(3, 6) + "-" + personalNum.substring(6);

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
        return format.format(LocalDateTime.now());
    }

    /**
     * Adds a call to the log.
     * @param number
     * @param direction
     */
    public void makeCall(String number, String direction){
        if(!log.keySet().contains(number)){
            log.put(number, new ArrayList<>());
            log.get(number).add(direction.concat(" "+getDate()));
        }
        else{
            log.get(number).add(direction.concat(" "+getDate()));
        }
    }

    public void displayLog(){
        for(String s : log.keySet()){
            System.out.println(s+":\n");
            for(String st : log.get(s)){
                System.out.println("\t"+st);
            }
        }
    }
}

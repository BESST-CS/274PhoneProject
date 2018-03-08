package edu.project2;
//Created by Sean C. on 3/1/2018

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * Handles Call data to contacts including call log
 */
public class Calls {
    private HashMap<Contact, Integer> log;

    public Calls(){
        log = new HashMap<>();
    }

    private String getDate(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm:ss");
        return format.format(LocalDateTime.now());
    }

    public void makeCall(Contact c){
        if(!log.keySet().contains(c)){
            log.put(c, 1);
        }
        else{
            log.replace(c, log.get(c)+1);
        }
    }

}

package edu.project2;
//Created by Sean C. on 3/8/2018

import java.util.ArrayList;

public class Contact {

    private String name;
    private String number;
    private String email;
    private ArrayList<String> notes;

    public Contact(String name, String number, String email){
        this.name = name;
        this.number = number;
        this.email = email;
        notes = new ArrayList<>();
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void addNote(String note){
        notes.add(note);
    }

    public String getNumber(){return this.number;}

    public String getName(){return this.name;}

    public String getEmail(){return this.email;}

    public void displayNotes(){
        for(String i : notes){
            System.out.println("• "+i);
        }
    }

    public boolean isEqual(Contact other){
        return other.getNumber().equals(this.number);
    }
}

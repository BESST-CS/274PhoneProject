package edu.project2;
//Created by Sean C. on 3/1/2018

import java.util.ArrayList;

/**
 * Handles a list of all the Contact
 */
public class Contacts{

    private ArrayList<Contact> favorites;
    private ArrayList<Contact> list;

    public Contacts(){
        favorites = new ArrayList<>();
        list = new ArrayList<>();
    }

    public void addContact(Contact c){
        list.add(c);
    }

    public void deleteContact(){

    }

    public void editContact(){

    }

}

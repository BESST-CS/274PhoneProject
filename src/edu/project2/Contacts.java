package edu.project2;
//Created by Sean C. on 3/1/2018

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Handles a list of all the contacts.  Includes methods to add, delete, and modify contacts.  Handles creation of Contact objects
 */
public class Contacts{

    private Scanner input = new Scanner(System.in);
    public ArrayList<Contact> favorites;
    public ArrayList<Contact> list;

    public Contacts(){
        favorites = new ArrayList<>();
        list = new ArrayList<>();
    }

    public void addContact(Contact c){
        list.add(c);
        Collections.sort(list);
    }
    
    public void displayAll() {
    	for(Contact c: list) {
    		c.displayContact();
    		System.out.println("\n");
    	}
    }

    public void editContact(Contact c, int i){

        //Editing the name of the contact
        if (i == 1){
            System.out.println("Enter a new name for the contact: ");
            Contact a = new Contact(input.nextLine(), c.getNumber(), c.getEmail(), c.getNote());
            addContact(a);
            deleteContact(c);

        //Editing the phone number of the contact
        } else if (i == 2){
            System.out.println("Enter a new phone number for the contact: ");
            Contact a = new Contact(c.getName(), input.next(), c.getEmail(), c.getNote());
            addContact(a);
            deleteContact(c);

        //Editing the email address of the contact
        } else if (i == 3){
            System.out.println("Enter a new email for the contact: ");
            Contact a = new Contact(c.getName(), c.getNumber(), input.next(), c.getNote());
            addContact(a);
            deleteContact(c);
        //Editing the note of the contact
        } else {
            System.out.println("Enter a new note for the contact: ");
            Contact a = new Contact(input.nextLine(), c.getNumber(), c.getEmail(), input.next());
            addContact(a);
            deleteContact(c);
        }
    }
    
    public void deleteContact(Contact c){
    	list.remove(c);
    }
    
    public void addFavContact(Contact c) {
    	favorites.add(c);
    	Collections.sort(favorites);
    }
    
    public void displayFavs() {
    	for(Contact c: favorites) {
    		c.displayContact();
    		System.out.println("\n");
    	}
	}
    
    public void deleteFavContact(int i) {
    	list.remove(i);
    }

}

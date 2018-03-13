package edu.project2;
//Created by Sean C. on 3/1/2018

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Handles a list of all the contacts.  Includes methods to add, delete, and modify contacts.  Handles creation of Contact objects
 */
public class Contacts{

    private Scanner input = new Scanner(System.in);
    private ArrayList<Contact> favorites;
    private ArrayList<Contact> list;

    public Contacts(){
        favorites = new ArrayList<>();
        list = new ArrayList<>();
    }

    public void addContact(){
        //Ask for data first
        String name;
        String number;
        String email;
        String note;
        System.out.println("What is the name of the contact?");
        name = input.nextLine();
        System.out.println("What is the number?");
        number = input.next();
        System.out.println("What is the email address?");
        email = input.next();
        System.out.println("Are there any notes for the contact?");
        note = input.nextLine();

        Contact c = new Contact(name, number, email, note);

        list.add(c);
        Collections.sort(list);
    }
    
    public void displayAll() {
    	for(Contact c: list) {
    		c.displayContact();
    		System.out.println("\n");
    	}
    }

    public void editContact(int i){
        list.get(i);
    }
    
    public void deleteContact(int i){
    	list.remove(i);
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
    
    public void editFavContact(int i) {
    	favorites.get(i);
    }
    
    public void deleteFavContact(int i) {
    	list.remove(i);
    }

}

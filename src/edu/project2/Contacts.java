package edu.project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author - Sean Curley - seancurley007@gmail.com
 * @author - Hunter Davis - huntertigerdavis@gmail.com
 * @author - Yosselin Velasco - yosselin.velasco98@gmail.com
 *
 * @version - 1.0.0
 * @since - 3/1/2018
 * Handles a list of all the contacts. Includes methods to add, delete, and modify contacts.  Handles creation of Contact objects
 */
public class Contacts{

    private Scanner input = new Scanner(System.in);
    public ArrayList<Contact> favorites;
    public ArrayList<Contact> list;

    /**
     * Default Constructor
     */
    public Contacts(){
        favorites = new ArrayList<>();
        list = new ArrayList<>();
    }

    /**
     * Adds a filled in Contact object to the ArrayList of contacts
     * @param c - Contact object with information filled in
     */
    public void addContact(Contact c){
        list.add(c);
        Collections.sort(list);
        Collections.sort(favorites);
    }

    /**
     * Prints all of the contacts with formatting to the console
     */
    public void displayAll() {
    	for(Contact c: favorites){
    	    displayFavs();
        }
        for(Contact c: list) {
    		c.displayContact();
    		System.out.println("\n");
    	}
    }

    /**
     * Edits a contact's specific data value (name, number, email, note)
     * @param c - Contact object
     * @param i - integer with index of data value to change in the contact
     */
    public void editContact(Contact c, int i){

        //Editing the name of the contact
        if (i == 1){
            System.out.println("Enter a new name for the contact: ");
            Contact a = new Contact(input.nextLine(), c.getRawNumber(), c.getEmail(), c.getNote());
            addContact(a);
            deleteContact(c);

        //Editing the phone number of the contact
        } else if (i == 2){
            System.out.println("Enter a new phone number for the contact: ");
            Contact a = new Contact(c.getName(), input.nextLine(), c.getEmail(), c.getNote());
            addContact(a);
            deleteContact(c);

        //Editing the email address of the contact
        } else if (i == 3){
            System.out.println("Enter a new email for the contact: ");
            Contact a = new Contact(c.getName(), c.getRawNumber(), input.nextLine(), c.getNote());
            addContact(a);
            deleteContact(c);
        //Editing the note of the contact
        } else if (i == 4) {
            System.out.println("Enter a new note for the contact: ");
            Contact a = new Contact(c.getName(), c.getRawNumber(), c.getEmail(), input.nextLine());
            addContact(a);
            deleteContact(c);
        }
    }

    /**
     * Deletes a selected contact
     * @param c - Contact object to delete from the ArrayList
     */
    public void deleteContact(Contact c){
    	list.remove(c);
    	favorites.remove(c);
    }

    /**
     * Contact that is to be added to the favorites
     * @param c - Contact object
     */
    public void addFavContact(Contact c) {
    	favorites.add(c);
    	Collections.sort(favorites);
    }

    /**
     * Displays the favorite contacts
     */
    public void displayFavs() {
    	for(Contact c: favorites) {
    		c.displayContact();
    		System.out.println("\n");
    	}
	}

    /**
     * Deletes a selected favorite contact
     * @param c - Contact object to delete
     */
    public void deleteFavContact(Contact c) {
        list.remove(c);
    }

}

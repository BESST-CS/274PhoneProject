package edu.project2;
//Created by Sean C. on 3/1/2018

import java.util.ArrayList;
import java.util.Collections;

/**
 * Handles a list of all the contacts.  Includes methods to add, delete, and modify contacts.  Handles creation of Contact objects
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
    	for(Contact2 c: favorites) {
    		c.displayContact();
    		System.out.println("\n");
    	}
	}
    
    public void editFavContact(int i) {
    	favorties.get(i);
    }
    
    public void deleteFavContact(int i) {
    	list.remove(i);
    }

}

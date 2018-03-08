package edu.project2;
//Created by Sean C. on 3/1/2018

import java.util.ArrayList;

/**
 * Class for running the module.  Depends on Calls and Contacts
 */
public class Phonebook {
	
	//Options:
	public static final String MAKE_CALL = "1";
	//Enter number, name, or speed dial
    public static final String CONTACT_BOOK = "2";
    //Open contact book to add, edit, delete, and display alphabetically
    public static final String RECEIVE_CALL = "3";
    //Receive a call from an entered number or randomly generated
    public static final String CALL_HISTORY = "4";
    //Open call history to display 
    
    
    
    ArrayList<Calls> log = new ArrayList<>();

    public static void main(String[] args){

    	String userChoice;
        do {
           displayMenu();
           userChoice = userInput.next();
           switch (userChoice)
           {
           case MAKE_CALL:
              
              System.out.println("Enter a phone number, contact name, or speed dial preset: ");
              String zipCode = userInput.next();
              System.out.println("The zipcode " + zipCode + " has a bar code of:");
              System.out.println(PostalBarCode.zipToBarCode(zipCode));
              System.out.println();
              break;
           case BAR_TO_ZIP_OPTION:
              System.out.println("Converting Bar code to Zip code.");
              System.out.println("Enter the Bar code to continue: ");
              String barCode = userInput.next();
              System.out.println("The bar code " + barCode + " represent the zip code:");
              System.out.println(PostalBarCode.barToZipCode(barCode));
              System.out.println();
              break;
           case QUIT_OPTION:
              System.out.println("Good bye");
              break;
           default:
              System.out.println("Please type one of the options in the menu.");
           }
        } while (! userChoice.equals(QUIT_OPTION));
    	
    }
    
    /**
     * Displays a menu with the options for the user. 
     */
    public static void displayMenu() 
    {
       System.out.println("------------------------------");
       System.out.println(MAKE_CALL + ": Make call");
       System.out.println(CONTACT_BOOK + ": Contact Book");
       System.out.println(RECEIVE_CALL + ": Receive Call");
       System.out.println(CALL_HISTORY + ": Call History")
       System.out.println(QUIT + ": Quit")
       System.out.println("------------------------------");
    }
}

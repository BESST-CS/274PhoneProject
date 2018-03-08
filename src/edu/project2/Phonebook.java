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
    public static final String QUIT_OPTION = "5";
    //Quits the program
    
    
    
    ArrayList<Calls> log = new ArrayList<>();

    public static void main(String[] args){

    	String userChoice;
        do {
           displayMenu(0);
           userChoice = userInput.next();
           switch (userChoice)
           {
           case MAKE_CALL:
              System.out.println("Enter a phone number, contact name, or speed dial preset: ");
              String option = userInput.next();
              
              System.out.println();
              break;
           case CONTACT_BOOK:
        	  displayMenu(1);
              System.out.println("Opening contact book, what would you like to do?");
              
              String option = userInput.next();
              if (option == 1) {
            	  //Contacts.addContact();
              }
              elif (option == 2){
            	  //Contacts.editContact();
              }
              elif (option == 3){
            	  //Contacts.deleteContact();
              }
              elif (option == 4){
            	  //Contacts.displayContact();
              }
              System.out.println();
              break;
           case RECEIVE_CALL:
               System.out.println("Enter the number that is calling, or 'random' for a random number: ");
               displayMenu(2);
               String callToReceive = userInput.next();
               if(option.isAlpha() == true) {
            	   Calls.receiveCall.random(callToReceive);
               }
               else {
            	   Calls.receiveCall(callToReceive);
               }
               //Test if number or letter. If number, call that number. If letter, do random #
               System.out.println();
               break;
           case CALL_HISTORY:
        	   displayMenu(3);
        	   System.out.println("Displaying call history: ");
        	   System.out.println();
               break;
           case QUIT_OPTION:
              System.out.println("Goodbye");
              break;
           default:
              System.out.println("Please type one of the options in the menu.");
           }
        } while (! userChoice.equals(QUIT_OPTION));
    	
    }
    
    /**
     * Displays a menu with the options for the user. 
     */
    public static void displayMenu(int selector) {
    	
    	switch(selector) {
    	case 0:
    		//Main Menu
    		System.out.println("------------------------------");
    	       System.out.println(MAKE_CALL + ": Make call");
    	       System.out.println(CONTACT_BOOK + ": Contact Book");
    	       System.out.println(RECEIVE_CALL + ": Receive Call");
    	       System.out.println(CALL_HISTORY + ": Call History")
    	       System.out.println(QUIT + ": Quit")
    	       System.out.println("------------------------------");
    		break;
    	case 1:
    		//Contact Book Sub-menu
    		System.out.println("1. Add contact\n2. Edit contact\n3. Delete contact\n4. Display contacts");
    		if 
    		break;
    	}
    	case 2:
    		//Receive Call Sub-menu
    		break;
    	case 3:
    		//Call History Sub-menu
    		break;
		default:
			System.out.println("Please type one of the options in the menu");
    }
       
    }
    
}

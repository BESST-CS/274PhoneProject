package edu.project2;
//Created by Hunter D. on 3/1/2018 ye

import java.util.ArrayList;
import java.util.Scanner;

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


    public static void main(String[] args) {

        ArrayList<Calls> log = new ArrayList<>();
        Scanner userInput = new Scanner(System.in);


        String userChoice;

        //Creating objects to call on later
        Contacts addressBook = new Contacts();
        Calls calls = new Calls(addressBook);

        do {
            displayMenu(0);
            userChoice = userInput.next();
            switch (userChoice) {
                case MAKE_CALL:
                    System.out.println("Enter a phone number, contact name, or speed dial preset: ");
                    String option = userInput.next();
                    calls.makeCall(option, "OUTGOING");
                    System.out.println();
                    break;
                case CONTACT_BOOK:
                    displayMenu(1);
                    System.out.println("Opening contact book, what would you like to do?");

                    String selection = userInput.nextLine();
                    if (selection.equals("1")) {
                        //Ask for data first
                        String name = "";
                        String number = "";
                        String email = "";
                        String note = "";
                        System.out.println("What is the name of the contact?");
                        name = userInput.nextLine();
                        System.out.println("What is the number?");
                        number = userInput.next();
                        System.out.println("What is the email address?");
                        email = userInput.next();
                        System.out.println("Are there any notes for the contact?");
                        note = userInput.nextLine();

                        Contact c = new Contact(name, number, email, note);

                        addressBook.addContact(c);
                    } else if (selection.equals("2")) {
                        String contactName = "";
                        System.out.println("Enter the name of the contact to edit:");
                        contactName = userInput.next();
                        for (Contact c : addressBook.list) {
                            if (c.getName().equals(contactName)) {
                                System.out.println("What field of the contact would you like to edit:");
                                System.out.println("1: Name\n2: Number\n3: Email\n4: Note");
                                int userSelection = userInput.nextInt();
                                addressBook.editContact(c, userSelection);

                            }
                        }
                    } else if (selection.equals("3")) {
                        String contactName = "";
                        System.out.println("Enter the name of the contact to delete: ");
                        contactName = userInput.next();
                        for (Contact c: addressBook.list){
                            if (c.getName().equals(contactName)){
                                System.out.println("Deleting: " + c.getName() + " from contacts.");
                                addressBook.deleteContact(c);
                            }
                        }

                    } else if (selection.equals("4")) {
                        addressBook.displayAll();
                        System.out.println();
                        break;
                    }
                case RECEIVE_CALL:
                    displayMenu(2);
                    String callToReceive = userInput.next();
                    calls.makeCall(callToReceive, "INCOMING");
                    //Test if number or letter. If number, call that number. If letter, do random #
                    System.out.println();
                    break;
                case CALL_HISTORY:
                    displayMenu(3);
                    System.out.println("Displaying call history: ");
                    calls.displayLog();
                    System.out.println();
                    break;
                case QUIT_OPTION:
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Please type one of the options in the menu.");

            }
        } while (!userChoice.equals(QUIT_OPTION));
    }


    /**
     * Displays a menu with the options for the user.
     */
    public static void displayMenu ( int selector){

        switch (selector) {
            case 0:
                //Main Menu
                System.out.println("------------------------------");
                System.out.println(MAKE_CALL + ": Make call");
                System.out.println(CONTACT_BOOK + ": Contact Book");
                System.out.println(RECEIVE_CALL + ": Receive Call");
                System.out.println(CALL_HISTORY + ": Call History");
                System.out.println(QUIT_OPTION + ": Quit");
                System.out.println("------------------------------");
                break;
            case 1:
                //Contact Book Sub-menu
                System.out.println("1. Add contact\n2. Edit contact\n3. Delete contact\n4. Display contacts");
                break;

            case 2:
                //Receive Call Sub-menu
                System.out.println("Enter the number that is calling, or the name of a contact: ");
                break;
            case 3:
                //Call History Sub-menu
                break;
            default:
                System.out.println("Please type one of the options in the menu");
        }

    }
}


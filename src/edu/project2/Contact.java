package edu.project2;
//Created by Sean C. on 3/8/2018

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Contains data for a contact including name, number, email, and notes.
 */
public class Contact implements Comparable{

    private String name;
    private String number;
    private String email;
    private String note;
    private FavoriteContactFrame picture;

    public Contact(){
        name = null;
        number = null;
        email = null;
        note = null;
        picture = null;
    }

    public Contact(String name, String number, String email, String note){
        this.name = name;
        this.number = number;
        this.email = email;
        this.note = note;
        picture = null;
    }

    public Contact(String name, String number, String email, String note, String directory){
        this.name = name;
        this.number = number;
        this.email = email;
        this.note = note;
        this.picture = new FavoriteContactFrame(directory, 400, 400, name, number, email, note);
    }

    public void setName(String name){this.name = name;}

    public void setNumber(String number){this.number = number;}

    public void setEmail(String email){this.email = email;}

    public void setNote(String note){this.note = note;}

    public String getNumber(){return this.number;}

    public String getName(){return this.name;}

    public String getEmail(){return this.email;}

    public String getNote(){return this.note;}

    public void displayNotes(){System.out.println(note);}

    public void displayContact() {
        if(picture != null){
            picture.displayContactFrame();
        }else{
            System.out.printf("Name: %s\nNumber: %s\nEmail: %s\nNote: %s\n", name, number, email, note);
        }
    }

    public boolean isEqual(Contact other){
        return other.getNumber().equals(this.number);
    }

    public String toString(){return name;}

    @Override
    public int compareTo(Object o) {
        if(o.getClass().isAssignableFrom(Contact.class)) {
            return ((Contact) o).getName().compareTo(this.getName());
        }
        return 0;
    }

    public static void editContact(Contact c){
        Scanner k  = new Scanner(System.in);
        System.out.println("What would you like to modify?\n" +
                           "1: Name\n2: Number\n3: Email\n4: Note\n0: Done\n>> ");
        int select = k.nextInt();
        switch(select){
            case 1:
                System.out.println("Current Value: "+c.name);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 0:
                break;
            default:
                break;

        }
    }
}

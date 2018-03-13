package edu.project2;

import java.awt.*;
import java.util.List;

/**
 * @author - Sean Curley - seancurley007@gmail.com
 * @author - Hunter Davis - huntertigerdavis@gmail.com
 * @author - Yosselin Velasco - yosselin.velasco98@gmail.com
 *
 * @version - 1.0.0
 * @since - 3/1/2018
 * Contains data for a contact including name, number, email, and notes.
 */
public class Contact implements Comparable{

    private String name;
    private String number;
    private String email;
    private String note;
    private FavoriteContactFrame picture;

    /**
     * Creates a basic Contact object with all private variables set to
     * <b>null</b>.
     */
    public Contact(){
        name = null;
        number = null;
        email = null;
        note = null;
        picture = null;
    }

    /**
     * Creates a Contact object with a name, number, email, and note.
     * @param name String value for the name
     * @param number String value for the phone number
     * @param email String value for the email
     * @param note String value for the note
     */
    public Contact(String name, String number, String email, String note){
        this.name = name;
        this.number = number;
        this.email = email;
        this.note = note;
        picture = null;
    }

    /**
     * Creates a contact object with a name, number, email, note, and picture.
     * @param name String value for the name
     * @param number String value for the phone number
     * @param email String value for the email
     * @param note String value for the note
     * @param directory String value for the relative path to a picture
     */
    public Contact(String name, String number, String email, String note, String directory){
        this.name = name;
        this.number = number;
        this.email = email;
        this.note = note;
        this.picture = new FavoriteContactFrame(directory, 400, 400, name, number, email, note);
    }

    /**
     * Returns the phone number of the given Contact object
     * @return Returns number as a String
     */
    public String getNumber(){return this.number;}

    /**
     * Returns the name of the given Contact object
     * @return Returns the name as a String
     */
    public String getName(){return this.name;}

    /**
     * Returns the email of the given Contact object
     * @return Returns the name as a String
     */
    public String getEmail(){return this.email;}

    /**
     * Returns the notes of the given Contact object
     * @return Returns the notes as a String
     */
    public String getNote(){return this.note;}

    /**
     * Checks for a Contact object with a picture
     * @return Returns boolean value if there is a picture attached or not.
     */
    public boolean hasPicture(){return picture != null;}

    /**
     * Displays the contact object as a Picture, if that is instansiated
     * beyond <b>null</b>.
     */
    public void displayContact() {
        if(picture != null){
            picture.displayContactFrame();
        }else{
            System.out.printf("Name: %s\nNumber: %s\nEmail: %s\nNote: %s", name, number, email, note);
        }
    }

    /**
     * Comparative isEqual method, to check if numbers are equivalent.
     * @param other Another Contact object to compare against
     * @return True if numbers are equal, False if not
     */
    public boolean isEqual(Contact other){
        return other.getNumber().equals(this.number);
    }

    /**
     * Overridden toString method to return the name of the Contact object.
     * @see Object#toString()
     * @return Returns the Contact's name
     */
    public String toString(){return name;}

    /**
     * Overridden compareTo method from Comparable interface to allow for
     * sorting to work properly
     * @see java.util.Collections#sort(List)
     * @param o Other object to test for comparability to a Contact object,
     *          and then to compare between the two based on the lexigraphical
     *          comparison of their names
     * @return Returns value to allow for sorting to work properly
     */
    @Override
    public int compareTo(Object o) {
        if(o.getClass().isAssignableFrom(Contact.class)) {
            return ((Contact) o).getName().compareTo(this.getName());
        }
        return 0;
    }
}

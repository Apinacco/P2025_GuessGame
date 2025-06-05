/**
 * 
 */
package project1;

import java.util.*;

/**
 * InputTaker-class:
 * 
 * The class is responsible for all the tasks related to user inputs.
 * - asking input from a user
 * - checking if the input is valid
 * - modify the result if necessary
 * 
 * @author aichinos
 * @version 5 Jun 2025
 *
 */
public class InputTaker {
    
    static final Scanner scanner = new Scanner(System.in);//use this scanner for all the inputs
                                                          //available for all the classes in this package
    
    //====================================
    
    /**
     * 
     */
    public InputTaker() {
        //Scanner sc = new Scanner(System.in);
        //scanner = sc;
    }
    
    
    /**
     * When closing the game, be sure to close the scanner too.
     */
    public static void closeTheScanner() {
        scanner.close();
    }
    
    
    /**
     * @return user input, which is suitable for int
     * TODO: check if the input is really suitable for int!
     */
    public static int getInt() {
        return scanner.nextInt();
    }
    
    
    /**
     * @return user input as String
     */
    public static String getString() {
        return scanner.nextLine();
    }
    
    
    /**
     * Ask a name from a user
     * @return user input as a String (or null)?
     */
    public static String askName() {
        System.out.println("How should we call you?");
        return scanner.nextLine().trim();
    }
    
    //==========================================================

    /**
     * @param args not in use
     */
    public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    }

}

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
 * @version 6 Jun 2025
 *
 */
public class InputTaker {
    
    static final Scanner scanner = new Scanner(System.in);//use this scanner for all the inputs
                                                          //available for all the classes in this package
    
    //====================================
    
    @SuppressWarnings("javadoc")
    public InputTaker() {
        //
    }
    
    
    /**
     * When closing the game, be sure to close the scanner too.
     */
    public static void closeTheScanner() {
        scanner.close();
    }
    
    
    /**
     * @return user input, which is suitable for int
     * TODO: check the range??
     */
    public static int getInt() {
        
        while(true) {
            
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());
                System.out.println("Input should be a number, try again.");
                scanner.nextLine();//Note! Clear the invalid input
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                System.out.println("Something went wrong, try again.");
                scanner.nextLine();
            } 
        }
    }
    
    
    /**
     * @return user input as String
     */
    public static String getString() {
        return scanner.nextLine().trim();
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
        
        while(true) {
            System.out.println("Any input");
            String test = getString();
            if (test.equals("end")) {
                break;
            }
            System.out.println(test);            
        }
        System.out.println("Scanner closes");
        closeTheScanner();
    }

}

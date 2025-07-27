package project1;

import java.util.*;

/**
 * InputHandler-class:
 * 
 * The class is responsible for all the tasks related to user inputs.
 * - asking input from a user
 * - checking if the input is valid
 * - modify the result if necessary
 *
 */
public class InputHandler implements UserInput {
    
    private final Scanner scanner = new Scanner(System.in);
    
    //====================================
    
    @SuppressWarnings("javadoc")
    public InputHandler() {  }
    
    
    /**
     * When closing the game, make sure to close the scanner too.
     */
    public void closeTheScanner() {
        scanner.close();
    }
    
    
    /**
     * @return user input, which is suitable for int
     * 
     * @example
     * <pre name="test">
     * #import java.io.ByteArrayInputStream;
     * #import java.io.InputStream;
     * InputStream originalSource = System.in;
     * 
     *  try {
     *      System.setIn(new ByteArrayInputStream("3\n".getBytes()));
     *      InputHandler ih = new InputHandler();
     *      assertEquals(3, ih.readInt());
     *      
     *      System.setIn(new ByteArrayInputStream("au7\n7\n".getBytes()));
     *      ih = new InputHandler();
     *      assertEquals(7, ih.readInt());
     *      ih.closeTheScanner();
     *      
     *  } finally {
     *      System.setIn(originalSource);
     *  }
     *
     * </pre>
     */
    @Override
    public int readInt() {
        
        while(true) {
            
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input: Please enter a number");
                scanner.nextLine();//Note! nextInt() is like next(), does not automatically move to the new line
            } catch (NoSuchElementException err) {
                System.out.println("Error: " + err.getMessage());
                scanner.nextLine();
            }
        }
    }
    
    
    @Override
    public boolean confirmNameChange(String newName) {
        System.out.println("Your name will be changed into "  + newName );
        System.out.println("OK/Confirm >> press 1");
        System.out.println("No/Cancel >> press 0");
       
        return readInt() == 1;
    }
    
    
     /**
     * @return user input as String
     * 
     * @example
     * <pre name="test">
     * #import java.io.ByteArrayInputStream;
     * #import java.io.InputStream;
     * InputStream originalSource = System.in;
     * 
     *     try {
     *         System.setIn(new ByteArrayInputStream("neko\n2\n".getBytes()));
     *         InputHandler reader = new InputHandler();
     *         assertEquals("neko", reader.readPlayerName());
     *         assertEquals("2", reader.readPlayerName());
     *         reader.closeTheScanner();
     *     } finally {
     *         System.setIn(originalSource);
     *     }
     *     
     *</pre>
     */
    @Override
    public String readPlayerName() {
        String name = scanner.nextLine().trim();
        if (Player.isValidName(name)) return name;
        return Player.getDefaultName();
    }
    
    
    /**
     * @example
     * <pre name="test">
     * #import java.io.ByteArrayInputStream;
     * #import java.io.InputStream;
     * InputStream originalIn = System.in;
     *     try {
     *         System.setIn(new ByteArrayInputStream("1\n".getBytes()));
     *         InputHandler ih = new InputHandler();
     *         assertTrue(ih.wantToPlay());
     *         
     *         System.setIn(new ByteArrayInputStream("0\n".getBytes()));
     *         ih = new InputHandler();
     *         assertFalse(ih.wantToPlay());
     *     } finally {
     *         System.setIn(originalIn);
     *     }
     * 
     * </pre>
     */
    @Override
    public boolean wantToPlay() {
        int n = this.readInt();
        return n == 1;
    }
    

    
}







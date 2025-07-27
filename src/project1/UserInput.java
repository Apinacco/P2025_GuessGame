package project1;

/**
 * UserInput-interface:
 * 
 * Defines methods for handling all user input operations;
 * such as reading player names, confirming actions, and
 * reading numerical guesses.
 * 
 * Responsibilities:
 * - Read player input from the console
 * - Validate and return user choices for game actions
 * 
 */
public interface UserInput {//defines the functions 
    
    /**
     * Confirms whether the player wants to change their name
     * @param newName the name that the user input
     * @return true if a player chooses to change the name
     */
    boolean confirmNameChange(String newName);
    
    /**
     * Reads and returns the player's name input
     * @return User input
     */
    String readPlayerName();
    
    /**
     * Checks if the player wants to start or continue the game
     * @return true is the player chooses to continue the game
     */
    boolean wantToPlay();
    
    
    /**
     * Reads and returns an integer value from user input
     * @return int user input
     */
    int readInt();

}

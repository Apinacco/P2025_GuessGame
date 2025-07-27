package project1;

/**
 * ConsoleOutput interface:
 * 
 * Defines methods for handling all console output operations,
 * such as displaying messages, prompts, game rules, and error notifications.
 * 
 * Responsibilities:
 * - Display messages and prompts to the player
 * - Provide game instructions and feedback
 * - Handle user-facing communication
 */
public interface ConsoleOutput {

    /**
     * Prints a message followed by a new line
     * @param msg the message to display
     */
    void print(String msg);
    
    /**
     * Displays the initial welcome message to the player
     */
    void showWelcomeMessage();
    
    /**
     * Greets the player by name
     * @param name player's name
     */
    void greetThePlayer(String name);
    
    /**
     * Displays an error message when the player's name is invalid
     */
    void warnInvalidName();
    
    
    /**
     * Displays the game rules, including the guessing range
     * @param min the minimum number of the range
     * @param max the maximum number of the range
     */
    void showGameRule(int min, int max);
    
    /**
     * Displays the range from which the number will be picked
     * @param min the minimum number of the range
     * @param max the maximum number of the range
     */
    void showRange(int min, int max);
    
    
    /**
     * Displays a prompt asking if the player wants to start the game
     */
    void doYouWantToPlay();
    
    /**
     * Displays a prompt asking the player to enter a guess
     */
    void askTheGuess();
    
    
    /**
     * Displays a prompt asking if the player wants to start a new game session
     */
    void startNewSession();

    /**
     * Displays a closing message at the end of the game
     */
    void showEndMessage();
    
    
}

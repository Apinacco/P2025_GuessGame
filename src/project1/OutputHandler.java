package project1;

/**
 * The OutputHandler class is responsible for managing 
 * all console-based outputs in the game. It implements the ConsoleOutput 
 * interface and provides methods to display messages, instructions, 
 * and game-related information to the player.
 *
 * Responsibilities:
 * - Display game messages and prompts to the user
 * - Provide feedback for invalid input
 * - Show game rules and range details
 */
public class OutputHandler implements ConsoleOutput {
    
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }
    
    
    /**
     * Prints a blank line to the console for visual separation
     */
    public void printLinebreak() {
        System.out.println();
    }
    
    
    @Override
    public void warnInvalidName() {
        print("Invalid input: the default name is used as your name this time.");
    }


    @Override
    public void showWelcomeMessage() {
        print("Welcom to the Guess Game! What's your name?");
    }

    
    @Override
    public void showGameRule(int min, int max) {
        printLinebreak();
        print("===========================");
        print("Game's rule:\nGuess what is the picked number with as few guesses as you can.");
        showRange(min, max);
        print("===========================");
        printLinebreak();
    }


    @Override
    public void greetThePlayer(String name) {
        print("Hello, " + name + "!");
    }


    @Override
    public void doYouWantToPlay() {
        print("Yes/Confirm >> press 1");
        print("No/Exit >> press any other number");
    }


    @Override
    public void showEndMessage() {
        print("See you soon!");
    }


    @Override
    public void askTheGuess() {
        print("What could be the number? >> ");
        printLinebreak();
    }


    @Override
    public void startNewSession() {
        print("Do you want to play a new session?");
        
    }

    
    @Override
    public void showRange(int min, int max) {
        String range = String.format("A number will be picked randomly between %d to %d.", min, max);
        print(range);
        
    }
}

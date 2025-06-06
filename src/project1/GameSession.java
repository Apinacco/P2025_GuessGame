/**
 * 
 */
package project1;

import java.util.Random;

/**
 * @author aichinos
 * @version 6 Jun 2025
 */
public class GameSession {

    private int counter;//how many times have the player guessed
    private int answer;//this round's answer
    private Player player;
    
    final static int min = 1;
    final static int max = 20;

//=======================================================
    
    /**
     * Create one round of the game
     */
    public GameSession() {
        newSession();
    }
    
    
    /**
     * This method can be used to reset the session and/or simply start a new round at the beginning
     */
    public void newSession() {
        int n = pickTheAnswer();
        setAnswer(n);
        this.counter = 0;
    }
    
    
    /**
     * Restart the session from count zero, with a new answer
     */
    public void reStartSession() {
        if (wantToRestart()) {
            newSession();
        }
    }
    
    
    /**
     * Pick randomly one number from 1 to 20
     */
    private int pickTheAnswer() {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    
    
    /**
     * @return this round's answer
     * @example
     * <pre name="test">
     *    GameSession answerTest = new GameSession();
     *      answerTest.setAnswer(14); answerTest.getAnswer() === 14;
     *      answerTest.setAnswer(2); answerTest.getAnswer() === 2; 
     * 
     */
    public int getAnswer() {
        return this.answer;
    }
    
    /**
     * @param n randomly picked number
     */
    public void setAnswer(int n) {
        this.answer = n;
    }
    
    
    /**
     * @return how many times the player has guessed in this round
     * @example
     * <pre name="test">
     *     GameSession scoreTest = new GameSession();
     *         scoreTest.getScore() === 0;
     *         
     *         scoreTest.setScore(2); scoreTest.getScore() === 2;
     *         scoreTest.setScore(-4); scoreTest.getScore() === 2;
     *         scoreTest.setScore(0); scoreTest.getScore() === 2;
     */
    public int getScore() {
        return this.counter;
    }
    
    /**
     * set the value of a counter, made for testing 
     * @param n value that I want to assign to the counter
     */
    public void setScore(int n) {
        if (n > 0) {
            this.counter = n;
        }
    }
    
    
    /**
     * @return true, if a player wants to start a new session
     */
    public boolean wantToRestart() {
        System.out.println("Do you want to reset the whole session?");
        System.out.println("Yes/Confirm >> press 1");
        System.out.println("No/Cancel >> press 0");
        
        int input = InputTaker.getInt();
        if (input == 1) {
            System.out.println("Reset the counter and the new answer is picked.\n");
            return true;
        }
        return false;
    }
    
    
    /**
     * @param player1 the player of the session
     * TODO: make into smaller functions!
     * 
     */
    public void play(Player player1) {
        
        this.player = player1;
        
        infoMessage();
        
        System.out.println("What would it be? >> \n");
        askUsersGuess();
        
        endSession();
    }

    /**
     * Show the guiding message to the player
     */
    private void infoMessage() {
        System.out.printf("One number is picked radomly from %d to %d.\n", min, max);
    }
    
    

    private void askUsersGuess() {
        
        int n = InputTaker.getInt();
        this.counter += 1;
        int check = whereIsTheAnswer(n);
        
        while (check != 0) {
            n = InputTaker.getInt();
            check = whereIsTheAnswer(n);
            this.counter++;
        }
    }


    
    /**
     * @param n
     * @return 0, if the player guessed right
     *         1, if the player's guess is larger than the answer
     *        -1, if the player's guess is smaller than the answer
     */
    private int whereIsTheAnswer(int n) {
        if (n == getAnswer()) {
            System.out.println("Yes, that's it!");
            return 0;
        } else if(n > getAnswer()) {
            System.out.println("Nope, too big.");
            return 1;
        }
        System.out.println("Nope, too small.");
        return -1;
    }
    
    
    private void endSession() {
        System.out.println();
        showSessionSummary();
    }
    
    
    /**
     * Save the current round's result to the player object
     */
    private void saveTheResult() {
        
        int previousScore = getBestScore();
        if (this.counter < previousScore) {
            System.out.println("New record!");
            player.setBestScore(this.counter);
        }
    }


    private int getBestScore() {
        return player.getBestScore();
    }


    /**
     * After the player got the answer, show a brief summary of the session
     */
    private void showSessionSummary() {
        
        System.out.println("======== Result ========");
        System.out.println("Player: " + this.getPlayerName());
        System.out.printf("You used %d guesses to hit the answer.\n", this.counter);
        
        saveTheResult();
        
        System.out.println("Your best: " + getBestScore() + " guesses");//TODO: check if the score is better than the previous tries
        System.out.println("========================\n");
        
    }

    
    private String getPlayerName() {
        return player.getName();
    }


//================================================================================

    /**
     * @param args not in use
     */
    public static void main(String[] args) {
        GameSession test = new GameSession();
        System.out.println(test.getAnswer());
        test.play(new Player("NekoTest"));
    }

}

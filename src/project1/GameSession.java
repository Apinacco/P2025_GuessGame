/**
 * 
 */
package project1;



/**
 * @author aichinos
 * @version 4 Jun 2025
 * 
 * < One game round >
 *  Roles are:
 *
 */
public class GameSession {

    private int counter;
    private int answer;//this round's answer
    
    final static int minimum = 1;
    final static int maximun = 20;

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
        return minimum + (int) (Math.random()*maximun);
    }
    
    
    /**
     * @return this round's answer
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
     */
    public int getScore() {
        return this.counter;
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
            System.out.println("Reset the counter and the new answer is picked.");
            return true;
        }
        return false;
    }
    
    
    /**
     * 
     */
    public void play() {
        infoMessage();
        
        System.out.println("What would it be? >> \n");
        int n = InputTaker.getInt();
        this.counter += 1;//counter = 1;
        int check = whereIsTheAnswer(n);
        
        while (check != 0) {
            n = InputTaker.getInt();
            check = whereIsTheAnswer(n);
            //TODO: show the hint according to the player's guess
            this.counter++;
        }
        //when check = 0
        endSession();
    }


    /**
     * Show the guiding message to the player
     */
    private void infoMessage() {
        System.out.printf("One number is picked radomly from %d to %d.\n", minimum, maximun);
    }
    
    
    /**
     * 
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
        System.out.println("Congratulations!");
        //TODO:
        //show the result of the game in summary, + ask another round??
    }
    
    
    
    /**
     * @param args not in use
     */
    public static void main(String[] args) {
        GameSession test = new GameSession();
        System.out.println(test.getAnswer());
        test.play();
    }

}

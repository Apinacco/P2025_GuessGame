package project1;

import java.util.Random;


/**
 * The GameSession class handles one full round of the guessing game.  
 *
 * Responsibilities:
 * - Generate a random answer within the given range
 * - Accept and validate player guesses, providing hints
 * - Track the number of attempts and update best scores
 * - Show a summary of the round and manage game settings (range, restart, etc.)
 * 
 */
public class GameSession {

    private int counter;
    private int answer;
    private Player player;
    private ConsoleOutput output;
    private UserInput input;
    
    private int min = 1;
    private int max = 20;

//=======================================================
    
    /**
     * Creates a new game session round with input and output handlers
     * @param input InputHandler instance to read user input
     * @param output ConsoleOutput instance for displaying messages 
     */
    public GameSession(InputHandler input, ConsoleOutput output) {
        this.input = input;
        this.output = output;
    }
    
    
    /**
     * Resets the guess counter to zero at the start of a new session
     */
    public void newSession() {
        this.counter = 0;
    }
    
    
    /**
     * Returns the current answer number for this round
     * @return the answer number
     * 
     * @example
     * <pre name="test">
     * #import static org.mockito.Mockito.*;
     * InputHandler mockIH = mock(InputHandler.class);
     * ConsoleOutput mockCO = mock(ConsoleOutput.class);
     * 
     *    GameSession answerTest = new GameSession(mockIH, mockCO);
     *      assertEquals(0, answerTest.getAnswer());
     *      answerTest.setAnswer(14); assertEquals(14, answerTest.getAnswer());
     *      answerTest.setAnswer(2); assertEquals(2, answerTest.getAnswer()); 
     * 
     * </pre>
     */
    public int getAnswer() {
        return this.answer;
    }
    
    /**
     * Sets the answer number to be guessed in this round
     * @param n the number to set as answer
     */
    public void setAnswer(int n) {
        this.answer = n;
    }
    
    
    /**
     * Returns the number of guesses made in the current round
     * @return how many times the player has guessed in this round
     * 
     * @example
     * <pre name="test">
     * #import static org.mockito.Mockito.*;
     * InputHandler mockIH = mock(InputHandler.class);
     * ConsoleOutput mockCO = mock(ConsoleOutput.class);
     * 
     *  GameSession scoreTest = new GameSession(mockIH, mockCO);
     *  when(mockIH.readInt()).thenReturn(1);
     *  
     *  assertEquals(0, scoreTest.getScore());
     *      scoreTest.setScore(-2);
     *  assertEquals(0, scoreTest.getScore());
     *      scoreTest.setScore(5);
     *  assertEquals(5, scoreTest.getScore());
     *      scoreTest.newSession();
     *  assertEquals(0, scoreTest.getScore());
     *  
     * </pre>
     */
    public int getScore() {
        return this.counter;
    }
    
    
    /**
     * Sets the guess counter to a specified value (used mainly for testing)
     * @param n the value to set as the guess count, must be positive
     */
    public void setScore(int n) {
        if (n > 0) {
            this.counter = n;
        }
    }
    
    
    /**
     * Asks the player if they want to start a new session
     * Note: this method is not used or cannot used at the moment, 
     *       since a player does not have given a choice to restart.
     * @return true if player wants to restart, false otherwise
     * 
     * @example
     * <pre name="test">
     * #import static org.mockito.Mockito.*;
     * InputHandler mockIH = mock(InputHandler.class);
     * ConsoleOutput mockCO = mock(ConsoleOutput.class);
     * 
     *  GameSession askToRestartTest = new GameSession(mockIH, mockCO);
     *      when(mockIH.readInt()).thenReturn(1);
     *      assertTrue(askToRestartTest.askToRestart());
     *      
     *      when(mockIH.readInt()).thenReturn(6);
     *      assertFalse(askToRestartTest.askToRestart());
     * </pre>
     */
    public boolean askToRestart() {
        output.startNewSession();
        output.doYouWantToPlay();
        
        return input.readInt() == 1;
        
    }
    
    
    /**
     * Plays through one full round of the game, managing guesses and feedback
     * @example
     * <pre name="test">
     * #import static org.mockito.Mockito.*;
     * InputHandler mockIH = mock(InputHandler.class);
     * ConsoleOutput mockCO = mock(ConsoleOutput.class);
     * 
     *  GameSession sessionTest = new GameSession(mockIH, mockCO);
     *      sessionTest.setAnswer(10);
     *      when(mockIH.readInt()).thenReturn(3, 5, 7, 10);
     *      sessionTest.playOneSession();
     *      
     *      assertEquals(4, sessionTest.getScore());
     *      verify(mockCO, atLeastOnce()).askTheGuess();
     *      verify(mockCO, atLeastOnce()).print(contains("too small"));
     *      verify(mockCO, atLeastOnce()).print(contains("Yes"));
     * 
     * </pre>
     */
    public void playOneSession() {
        this.newSession();//set a counter 0
        output.askTheGuess();
        getTheGuess();
    }
    

    /**
     * Reads and processes player guesses until the correct answer is found
     * 
     * @example
     * <pre name="test">
     * #import static org.mockito.Mockito.*;
     * InputHandler mockIH = mock(InputHandler.class);
     * ConsoleOutput mockCO = mock(ConsoleOutput.class);
     * 
     *  GameSession guessLoopTest = new GameSession(mockIH, mockCO);
     *      guessLoopTest.setAnswer(10);
     *      when(mockIH.readInt()).thenReturn(3, 15, 10);
     *      guessLoopTest.getTheGuess();
     *      assertEquals(3, guessLoopTest.getScore());
     *      
     * </pre>
     */
    public void getTheGuess() {
        
        int guess;
        int checking;
        
        do {
            guess = input.readInt();
            checking = checkTheAnswer(guess);
            this.counter += 1;
        } while (checking != 0);
    }


    
    /**
     * Checks a player's guess against the answer and gives feedback
     * @param n the guessed number
     * @return 0, if the player guessed right
     *         1, if the player's guess is larger than the answer
     *        -1, if the player's guess is smaller than the answer
     *        
     * @example
     * <pre name="test">
     * #import static org.mockito.Mockito.*;
     * InputHandler mockIH = mock(InputHandler.class);
     * ConsoleOutput mockCO = mock(ConsoleOutput.class);
     * 
     *   GameSession answerCheck = new GameSession(mockIH, mockCO);
     *    answerCheck.setAnswer(10); assertEquals(10, answerCheck.getAnswer());
     *    
     *    assertEquals(-1, answerCheck.checkTheAnswer(5));
     *    assertEquals(0, answerCheck.checkTheAnswer(10));
     *    assertEquals(1, answerCheck.checkTheAnswer(15));
     *    
     *    answerCheck.setAnswer(1);
     *    assertEquals(1, answerCheck.checkTheAnswer(5));
     *    assertEquals(1, answerCheck.checkTheAnswer(2));
     *    assertEquals(0, answerCheck.checkTheAnswer(1));
     *    
     * </pre>
     */
    public int checkTheAnswer(int n) {
        if (n == answer) {
            output.print("Yes, that's it!");
            return 0;
        } else if(n > answer) {
            output.print("Nope, too big.");
            return 1;
        }
        output.print("Nope, too small.");
        return -1;
    }
    
    
    /**
     * Ends the current game session and displays a summary of results
     */
    public void endSession() {
        showSummary();
    }
    
    
    /**
     * Saves the current round's result as the player's best score
     * if it beats the previous best
     */
    private void saveBestScore() {
        
        int previousScore = getBestScore();
        if (this.counter < previousScore) {
            output.print("New record!");
            player.isNewBest(this.counter);
        }
    }


    /**
     * Retrieves the player's current best score
     * @return the player's best score
     */
    private int getBestScore() {
        return player.getBestScore();
    }


    /**
     * Displays a summary of the current session,
     * including player name, guess count, and best score.
     */
    private void showSummary() {
        
        output.print("\n======== Result ========");
        output.print("Player: " + this.getPlayerName());
        output.print(String.format("You used %d guesses to hit the answer.\n", this.counter));
        
        saveBestScore();
        
        output.print("Your best: " + getBestScore() + " guesses");//TODO: check if the score is better than the previous tries
        output.print("========================\n");
        
    }

    
    /**
     * Returns the player's name
     * @return player's name
     */
    public String getPlayerName() {
        if (player == null) {
            return "Not yet created.";
        }
        return player.getName();
    }
    
    
    /**
     * Creates a new player with the given name
     * @param enteredName read by Scanner
     * 
     * @example
     * <pre name="test">
     *  #import static org.mockito.Mockito.*;
     * InputHandler mockIH = mock(InputHandler.class);
     * ConsoleOutput mockCO = mock(ConsoleOutput.class);
     * 
     *   GameSession playerTest = new GameSession(mockIH, mockCO);
     *      assertEquals("Not yet created.", playerTest.getPlayerName());
     *      playerTest.createPlayer("Summer");
     *      assertEquals("SUMMER", playerTest.getPlayerName());
     */
    public void createPlayer(String enteredName) {
        
        this.player = new Player(enteredName);
    }

    
    /**
     * Returns the minimum number in the guessing range
     * @return min
     */
    public int getMin() {
        return this.min;
    }
    
    /**
     * Sets the minimum number for the guessing range
     * @param n new minimun
     */
    public void setMin(int n) {
        this.min = n;
    }
    
    
    /**
     * Returns the maxmum number in the guessing range
     * @return man
     */
    public int getMax() {
        return this.max;
    }
    
    
    /**
     * Sets the maxmum number for the guessing range
     * @param n proposed number as a new maxinum
     */
    public void setMax(int n) {
        if (this.min > n) {
            output.print("Check what is set to be the minimun.");
            return;
        }
        this.max = n;
    }

    
    /**
     * Sets both the minimum and maximum numbers for the guessing range.
     * If max < min, swaps the values.
     * 
     * @param newMin proposed new minimun number of the range
     * @param newMax proposed new maximun number of the range
     * 
     * @example
     * <pre name="test">
     * #import static org.mockito.Mockito.*;
     * InputHandler mockIH = mock(InputHandler.class);
     * ConsoleOutput mockCO = mock(ConsoleOutput.class);
     * 
     *   GameSession rangeTest = new GameSession(mockIH, mockCO);
     *      rangeTest.setRange(0, 10);
     *      assertEquals(0, rangeTest.getMin());
     *      assertEquals(10, rangeTest.getMax());
     *      
     *      rangeTest.setRange(17, -2);
     *      assertEquals(-2, rangeTest.getMin());
     *      assertEquals(17, rangeTest.getMax());
     */
    public void setRange(int newMin, int newMax) {
        if (newMax - newMin < 0) {
            this.min = newMax;
            this.max = newMin;
        } else {
            this.min = newMin;
            this.max = newMax;
        }
        
        output.showRange(this.min, this.max);
    }


    /**
     * Picks a new random number within the current range [min, max]
     * @return randomly pucked a number between minimun and maximun (both inclusive)
     * 
     * @example
     * <pre name="test">
     * #import static org.mockito.Mockito.*;
     * InputHandler mockIH = mock(InputHandler.class);
     * ConsoleOutput mockCO = mock(ConsoleOutput.class);
     * 
     *   GameSession randomTest = new GameSession(mockIH, mockCO);
     *      randomTest.setMin(1);
     *      randomTest.setMax(10);
     *      for(int i=0; i<10; i++){
     *          int num = randomTest.pickNewNum();
     *          assertTrue(num >= 1 && num <= 10);
     *       }
     *       
     *      randomTest.setMin(1);
     *      randomTest.setMax(1);
     *      for(int i=0; i<5; i++){
     *          int num = randomTest.pickNewNum();
     *          assertEquals(1, num);
     *       }
     *       
     * 
     * </pre>
     */
    public int pickNewNum() {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

}

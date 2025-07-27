/**
 * 
 */
package project1;


/**
 * The Player class represents a game participant and stores their information,
 * such as name and best score. It provides methods to validate player names,
 * track the best score achieved, and handle default values.
 * 
 * Responsibilities:
 * - Maintain player details (name, best score)
 * - Validate input for player name
 * - Update and retrieve the best score
 */
public class Player {
    
    private String name = "";
    @SuppressWarnings("javadoc")
    public static final String DEFAULT_NAME = "NEKO";
    private int bestScore = 10000;
    
    
//==============================================================
    
   /**
    * Creates a Player instance with the provided name. 
    * If the name is invalid, assigns a default name.
    * 
    * @param enteredName name that a player entered
    * @example
    * <pre name="test">
    *    Player player1 = new Player("kaori");
    *        assertEquals("KAORI", player1.getName());
    *        player1.toString() === "Player name: KAORI | Best score: 10000";
    *            assertTrue(Player.isValidName("kaori"));
    *            assertFalse(Player.isValidName(""));             // blank, invalid
    *            assertFalse(Player.isValidName(" "));            // blank, invalid
    *            assertFalse(Player.isValidName(null));           // null, invalid
    *            assertFalse(Player.isValidName("a".repeat(31))); // too long, invalid
    *    Player player2 = new Player(null);
    *        assertFalse(Player.isValidName(null));
    *        assertEquals("NEKO", player2.getName());
    *        player2.toString() === "Player name: NEKO | Best score: 10000";
    *    Player player3 = new Player("YUKO");
    *        assertEquals("YUKO", player3.getName());
    *        player3.toString() === "Player name: YUKO | Best score: 10000";
    */
    public Player(String enteredName) {
        
        if (isValidName(enteredName)) {
            this.name = enteredName.toUpperCase();
        } else {
            this.name = DEFAULT_NAME;
        }
    }
    
    
    /**
     * Checks whether the provided name is valid as a player's name
     * @param enteredName proposed player name
     * @return true if the proposed name is valid
     * 
     */
    public static boolean isValidName(String enteredName) {
        if (enteredName == null || enteredName.isBlank() || enteredName.length() > 30) {
            return false;
        } 
        return true;
    }
    
    
    @Override
    public String toString() {
        StringBuilder line = new StringBuilder(String.format("Player name: %s | Best score: %d", this.name, this.bestScore));
        return line.toString();
    }
    
//=================================================
    
    
    /**
     * Retrieves the player's name
     * @return player's name
     * @example
     * <pre name="test">
     *   Player getNameTest = new Player("");
     *      assertEquals("NEKO", getNameTest.getName());
     *   Player getNameTest2 = new Player("uyHu");
     *      assertEquals("UYHU", getNameTest2.getName());
     */
    public String getName() {
        return this.name;
    }
    
    
    /**
     * Retrieves the player's best score
     * @return player's best score
     * @example
     * <pre name="test">
     * 
     *     Player scoreTest = new Player("score");
     *         assertEquals(10000, scoreTest.getBestScore());
     *         scoreTest.isNewBest(10); assertEquals(10, scoreTest.getBestScore());
     *         scoreTest.isNewBest(24); assertEquals(10, scoreTest.getBestScore());
     *         scoreTest.isNewBest(-5); assertEquals(10, scoreTest.getBestScore());
     */
    public int getBestScore() {
        return this.bestScore;
    }
    
    /**
     * Updates the best score if the new score is lower and greater than zero.
     * @param newScore new best score
     * @return true if a new best is set
     */
    public boolean isNewBest(int newScore) {
        if (this.bestScore > newScore && newScore > 0) {
            this.bestScore = newScore;
            return true;
        }
        return false;
    }
    
    
    /**
     * Retrieves the default player name used when no valid name is provided
     * @return setted default name
     */
    public static String getDefaultName() {
        return DEFAULT_NAME;
    }
    
    
    // Future feature: Track session attempts for each player
    // private int[] results;
    // TODO: Implement or remove placeholder methods
}

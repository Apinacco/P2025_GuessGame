/**
 * 
 */
package project1;

/**
 * @author aichinos
 * @version 6 Jun 2025
 * 
 */
public class Player {
    
    private String name = "";//player's name
    private static final String defaultName = "NEKO";
    
    private int bestScore = 10000;
    private int tried;//how many sessions have the player played
    
//==============================================================
    
    /**
     * Create a player class with a name that a user picked
     * @param name String input
     * @example
     * <pre name="test">
     *  Player a = new Player("a");
     *      a.toString() === "Player name: A | Best score so far: 10000";
     *  Player b = new Player("aB");
     *      b.toString() === "Player name: AB | Best score so far: 10000";
     *  Player c = new Player();
     *      c.toString() === "Player name: NEKO | Best score so far: 10000";
     */
    public Player(String name) {
        if (name.isBlank() || name.isEmpty()) {
            this.name = defaultName;
        } else {
            this.name = name.toUpperCase();
        }
    }
    
    
    /**
     * Create a player with the default name
     */
    public Player() {
        this.name = defaultName;
    }
    
    
    @Override
    public String toString() {
        String line = String.format("Player name: %s | Best score so far: %d", this.name, this.bestScore);
        return line;
    }
    
//=================================================
    
    
    /**
     * @return player's name
     * @example
     * <pre name="test">
     *   Player nameTest1 = new Player();
     *      nameTest1.getName() === "NEKO";
     *   Player nameTest2 = new Player("uyHu");
     *      nameTest2.getName() === "UYHU";
     */
    public String getName() {
        return this.name;
    }
    
    
    /**
     * @param newName new name for a player
     * TODO: Test-writing!!!
     */
    public void setName(String newName) {
        String changedName = newName.toUpperCase();
        boolean wantsToChange = confirmTheWish(changedName);
        if (wantsToChange) {
            this.name = changedName;
            System.out.println("Your name has been changed. New name: " + getName());
        }
        return;
    }


    /**
     * Ask confirmation from a player
     * @param newName candidate of a new name
     * @return true if a player accept a change
     * TODO: how to write a test for this??
     */
    private boolean confirmTheWish(String newName) {
        System.out.println("Your name will be changed into "  + newName );
        System.out.println("OK/Confirm >> press 1");
        System.out.println("No/Cancel >> press 0");
        
        int n = InputTaker.getInt();
            
        if (n == 1) {
                return true;
        }
        return false;
    }
    
    
    /**
     * @return player's best score
     * @example
     * <pre name="test">
     *     Player scoreTest1 = new Player();
     *         scoreTest1.getBestScore() === 10000;
     *         scoreTest1.setBestScore(10); scoreTest1.getBestScore() === 10;
     *         scoreTest1.setBestScore(24); scoreTest1.getBestScore() === 10;
     *         scoreTest1.setBestScore(-5); scoreTest1.getBestScore() === 10;
     */
    public int getBestScore() {
        return this.bestScore;
    }
    
    /**
     * @param n new best score
     */
    public void setBestScore(int n) {
        if (this.bestScore > n && n > 0) {
            this.bestScore = n;
        }
    }
    
    
    /**
     * @return how many sessions have the player played
     * TODO: Create a function for this variable or delete!!
     */
    public int getTried() {
        return this.tried;
    }
    
    /**
     * @param n set how many time the played have played the session
     */
    public void setTried(int n) {
        if (n >= 0) {
            this.tried = n;
        }
    }

}

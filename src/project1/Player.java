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
     *  a.toString() === "Player name: A | Best score so far: 10000";
     *  
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
     */
    public String getName() {
        return this.name;
    }
    
    
    /**
     * @param newName new name for a player
     */
    public void setName(String newName) {
        boolean wantsToChange = confirmTheWish(newName);
        if (wantsToChange) {
            this.name = newName;
            System.out.println("Your name has been changed. New name: " + getName());
        }
        return;
    }


    /**
     * Ask confirmation from a player
     * @param newName candidate of a new name
     * @return true if a player accept a change
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
    
    
    /*public void setDefaultName(String newDefault) {
        this.defaultName = newDefault;
    }*/
    
    
    /**
     * @return player's best score
     */
    public int getBestScore() {
        return this.bestScore;
    }
    
    
    /**
     * @param n new best score
     */
    public void setBestScore(int n) {
        if (this.bestScore > n) {
            this.bestScore = n;
        }
    }
    
    
    /**
     * @return how many sessions have the player played
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
    
    
    //===========================================0
    
    @SuppressWarnings("javadoc")
    public static void main(String[] args) {
        Player tester = new Player("John");
        System.out.println(tester.tried);
        System.out.println(tester.bestScore);
        
        tester.setBestScore(3);
        System.out.println(tester.bestScore);
    }

}

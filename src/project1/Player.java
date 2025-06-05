/**
 * 
 */
package project1;

/**
 * @author aichinos
 * @version 4 Jun 2025
 * 
 * < Player >
 *  Roles are:
 *
 */
public class Player {
    
    private String name = "";//player's name
    private static final String defaultName = "Neko";
    
    private int bestScore;
    private int tried;//how many sessions have the player played
    
//==============================================================
    
    /**
     * Create a player class with a name that a user picked
     * TODO: how to check if the player's input is valid or not 
     * @param name String input
     */
    public Player(String name) {
        if (name.isBlank() || name.isEmpty()) {
            this.name = defaultName;
        } else {
            this.name = name;
        }
    }
    
    
    /**
     * Create a player with the default name
     */
    public Player() {
        this.name = defaultName;
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
        
        try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
            int n = sc.nextInt();
            
            if (n == 1) {
                return true;
            }
        }
        return false;
    }
    
    
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

}

/**
 * 1. personal project
 * Level: basic
 */
package project1;



/**
 * @version 27 Jul 2025
 *
 * This class is a launcher.
 * 
 * Refactor suggestions:
 * - Add session history to Player
 * - Add JSON save/load --> プレイ結果のログ（平均回数、ベストスコア）
 * - Support multiplayer
 *
 * - UI development (e.g. using JavaFX)
 */
public class GuessGame {
    
    
    @SuppressWarnings("javadoc")
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.start();
    }
    
}



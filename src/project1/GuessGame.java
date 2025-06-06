/**
 * 1. personal project
 * Level: basic
 */
package project1;



/**
 * @author aichinos
 * @version 28 May 2025
 *
 *
 * Future plans:
 *  - プレイ結果のログ（平均回数、ベストスコア）
 *  - 複数プレイヤー対応（プレイヤーをクラスにする）
 *  
 *  feedbacks/development:
 * - GameSession.play() の分離と読みやすさ改善
 * - InputTaker に範囲付きの数値取得追加   
 *
 *
 * ==============================
 * 
 * 発展
 * - ログファイルに結果の書き出し
 * - タイマー
 * - GUI化、アプリにしてみる
 */
public class GuessGame {
    
    private static boolean startPlaying = false;
    
    private Player player;
    private GameSession session;
    
    //==============================================================

    /**
     * @param args not in use
     */
    public static void main(String[] args) {
    
        GuessGame game = new GuessGame();
        
        game.greetings();
        
        showTheGameRule();
        
        startPlaying = doYouWantToPlay();
        game.takeActions(startPlaying);
        
        if (startPlaying) {
            System.out.println("\nAnother round?");
            startPlaying = doYouWantToPlay();
            game.takeActions(startPlaying);
        }
        
        game.endTheGame();
        return;
    }

    
    //================================================================
    
    /**
     * 
     */
    public GuessGame() {
        session = new GameSession();
    }
    
    
    private void play(Player person) {
        session.newSession();
        session.play(person);
    }

    
    /**
     * At the end of the game, be sure to close the scanner.
     */
    public void endTheGame() {
        InputTaker.closeTheScanner();
        return;
    }


    /**
     * Welcoming message for the player
     */
    private void greetings() {
        System.out.println("Welcome to the Guessing Game!");
        System.out.println();
        
        String enteredName = InputTaker.askName();
        if(!enteredName.isEmpty() && !enteredName.isBlank()) {
            player = new Player(enteredName); 
        } else {
            System.out.println("Invalid input, the default name will be used.");
            player = new Player();
        }
        System.out.println();
        System.out.println("Hello, " + player.getName() + "!");
    }
    
    
    /**
     * At the beginning show the instructions for a player
     */
    private static void showTheGameRule() {
        
        System.out.println("This is a guessing-game.\nGuess the number with as few guesses as you can.");
    }
    
    
    /**
     * @param reaction if this is true, the player want to play another round
     */
    private void takeActions(boolean reaction) {
        
        if (!reaction) {
            System.out.println("Good bye!");
            this.endTheGame();
            return;
        }
        
        System.out.println("Let's go!\n");
        this.play(this.player);
    }
    
    
    
    /**
     * Ask a confirmation, whether the player wants to play or not
     * @return true, if a player inputs 1 
     */
    private static boolean doYouWantToPlay() {
        
        System.out.println("Yes >> Press 1 \nNo/End the game >> Press any other number");
        
        int n = InputTaker.getInt();
        if (n == 1) {
            return true;
        }
        return false;
    }


}



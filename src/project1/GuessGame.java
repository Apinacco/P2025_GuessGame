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
 * 2.6. plans:
 *  - リプレイ機能をつける（「もう一度遊びますか？」）
 *  - プレイ結果のログ（平均回数、ベストスコア）
 *  - 複数プレイヤー対応（プレイヤーをクラスにする）
 *  
 *  feedbacks:
 *  1. counterの使い方      現在、counterが**static（クラス全体）**で、ループ内でも ++ しており、やや混乱を生みます。
 *                         staticにするなら**「累計のプレイ回数」など、プレイごとに蓄積される意味**をもたせた方が混乱が少ないです。
 *      
 *  2. クラス設計の意図の明確化    現在、player や youWon がすべて static であるため、「ゲーム＝1人で1回きりのプレイ」という前提になります。
 *                             今後の練習のためにも、インスタンス変数を使って「1人のプレイヤーが何度も遊ぶ」形に拡張するのもおすすめです。
 *                             
 *  3. 小さなロジック改善提案  =   doYouWantToPlay() の入力バリデーション
 *                            現在 nextInt() のみを使用しており、文字を打つとクラッシュします。   
 *
 *
 * ==============================
 * 
 * OOPの練習として拡張する案
 * - 複数のクラスに役割をわける　例）GuessGame, Player, GameSession
 * - 複数回プレイ、勝率や平均試行回数の記録
 * - カプセル化、getter, setterの使用
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
     * Constructor
     */
    public GuessGame() {
        session = new GameSession();
    }
    
    
    private void play() {
        session.play();
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
    
    
    
    private void takeActions(boolean reaction) {
        
        if (!reaction) {
            System.out.println("Good bye!");
            this.endTheGame();
            return;
        }
        //startPlaying = true
        System.out.println("Let's go!");
        this.play();
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



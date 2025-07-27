package project1;


/**
 * The GameController class manages the overall game flow, including:
 *     - Initializing and starting the game
 *     - Handling user interactions (play again or exit)
 *     - Managing game sessions and delegating tasks to the GameSession
 *
 * Responsibilities:
 * - Control the game loop (start, repeat, end)
 * - Interact with InputHandler and OutputHandler
 * - Create and manage the player via the session
 *
 */
public class GameController {
    
    private final ConsoleOutput output;
    private final InputHandler input;
    private GameSession session;
    
    private boolean startPlaying;
    private boolean hasPlayed = false;
    
    
    //=============================================
    
    
    /**
     * Constructs a GameController with custom input and output handlers
     * @param input InputHandler class
     * @param output Interface OutputHandler
     */
    public GameController(InputHandler input, OutputHandler output) {
        this.input = input;
        this.output = output;
        this.session = new GameSession(input, output);
    }

    
    /**
     * Constructs a GameController with default input and output handlers
     */
    public GameController() {
        this(new InputHandler(), new OutputHandler());
    }
    
    
    /**
     * Sets the game session manually (useful for testing or custom session handling)
     * @param session GameSession instance 
     */
    public void setSession(GameSession session) {
        this.session = session;
    }
    
    
    /**
     * @example
     * <pre name="test">
     * #import static org.mockito.Mockito.*;
     * InputHandler mockIH = mock(InputHandler.class);
     * OutputHandler mockOH = mock(OutputHandler.class);
     * GameSession mockSession = mock(GameSession.class);
     * GameController controller = new GameController(mockIH, mockOH);
     * GameController spyController = spy(controller);
     * spyController.setSession(mockSession);
     *  
     *  when(mockIH.wantToPlay()).thenReturn(true, true, false);
     *  when(mockIH.readPlayerName()).thenReturn("Tester");
     *  when(mockSession.getPlayerName()).thenReturn("TESTER");
     *  doNothing().when(spyController).startSession();
     *  spyController.start();
     *  
     *  verify(spyController, times(2)).startSession();
     *  verify(mockSession).endSession();
     *  verify(mockIH).closeTheScanner();
     *  verify(mockOH).showEndMessage();
     * 
     * </pre>
     */
    public void start() {
        
        greetThePlayer();
        
        while(true) {
            output.doYouWantToPlay();
            startPlaying = input.wantToPlay();
            if (startPlaying) {
                hasPlayed = true;
                output.print("Let's start!\n");
                
                startSession();
                
                output.print("\nAnother round?");
            } else {
                break;
            }
        }
        
        if (hasPlayed) {
            session.endSession();
        }
        
        input.closeTheScanner();
        output.showEndMessage();
    }


    
    /**
     * Starts a single game session
     * 
     * @example
     * <pre name="test">
     * #import static org.mockito.Mockito.*;
     * InputHandler mockIH = mock(InputHandler.class);
     * OutputHandler mockOH = mock(OutputHandler.class);
     * GameSession mockSession = mock(GameSession.class);
     *  GameController startTest = new GameController(mockIH, mockOH);
     *  startTest.setSession(mockSession);
     *  
     *  when(mockSession.pickNewNum()).thenReturn(10);
     *  
     *  startTest.startSession();
     *  
     *  verify(mockSession).setAnswer(10);
     *  verify(mockSession).playOneSession();
     * 
     * </pre>
     */
    public void startSession() {
        int n = session.pickNewNum();
        session.setAnswer(n);
        session.playOneSession();
    }


    /**
     * Greets the player and shows the game rules
     * 
     * @example
     * <pre name="test">
     * #import static org.mockito.Mockito.*;
     * InputHandler mockIH = mock(InputHandler.class);
     * OutputHandler mockOH = mock(OutputHandler.class);
     * GameSession mockSession = mock(GameSession.class);
     *  GameController greetTest = new GameController(mockIH, mockOH);
     *  
     *  when(mockIH.readPlayerName()).thenReturn("Neko");
     *  when(mockSession.getPlayerName()).thenReturn("NEKO");
     *  greetTest.greetThePlayer();
     *  
     *  verify(mockOH).warnInvalidName();
     *  verify(mockOH).greetThePlayer(eq(Player.getDefaultName()));
     *  
     * </pre>
     */
    public void greetThePlayer() {
        
        output.showWelcomeMessage();
        String name = input.readPlayerName().toUpperCase();
        
        session.createPlayer(name);
        if (session.getPlayerName().equals(Player.getDefaultName())) {
            output.warnInvalidName();
        }
        
        output.greetThePlayer(session.getPlayerName());
        output.showGameRule(session.getMin(), session.getMax());
    }

}

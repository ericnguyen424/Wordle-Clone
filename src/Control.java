import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This will be the main control class that runs the game and transmits information between classes
 * Eric Nguyen, ericnguy@bu.edu
 */
public class Control implements KeyListener {
    private GameState gameState;
    private GUI gui;
    private WordleMain wordleMain;
    private String wordsPath;

    /**
     * Constructor for the control class
     */
    public Control() {
        this.wordsPath = "textFiles/five.txt";
        this.gameState = new GameState(wordsPath);
        this.gui = new GUI(gameState);
        this.gameState.setGUI(gui);
        this.wordleMain = new WordleMain(gameState, gui);
    }

    /**
     * Main run function
     */
    public void run() {
        //Initializing gameState and GUI
        GameState gameState = new GameState(wordsPath);
        GUI gui = new GUI(gameState);
        gui.setFocusable(true);  // Make the GUI focusable
        gui.requestFocusInWindow();  // Set focus to the GUI

        gameState.setGUI(gui);

        //This is the format of the game
            //Wrap all of this in a do while loop
                //Construct a new WordleMain
                //Call the displayWelcomeMessage TODO: Remove this
                //Call enterUserGuess
            //while (getHasWon is false)

        WordleMain wordleMain = new WordleMain(gameState, gui);
        wordleMain.displayWelcomeMessage();

        gui.addKeyListener(this);

        do {
            wordleMain.enterUserGuess();

        } while(!wordleMain.getHasWon());

    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyCode());
        //When each key is pressed, check if the KeyPressed is in the alphabet and number of characters is less than 5
        if (Character.isAlphabetic(e.getKeyChar()) && gameState.getCurrentCharCount() < 5) {
            //Edit the gameBoard at position (currentGuess (row), currentChar (column)) to be the keyChar
            gameState.editGameBoard(gameState.getGuessCount() - 1, gameState.getCurrentCharCount(), e.getKeyChar());
            gameState.addCurrentCharCount(1);
            System.out.println("Character typed!!");
            gui.repaint();

            //if it isnt in the alphabet, check if the keypressed is the backspace or enter button
        } else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
            if (gameState.getCurrentCharCount() != 0) {
                gameState.addCurrentCharCount(-1);
                gameState.editGameBoard(gameState.getGuessCount() - 1, gameState.getCurrentCharCount(),
                        '\u0000'); //"Delete" the character at the current position
                System.out.println("Backspace typed!!");
                gui.repaint();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            //TODO: Implement this function
            System.out.println("Enter typed!!");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

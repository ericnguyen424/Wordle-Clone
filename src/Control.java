/**
 * This will be the main control class that runs the game and transmits information between classes
 * Eric Nguyen, ericnguy@bu.edu
 */
public class Control {
    private GameState gameState;
    private GUI gui;
    private WordleMain wordleMain;
    private String wordsPath;

    /**
     * Constructor for the control class
     */
    public Control() {
        this.gameState = new GameState();
        this.gui = new GUI(gameState);
        this.gameState.setGUI(gui);
        this.wordsPath = "textFiles/five.txt";
        this.wordleMain = new WordleMain(wordsPath, gameState, gui);
    }

    /**
     * Main run function
     */
    public void run() {
        //Initializing gameState and GUI
        GameState gameState = new GameState();
        GUI gui = new GUI(gameState);
        gameState.setGUI(gui);

        //This is the format of the game
            //Wrap all of this in a do while loop
                //Construct a new WordleMain
                //Call the displayWelcomeMessage TODO: Remove this
                //Call enterUserGuess
            //while (getHasWon is false)

        WordleMain wordleMain = new WordleMain(wordsPath, gameState, gui);
        wordleMain.displayWelcomeMessage();
        do {
            wordleMain.enterUserGuess();

        } while(!wordleMain.getHasWon());

    }
}

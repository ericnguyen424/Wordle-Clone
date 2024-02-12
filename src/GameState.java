import java.awt.*;
import java.util.List;

/**
 * Controls the GameElements
 * Eric Nguyen, Winter 2024
 */
public class GameState {
    //Fields
    private GUI gui;
    private char[][] gameBoard;
    private int guessCount;
    private int currentCharCount;
    private String userGuess;
    private String generatedWord;
    private String pathFile;
    public GameState(String sentPathFile) {
        this.gameBoard = new char[6][5];
        this.pathFile = sentPathFile;
        this.generatedWord = WordleHelper.randomWordSelection(pathFile);
        this.guessCount = 1;
        this.currentCharCount = 0;
    }

    /**
     * Given the coordinates and a newChar, this will update the game board with the info
     * @param row
     * @param column
     * @param newCharacter
     */
    public void editGameBoard(int row, int column, char newCharacter) {
        gameBoard[row][column] = newCharacter;
        gui.repaint();
    }

    /**
     * Accessor for gameBoard
     * @return
     */
    public char[][] getGameBoard() {
        return this.gameBoard;
    }

    /**
     * Mutator for GUI
     */
    public void setGUI(GUI newGUI) {
        this.gui = newGUI;
    }

    /**
     * Accessor for GUI
     */
    public GUI getGUI() {
        return this.gui;
    }

    /**
     * Mutator for userGuess
     * @param newUserGuess
     */
    public void setUserGuess(String newUserGuess) {
        this.userGuess = newUserGuess;
    }

    /**
     * Mutator for guessCount
     * @param increment
     */
    public void addGuessCount(int increment) {
        this.guessCount += increment;
    }

    /**
     * Mutator for generatedWord
     * @param newGeneratedWord
     */
    public void setGeneratedWord(String newGeneratedWord) {
        this.generatedWord = newGeneratedWord;
    }

    /**
     * Accessor for guessCount
     * @return
     */
    public int getGuessCount() {
        return this.guessCount;
    }

    /**
     * Accessor for userGuess
     * @return
     */
    public String getUserGuess() {
        return this.userGuess;
    }

    /**
     * Accessor for generatedWord
     * @return
     */
    public String getGeneratedWord() {
        return this.generatedWord;
    }

    /**
     * Accessor for currentCharCount
     * @return
     */
    public int getCurrentCharCount() { return this.currentCharCount; }

    /**
     * Mutator for currentCharCount
     * @param increment
     */
    public void addCurrentCharCount(int increment) { this.currentCharCount += increment;}

    /**
     * Mutator for pathFile
     * @param newPathFile
     */
    public void setPathFile(String newPathFile) {
        this.pathFile = newPathFile;
    }

    /**
     * Accessor for pathFile
     * @return
     */
    public String getPathFile() {
        return this.pathFile;
    }


    /**
     * Returns char at the given coordinates in the gameBoard
     * @param row
     * @param column
     * @return
     */
    public char getCharGameBoard(int row, int column) {
        return getGameBoard()[row][column];
    }

    public void drawGameBoard(Graphics g) {
        int x = 200;
        int y = 200;
        //I forgot what the fuck I was doing. I think I wanted to make a string so that I could
        //Make it equal. holy shit I am so high I need to erase this later. Holy fuck. I am so high while
        //typing this. I am doing like a practice typing test right now.
        for (int i = 0; )
        //I think the issue has something to do with the for loop.

        g.drawChars(gameBoard[0], 1, 1, x, y);

    }


}

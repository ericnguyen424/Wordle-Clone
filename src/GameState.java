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

    public GameState() {
        this.gameBoard = new char[6][5];
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




}

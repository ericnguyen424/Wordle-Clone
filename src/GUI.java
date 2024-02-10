import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class will handle all of the visual aspects of the game
 * Eric Nguyen
 */
public class GUI extends JPanel implements KeyListener {
    private GameState gameState;
    public GUI(GameState sentGameState) {
        this.gameState = sentGameState;

        JFrame frame = new JFrame("Wordle Clone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(this);

        this.setMinimumSize(new Dimension(1000, 1000));
        this.setPreferredSize(new Dimension(1000, 1000));
        this.setMaximumSize(new Dimension(1000, 1000));
        frame.pack();

        frame.setVisible(true);
        repaint();

    }

    public void paintComponent(Graphics g) {
        char[][] gameBoard = gameState.getGameBoard();
        int x = 200;
        int y = 200;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                g.drawString(String.valueOf(gameBoard[i][j]), x, y);
                x += 10;
            }
            y+= 20;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key typed: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

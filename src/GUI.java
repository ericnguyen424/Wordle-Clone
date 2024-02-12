import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class will handle all of the visual aspects of the game
 * Eric Nguyen
 */
public class GUI extends JPanel {
    private GameState gameState;
    public GUI(GameState sentGameState) {
        this.gameState = sentGameState;

        JFrame frame = new JFrame("Wordle Clone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(this);

        //Setting the size of our frame
        this.setMinimumSize(new Dimension(1000, 1000));
        this.setPreferredSize(new Dimension(1000, 1000));
        this.setMaximumSize(new Dimension(1000, 1000));


        frame.pack();

        frame.setVisible(true);
        repaint();

    }

    public void paintComponent(Graphics g) {
        gameState.drawGameBoard(g);
        System.out.println("paint called");
    }

}

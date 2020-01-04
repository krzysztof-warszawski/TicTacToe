package game;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private GamePanel gamePanel = new GamePanel();

    public GameFrame() {
        setSize(620,745);
        setTitle("TicTacToe");
        setResizable(false);
        setLocationRelativeTo(null);
        add(gamePanel);
        Image icon = Toolkit.getDefaultToolkit().getImage("src/frameIcon.png");
        setIconImage(icon);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }
}


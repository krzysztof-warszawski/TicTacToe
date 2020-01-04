package game;

import javax.swing.*;
import java.awt.*;

class WinFrame extends JFrame {
    private WinPanel winPanel = new WinPanel();

    WinFrame() {
        setTitle("TicTacToe");
        setSize(480, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        add(winPanel);
        Image icon = Toolkit.getDefaultToolkit().getImage("src/frameIcon.png");
        setIconImage(icon);
    }

    WinPanel getWinPanel() {return winPanel;}
}


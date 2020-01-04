package game;

import javax.swing.*;
import java.awt.*;

import static game.Main.startFrame;

class WinPanel extends JPanel {
    private Image image;
    private JButton winMessage;

    WinPanel() {
        setLayout(null);
        image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/winner.gif"));
        winMessage = new JButton();
        winMessage.setBounds(100, 210, 270, 40);
        winMessage.setFont(winMessage.getFont().deriveFont(20f));
        winMessage.addActionListener(e -> {
            StartPanel startPanel = new StartPanel();
            startFrame.setSize(620,745);
            startFrame.panelSwitchOver(startPanel);
        });
        add(winMessage);
    }

    void setWinMessage(String winMessageText) {
        this.winMessage.setText(winMessageText);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }
}

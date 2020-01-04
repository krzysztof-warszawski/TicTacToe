package game;

import javax.swing.*;
import java.awt.*;
//import static game.Main.startFrame;
//import static game.Main.winFrame;

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
            Main.winFrame.setVisible(false);
            Main.startFrame.setVisible(true);
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

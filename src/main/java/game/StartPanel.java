package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static game.Main.startFrame;

class StartPanel extends JPanel {

    private BufferedImage img;
    private ImageIcon playIcon;
    private static JButton play, exit;
    private JLabel gameName, question;

    StartPanel() {
        setLayout(null);
        try {
            img = ImageIO.read(((getClass().getResource("/swords.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        gameName = new JLabel("TicTacToe", SwingConstants.CENTER);
        gameName.setBounds(110, 20, 400, 100);
        gameName.setFont(gameName.getFont().deriveFont(70f));

        question = new JLabel("Do you want to play a game?", SwingConstants.CENTER);
        question.setBounds(60, 320, 500, 100);
        question.setFont(question.getFont().deriveFont(35f));

        playIcon = new ImageIcon(getClass().getResource("/play.png"));
        play = new JButton();
        play.setIcon(playIcon);
        play.setBounds(145, 520, playIcon.getIconWidth(), playIcon.getIconHeight());
        play.setBorder(null);
        play.setContentAreaFilled(false);
        play.addActionListener(e -> {
            NickNamePanel nickNamePanel = new NickNamePanel();
            startFrame.panelSwitchOver(nickNamePanel);
        });

        ImageIcon exitIcon = new ImageIcon(getClass().getResource("/exit.png"));
        exit = new JButton();
        exit.setIcon(exitIcon);
        exit.setBounds(345, 520, exitIcon.getIconWidth(), exitIcon.getIconWidth());
        exit.setBorder(null);
        exit.setContentAreaFilled(false);
        exit.addActionListener(e -> { System.exit(0); });

        add(play);
        add(exit);
        add(gameName);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 85, 80, 450, 450, null);
    }

}

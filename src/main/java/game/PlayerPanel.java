package game;

import javax.swing.*;
import java.awt.*;

//import static game.NickNamePanel.oNickName;
//import static game.NickNamePanel.xNickName;

class PlayerPanel extends JPanel {

    private JLabel playerX, playerO, scoreDisplay;
    private int scoreX;
    private int scoreO;

    PlayerPanel() {
        setLayout(new BorderLayout());

        playerX = new JLabel(NickNamePanel.xNickName.getText(), SwingConstants.CENTER);
        playerX.setPreferredSize(new Dimension(175,50));
        playerX.setFont(playerX.getFont().deriveFont(17f));
        playerX.setOpaque(true);
        playerX.setBackground(Color.decode("#E94141"));

        playerO = new JLabel(NickNamePanel.oNickName.getText(), SwingConstants.CENTER);
        playerO.setPreferredSize(new Dimension(175,50));
        playerO.setFont(playerO.getFont().deriveFont(17f));
        playerO.setOpaque(true);
        playerO.setBackground(Color.decode("#629ACC"));

        scoreDisplay = new JLabel("Score: " + scoreX + "-" + scoreO, SwingConstants.CENTER);
        scoreDisplay.setPreferredSize(new Dimension(250,50));
        scoreDisplay.setFont(scoreDisplay.getFont().deriveFont(20f));
        scoreDisplay.setOpaque(true);
        scoreDisplay.setBackground(Color.LIGHT_GRAY);

        add(playerX, BorderLayout.LINE_START);
        add(scoreDisplay, BorderLayout.CENTER);
        add(playerO, BorderLayout.LINE_END);
    }

    JLabel getScoreDisplay() {return scoreDisplay;}
    int getScoreX() {return scoreX;}
    void setScoreX(int scoreX) {this.scoreX = scoreX;}
    int getScoreO() {return scoreO;}
    void setScoreO(int scoreO) {this.scoreO = scoreO;}
    JLabel getPlayerX() {return playerX;}
    JLabel getPlayerO() {return playerO;}
}

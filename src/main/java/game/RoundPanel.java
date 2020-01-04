package game;

import javax.swing.*;
import java.awt.*;

class RoundPanel extends JPanel {

    private JLabel roundDisplay;
    JButton nextRoundButton;
    private int roundCounter = 1;

    RoundPanel() {
        roundDisplay = new JLabel("Round: " + roundCounter, SwingConstants.CENTER);
        roundDisplay.setPreferredSize(new Dimension(200,50));
        roundDisplay.setFont(roundDisplay.getFont().deriveFont(17f));
        roundDisplay.setOpaque(true);
        roundDisplay.setBackground(Color.LIGHT_GRAY);

        nextRoundButton = new JButton("Next round");
        nextRoundButton.setVisible(false);
        nextRoundButton.setPreferredSize(new Dimension(200,50));

        add(roundDisplay);
        add(nextRoundButton);
    }

    void setNextRoundButtonVisible(boolean b) { //obsługa przycisku Next round
        nextRoundButton.setVisible(b);
    }

    int getRoundCounter() {return roundCounter;}
    void setRoundCounter(int roundCounter) {this.roundCounter = roundCounter;}
    JLabel getRoundDisplay() {return roundDisplay;}
}


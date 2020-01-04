package game;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static game.Main.startFrame;

class BoardPanel extends JPanel {

    PlayerPanel playerPanel = new PlayerPanel();
    RoundPanel roundPanel = new RoundPanel();

    private ImageIcon iconX = new ImageIcon(getClass().getResource("/cross.png"));
    private ImageIcon iconWinnerX = new ImageIcon(getClass().getResource("/crossWinner.png"));
    private ImageIcon iconO = new ImageIcon(getClass().getResource("/nought.png"));
    private ImageIcon iconWinnerO = new ImageIcon(getClass().getResource("/noughtWinner.png"));
    private ImageIcon iconH = new ImageIcon(getClass().getResource("/horizontalLine.png"));
    private ImageIcon iconV = new ImageIcon(getClass().getResource("/verticalLine.png"));
    private ImageIcon iconBackground = new ImageIcon(getClass().getResource("/lightBackground.png"));

    private JLabel horizontalLine1, horizontalLine2, verticalLine1, verticalLine2;
    private JButton one, two, three, four, five, six, seven, eight, nine;
    private List<JButton> buttonList = new ArrayList<>();
    private boolean oneField, twoField, threeField, fourField, fiveField, sixField, sevenField, eightField, nineField;
    private boolean winnerX, winnerO;
    private boolean x = true;

    BoardPanel() {
        setLayout(null);

        verticalLine1 = new JLabel(iconV);
        verticalLine1.setBounds(200,0,10,620);
        verticalLine2 = new JLabel(iconV);
        verticalLine2.setBounds(410,0,10,620);

        horizontalLine1 = new JLabel(iconH);
        horizontalLine1.setBounds(0,200,620,10);
        horizontalLine2 = new JLabel(iconH);
        horizontalLine2.setBounds(0,410,620,10);

        one = new JButton();
        one.setBounds(0, 0, 200, 200);
        one.setOpaque(true);
        one.addActionListener(e -> {
            markField(oneField, one);
            if (!oneField) {
                oneField = true;
                isWinner();
            }
        });

        two = new JButton();
        two.setBounds(0, 210, 200, 200);
        two.setOpaque(true);
        two.addActionListener(e -> {
            markField(twoField, two);
            if (!twoField) {
                twoField = true;
                isWinner();
            }
        });

        three = new JButton();
        three.setBounds(0, 420, 200, 200);
        three.setOpaque(true);
        three.addActionListener(e -> {
            markField(threeField, three);
            if (!threeField) {
                threeField = true;
                isWinner();
            }
        });

        four = new JButton();
        four.setBounds(210, 0, 200, 200);
        four.addActionListener(e -> {
            markField(fourField, four);
            if (!fourField) {
                fourField = true;
                isWinner();
            }
        });

        five = new JButton();
        five.setBounds(210, 210, 200, 200);
        five.addActionListener(e -> {
            markField(fiveField, five);
            if (!fiveField) {
                fiveField = true;
                isWinner();
            }
        });

        six = new JButton();
        six.setBounds(210, 420, 200, 200);
        six.addActionListener(e -> {
            markField(sixField, six);
            if (!sixField) {
                sixField = true;
                isWinner();
            }
        });

        seven = new JButton();
        seven.setBounds(420, 0, 200, 200);
        seven.addActionListener(e -> {
            markField(sevenField, seven);
            if (!sevenField) {
                sevenField = true;
                isWinner();
            }
        });

        eight = new JButton();
        eight.setBounds(420, 210, 200, 200);
        eight.addActionListener(e -> {
            markField(eightField, eight);
            if (!eightField) {
                eightField = true;
                isWinner();
            }
        });

        nine = new JButton();
        nine.setBounds(420, 420, 200, 200);
        nine.addActionListener(e -> {
            markField(nineField, nine);
            if (!nineField) {
                nineField = true;
                isWinner();
            }
        });

        // wypełnienie ArrayList<JButton> buttonList
        buttonList.add(one);
        buttonList.add(two);
        buttonList.add(three);
        buttonList.add(four);
        buttonList.add(five);
        buttonList.add(six);
        buttonList.add(seven);
        buttonList.add(eight);
        buttonList.add(nine);

        for (JButton jb : buttonList) {
            jb.setIcon(iconBackground);
        }

        add(horizontalLine1);
        add(horizontalLine2);
        add(verticalLine1);
        add(verticalLine2);
        add(one);
        add(two);
        add(three);
        add(four);
        add(five);
        add(six);
        add(seven);
        add(eight);
        add(nine);

        // dodanie akcji dla przycisku Next Round
        roundPanel.nextRoundButton.addActionListener(e -> {
            resetAll();
            roundPanel.setRoundCounter(roundPanel.getRoundCounter() + 1); // dodanie +1 do liczby rund
            roundPanel.getRoundDisplay().setText("Round: " + roundPanel.getRoundCounter()); // wypisanie kolejnej rundy
            roundPanel.setNextRoundButtonVisible(false); // ukrycie przycisku Next round
        });
    }

    private void blockTheBoard() { //blokada pól po wygranej jednego z graczy
        oneField = true;
        twoField = true;
        threeField = true;
        fourField = true;
        fiveField = true;
        sixField = true;
        sevenField = true;
        eightField = true;
        nineField = true;
    }

    private void resetAll() { // czyści pola przed kolejną rundą
        x = true;
        winnerX = false;
        winnerO = false;
        oneField = false;
        twoField = false;
        threeField = false;
        fourField = false;
        fiveField = false;
        sixField = false;
        sevenField = false;
        eightField = false;
        nineField = false;
        for (JButton jb : buttonList) {
            jb.setIcon(iconBackground);
        }
    }

    private void markField(boolean fieldName, JButton buttonName) {
        if (!fieldName) {
            if (x) {
                buttonName.setIcon(iconX);
                x = false;
            } else {
                buttonName.setIcon(iconO);
                x = true;
            }
        }
    }

    private void isDraw() {
        if (oneField && twoField && threeField && fourField && fiveField && sixField && sevenField && eightField
                && nineField) {
            roundPanel.setNextRoundButtonVisible(true);
        }
    }

    private void isWinnerX() {
        try {
            if (one.getIcon().equals(iconX) && two.getIcon().equals(iconX) && three.getIcon().equals(iconX)) {
                winnerX = true;
                one.setIcon(iconWinnerX);
                two.setIcon(iconWinnerX);
                three.setIcon(iconWinnerX);
            } else if (four.getIcon().equals(iconX) && five.getIcon().equals(iconX) && six.getIcon().equals(iconX)) {
                winnerX = true;
                four.setIcon(iconWinnerX);
                five.setIcon(iconWinnerX);
                six.setIcon(iconWinnerX);
            } else if (seven.getIcon().equals(iconX) && eight.getIcon().equals(iconX) && nine.getIcon().equals(iconX)) {
                winnerX = true;
                seven.setIcon(iconWinnerX);
                eight.setIcon(iconWinnerX);
                nine.setIcon(iconWinnerX);
            } else if (one.getIcon().equals(iconX) && four.getIcon().equals(iconX) && seven.getIcon().equals(iconX)) {
                winnerX = true;
                one.setIcon(iconWinnerX);
                four.setIcon(iconWinnerX);
                seven.setIcon(iconWinnerX);
            } else if (two.getIcon().equals(iconX) && five.getIcon().equals(iconX) && eight.getIcon().equals(iconX)) {
                winnerX = true;
                two.setIcon(iconWinnerX);
                five.setIcon(iconWinnerX);
                eight.setIcon(iconWinnerX);
            } else if (three.getIcon().equals(iconX) && six.getIcon().equals(iconX) && nine.getIcon().equals(iconX)) {
                winnerX = true;
                three.setIcon(iconWinnerX);
                six.setIcon(iconWinnerX);
                nine.setIcon(iconWinnerX);
            } else if (one.getIcon().equals(iconX) && five.getIcon().equals(iconX) && nine.getIcon().equals(iconX)) {
                winnerX = true;
                one.setIcon(iconWinnerX);
                five.setIcon(iconWinnerX);
                nine.setIcon(iconWinnerX);
            } else if (seven.getIcon().equals(iconX) && five.getIcon().equals(iconX) && three.getIcon().equals(iconX)) {
                winnerX = true;
                seven.setIcon(iconWinnerX);
                five.setIcon(iconWinnerX);
                three.setIcon(iconWinnerX);
            }
            if (winnerX) {
                roundPanel.setNextRoundButtonVisible(true); // odkrycie przycisku Next round
                playerPanel.setScoreX(playerPanel.getScoreX() + 1); // dodanie +1 do wyniku X
                playerPanel.getScoreDisplay().setText("Score: " + playerPanel.getScoreX() + "-" + playerPanel.getScoreO()); // wypisanie nowego wyniku
                blockTheBoard();
            }
            if (playerPanel.getScoreX() == 3) {
                WinPanel winPanel = new WinPanel();
                winPanel.setWinMessage("The winner is " + playerPanel.getPlayerX().getText()); // sprawdzenie czy osiągnięto wynik 3, jesli tak to odkrycie winFrame
                startFrame.setSize(480, 290);
                startFrame.panelSwitchOver(winPanel);
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    private void isWinnerO() {
        if (one.getIcon().equals(iconO) && two.getIcon().equals(iconO) && three.getIcon().equals(iconO)) {
            winnerO = true;
            one.setIcon(iconWinnerO);
            two.setIcon(iconWinnerO);
            three.setIcon(iconWinnerO);
        } else if (four.getIcon().equals(iconO) && five.getIcon().equals(iconO) && six.getIcon().equals(iconO)) {
            winnerO = true;
            four.setIcon(iconWinnerO);
            five.setIcon(iconWinnerO);
            six.setIcon(iconWinnerO);
        } else if (seven.getIcon().equals(iconO) && eight.getIcon().equals(iconO) && nine.getIcon().equals(iconO)) {
            winnerO = true;
            seven.setIcon(iconWinnerO);
            eight.setIcon(iconWinnerO);
            nine.setIcon(iconWinnerO);
        } else if (one.getIcon().equals(iconO) && four.getIcon().equals(iconO) && seven.getIcon().equals(iconO)) {
            winnerO = true;
            one.setIcon(iconWinnerO);
            four.setIcon(iconWinnerO);
            seven.setIcon(iconWinnerO);
        } else if (two.getIcon().equals(iconO) && five.getIcon().equals(iconO) && eight.getIcon().equals(iconO)) {
            winnerO = true;
            two.setIcon(iconWinnerO);
            five.setIcon(iconWinnerO);
            eight.setIcon(iconWinnerO);
        } else if (three.getIcon().equals(iconO) && six.getIcon().equals(iconO) && nine.getIcon().equals(iconO)) {
            winnerO = true;
            three.setIcon(iconWinnerO);
            six.setIcon(iconWinnerO);
            nine.setIcon(iconWinnerO);
        } else if (one.getIcon().equals(iconO) && five.getIcon().equals(iconO) && nine.getIcon().equals(iconO)) {
            winnerO = true;
            one.setIcon(iconWinnerO);
            five.setIcon(iconWinnerO);
            nine.setIcon(iconWinnerO);
        } else if (seven.getIcon().equals(iconO) && five.getIcon().equals(iconO) && three.getIcon().equals(iconO)) {
            winnerO = true;
            seven.setIcon(iconWinnerO);
            five.setIcon(iconWinnerO);
            three.setIcon(iconWinnerO);
        }
        if (winnerO) {
            roundPanel.setNextRoundButtonVisible(true); // odkrycie przycisku Next round
            playerPanel.setScoreO(playerPanel.getScoreO() + 1); // dodanie +1 do wyniku O
            playerPanel.getScoreDisplay().setText("Score: " + playerPanel.getScoreX() + "-" + playerPanel.getScoreO()); // wypisanie nowego wyniku
            blockTheBoard();
        }
        if (playerPanel.getScoreO() == 3) { // sprawdzenie czy osiągnięto wynik 3, jesli tak to odkrycie winFrame
            WinPanel winPanel = new WinPanel();
            winPanel.setWinMessage("The winner is " + playerPanel.getPlayerO().getText());
            startFrame.setSize(480, 290);
            startFrame.panelSwitchOver(winPanel);
        }
    }

    private void isWinner() {
        isWinnerX();
        isWinnerO();
        isDraw();
    }

    PlayerPanel getPlayerPanel() {
        return playerPanel;
    }
}
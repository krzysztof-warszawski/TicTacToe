package game;

import javax.swing.*;

class StartFrame extends JFrame{

    StartFrame() {
        setSize(620,745);
        setTitle("TicTacToe");
        setResizable(false);
        setLocationRelativeTo(null);

        StartPanel startPanel = new StartPanel();
        add(startPanel);

        ImageIcon icon = new ImageIcon(getClass().getResource("/frameIcon.png"));
        this.setIconImage(icon.getImage());
    }

    public void panelSwitchOver(JPanel jPanel) {
        this.getContentPane().removeAll();
        this.add(jPanel);
        this.revalidate();
    }

}

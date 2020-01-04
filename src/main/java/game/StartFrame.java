package game;

import javax.swing.*;

class StartFrame extends JFrame{

    StartFrame() {
        setSize(600, 735);
        setTitle("Main Menu");
        setResizable(false);
        setLocationRelativeTo(null);

        StartPanel startPanel = new StartPanel();
        add(startPanel);

        ImageIcon icon = new ImageIcon(getClass().getResource("/frameIcon.png"));
        this.setIconImage(icon.getImage());
    }
}

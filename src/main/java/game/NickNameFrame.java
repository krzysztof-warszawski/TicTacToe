package game;

import javax.swing.*;

class NickNameFrame extends JFrame {

    NickNameFrame() {
        setSize(600, 735);
        setTitle("Nicknames");
        setResizable(false);
        setLocationRelativeTo(null);
        NickNamePanel nickNamePanel = new NickNamePanel();
        add(nickNamePanel);
    }
}


package game;

import javax.swing.*;
import java.awt.*;

public class Main {

    static StartFrame startFrame = new StartFrame();

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            // music
            game.MusicClass musicObject = new game.MusicClass();
            
            startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            startFrame.setVisible(true);
            musicObject.playMusic();
        });
    }
}
/*
 * Apps/games:
 *
 * Place the attribution on the credits/description page of the application.
 * SWORDS >>> https://www.flaticon.com/free-icon/swords_1021261
 */
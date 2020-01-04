package game;

import javax.swing.*;
import java.awt.*;

public class Main {

    static StartFrame startFrame = new StartFrame();
    static NickNameFrame nickNameFrame = new NickNameFrame();
    static GameFrame gameFrame = new GameFrame();
    static WinFrame winFrame = new WinFrame();
    static MusicClass musicObject = new MusicClass();
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            // music
//            game.MusicClass musicObject = new game.MusicClass();


            startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            startFrame.setVisible(true);
            musicObject.playMusic();
            nickNameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            nickNameFrame.setVisible(false);
            gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameFrame.setVisible(false);
            winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            winFrame.setVisible(false);
        });
    }
}
/*
 * Apps/games:
 *
 * Place the attribution on the credits/description page of the application.
 * SWORDS >>> https://www.flaticon.com/free-icon/swords_1021261
 */
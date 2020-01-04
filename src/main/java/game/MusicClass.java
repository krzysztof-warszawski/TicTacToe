package game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

class MusicClass {

    private static String filePath = "/music.wav";

    void playMusic() {

        try {
            File musicPath = new File(MusicClass.filePath);
//            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(getClass().getResource(filePath));
                Clip clip = AudioSystem.getClip();

                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);

//            } else
//                System.out.println("THERE IS NO MUSIC");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

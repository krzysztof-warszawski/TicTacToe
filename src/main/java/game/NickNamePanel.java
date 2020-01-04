package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

//import static game.Main.gameFrame;
//import static game.Main.nickNameFrame;

public class NickNamePanel extends JPanel {

    private ImageIcon icon = new ImageIcon(getClass().getResource("/play.png"));
    private BufferedImage img;
    private JLabel nickName;
    private static JButton playGame;
    static JTextField xNickName, oNickName;

    public NickNamePanel() {
        setLayout(null);

        try {
            img = ImageIO.read(getClass().getResource("/swords.png")
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
        playGame = new JButton();
        playGame.setIcon(icon);
        playGame.setBounds(235,520,icon.getIconWidth(),icon.getIconHeight());
        playGame.setBorder(null);
        playGame.setContentAreaFilled(false);
        playGame.addActionListener(e -> {
            Main.gameFrame.setVisible(true);
            Main.nickNameFrame.setVisible(false);
            Main.gameFrame.getGamePanel().getBoardPanel().getPlayerPanel().getPlayerX().setText(xNickName.getText());
            Main.gameFrame.getGamePanel().getBoardPanel().getPlayerPanel().getPlayerO().setText(oNickName.getText());
        });

        nickName = new JLabel("ENTER YOUR NICKNAMES:");
        nickName.setFont(nickName.getFont().deriveFont(20f));
        nickName.setBounds(170,5,600,45);

        xNickName = new JTextField("PLAYER X");
        xNickName.setHorizontalAlignment(JTextField.CENTER);
        xNickName.setBounds(120,50,110,45);

        oNickName = new JTextField("PLAYER O");
        oNickName.setHorizontalAlignment(JTextField.CENTER);
        oNickName.setBounds(365,50,110,45);

        add(oNickName);
        add(xNickName);
        add(nickName);
        add(playGame);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 75, 80, 450, 450, null);
    }
}

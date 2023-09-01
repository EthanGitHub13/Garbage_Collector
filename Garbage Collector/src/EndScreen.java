import javax.swing.*;
import java.awt.*;

public class EndScreen extends JPanel {
    int goldAppleCount = 0;
    int greyAppleCount = 0;

    JLabel scoreL;

    ImageIcon goldApple = new ImageIcon("src/Resource/Pixel_Gold_Apple.png");
    public EndScreen(int score){
        this.setSize(900,1000);
        this.setBackground(Color.BLACK);
        scoreL = new JLabel("Score: " + score);
        this.add(scoreL);

        if (score > 8){
            goldAppleCount = 3;
        }
        else if (score < 8 && score > 4){
            goldAppleCount = 2;
            greyAppleCount = 1;
        }
        else if (score < 4 && score > 0){
            goldAppleCount = 1;
            greyAppleCount = 2;
        }
        else{
             goldAppleCount = 0;
             greyAppleCount = 3;
        }

    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.orange);
        g.fillRect(0,0,900,1000);
        goldApple.paintIcon(this, g, 190, 100);
        goldApple.paintIcon(this, g, 390, 100);
        goldApple.paintIcon(this, g, 590, 100);
    }

}

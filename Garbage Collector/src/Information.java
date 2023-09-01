import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Information extends JTextPane implements KeyListener {
    ImageIcon icon = new ImageIcon("src/Resource/Pixel_Carrot.png");
    Font f1 = new Font(Font.MONOSPACED,Font.BOLD,30);
    Font f2 = new Font(Font.MONOSPACED,Font.PLAIN, 20);

    boolean visible = false;

    public Information(){
        this.setPreferredSize(new Dimension(500,500));
        this.setFont(f2);
        this.setText("""
                RECYCLABLES [1]
                Recyclables like plastics, paper, and
                cans must be placed within blue bins
                to be remade into new items for use
                
                ORGANICS [2]
                Organics like food waste or yard waste
                must be placed within the green bins to
                ensure proper treatment for compost
                
                LANDFILL [3]
                Waste like clothing or food wrappers
                must be placed within the grey bins to be
                sent to the landfill because they cannot
                be recycled or decomposed easily
                """);

    }

    public boolean getVisibility(){
        return visible;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_I){
            visible = !visible;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

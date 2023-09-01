import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

public class GarbageBin extends Rectangle2D.Double implements KeyListener {
    int score;
    Color color;
    String materialType;

    double width = 200;
    double height = 200;


    double defaultVelocity = 7;
    double defaultAcceleration = 1.3;

    double velocity;

    ImageIcon currentIcon;
    ImageIcon recycleBinIcon = new ImageIcon("src/Resource/Pixel_RecycleBin.png");
    ImageIcon compostBinIcon = new ImageIcon("src/Resource/Pixel_CompostBin.png");
    ImageIcon trashBinIcon = new ImageIcon("src/Resource/Pixel_TrashBin.png");
    public GarbageBin(){
        super(0,800,200,200);
        score = 0;
        color = Color.black;
        materialType = null;

        velocity = defaultVelocity;

        currentIcon = new ImageIcon("src/Resource/Pixel_DefaultBin.png");
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }


    public void collect(){
        score += 1;
    }

    public int getScore(){
        return (score);
    }

    public void changeTypeRecycle(){
        materialType = "Recycle";
        currentIcon = recycleBinIcon;
        color = Color.BLUE;
    }

    public void changeTypeCompost(){
        materialType = "Compost";
        currentIcon = compostBinIcon;
        color = Color.GREEN;
    }

    public void changeTypeTrash(){
        materialType = "Trash";
        currentIcon = trashBinIcon;
        color = Color.GRAY;
    }

    public String getType(){
        return (materialType);
    }

    public Color getColor(){
        return (color);
    }

    public ImageIcon getCurrentIcon(){
        return (currentIcon);
    }

    public boolean inBoundsR(){
        return this.x < 899 - width;
    }

    public boolean inBoundsL(){
        return this.x > 1;
    }

    public boolean manualCollisionCheck(Material m){
        if (m.getY() > this.getY() && m.getRandomXPos() > this.getX() && m.getRandomXPos() < this.getX() + this.getWidth()){
            return true;
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (inBoundsR()){
                // System.out.println(this.x);
                if (velocity < 0){
                    velocity = -velocity;
                }
                this.x += velocity;
                velocity += defaultAcceleration;
            }

        }

        else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT){
            if (inBoundsL()){
                // System.out.println(this.x);
                if (velocity > 0){
                    velocity = -velocity;
                }
                this.x += velocity;
                velocity += defaultAcceleration;
            }
        }


        if (e.getKeyCode() == KeyEvent.VK_1){
            this.changeTypeRecycle();
            System.out.println("Recycle Form!");
        }
        else if (e.getKeyCode() == KeyEvent.VK_2){
            this.changeTypeCompost();
            System.out.println("Compost Form!");
        }
        else if (e.getKeyCode() == KeyEvent.VK_3){
            this.changeTypeTrash();
            System.out.println("Trash Form!");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

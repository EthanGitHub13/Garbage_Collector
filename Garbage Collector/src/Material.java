import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Material extends Rectangle2D.Double {
    double velocity;
    double acceleration;
    int randomXPos;
    String materialType;

    ImageIcon defaultIcon = new ImageIcon("src/Resource/Pixel_Default.png");
    ImageIcon currentIcon;

    ArrayList<ImageIcon> recycleIconList = new ArrayList<ImageIcon>();
    ImageIcon bottleIcon = new ImageIcon("src/Resource/Pixel_Bottle.png");
    ImageIcon sodaIcon = new ImageIcon("src/Resource/Pixel_Soda.png");

    ArrayList<ImageIcon> compostIconList = new ArrayList<ImageIcon>();
    ImageIcon carrotIcon = new ImageIcon("src/Resource/Pixel_Carrot.png");
    ImageIcon chocolateIcon = new ImageIcon("src/Resource/Pixel_Chocolate.png");

    ArrayList<ImageIcon> trashIconList = new ArrayList<ImageIcon>();
    ImageIcon plateIcon = new ImageIcon("src/Resource/Pixel_Plate.png");
    ImageIcon forkIcon = new ImageIcon("src/Resource/Pixel_Fork.png");


    public Material(){
        super(0.0,0.0,64.0,64);
        randomXPos = ((int)(Math.random()*699))+101;
        this.x = randomXPos;

        recycleIconList.add(bottleIcon);
        recycleIconList.add(sodaIcon);

        compostIconList.add(chocolateIcon);
        compostIconList.add(carrotIcon);

        trashIconList.add(plateIcon);
        trashIconList.add(forkIcon);

        currentIcon = defaultIcon;
        materialType = setMaterialType();

        velocity = 0.4;
        acceleration = 0.05;
    }

    public int getRandomXPos(){
        return (randomXPos);
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    public String setMaterialType(){
        int i = ((int)(Math.random()*3))+1;

        if (i == 1){
            // Recycle
            currentIcon = recycleIconList.get((int)(Math.random()*(recycleIconList.size())));
            return ("Recycle");
        }
        else if (i == 2){
            // Compost
            currentIcon = compostIconList.get((int)(Math.random()*(compostIconList.size())));
            return ("Compost");
        }
        else{
            // Trash
            currentIcon = trashIconList.get((int)(Math.random()*(trashIconList.size())));
            return ("Trash");
        }
    }

    public String getMaterialType(){
        return (materialType);
    }

    public ImageIcon getCurrentIcon(){
        return (currentIcon);
    }

    public void gravity(){
        // System.out.println(this.x);
        y += velocity;
        velocity += acceleration;
    }
}

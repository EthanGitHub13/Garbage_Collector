import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyPanel extends JPanel implements ActionListener {
    GarbageBin garbageBin;

    Material m;
    int materialCount = 1;

    ArrayList<Material> materialArrayList = new ArrayList<Material>();

    Timer t = new Timer(17, this);

    Information information = new Information();

    JLabel scoreLabel;
    JLabel infoLabel;

    EndScreen esc;

    // TimerTask task = new timerTask();

    public MyPanel(){
        this.setSize(900,1000);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        garbageBin = new GarbageBin();
        scoreLabel = new JLabel("Score: " + 0 + " Press 'i' for instructions");
        infoLabel = new JLabel("Press 'i' for instructions");
        this.addKeyListener(garbageBin);
        this.addKeyListener(information);

        m = new Material();
        materialArrayList.add(m);

        this.add(scoreLabel);
        this.add(infoLabel);

        this.add(information);
        information.setVisible(false);
        information.setFocusable(false);

        t.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        for (Material material : materialArrayList) {
            // g2d.drawRect(material.getRandomXPos(),(int)material.getY(),(int)material.getWidth(),(int)material.getHeight());
            material.getCurrentIcon().paintIcon(this, g2d, material.getRandomXPos(), (int)material.getY());
        }
        g2d.setColor(garbageBin.getColor());
        // g2d.fillRect((int)garbageBin.getX(), (int)garbageBin.getY(), (int) garbageBin.getWidth(), (int) garbageBin.getHeight());
        garbageBin.getCurrentIcon().paintIcon(this, g2d, (int)garbageBin.getX(),800);
    }

    public void spawnMaterial(){
        materialArrayList.add(new Material());
    }

    public void checkTargetScore(int ts){
        if (this.garbageBin.getScore() == ts){
            scoreLabel.setVisible(false);
            infoLabel.setVisible(false);
            esc = new EndScreen(ts);
            this.add(esc);
            esc.setFocusable(true);
        }
    }

    public void collision(){
        for (int i = 0; i < materialArrayList.size(); i++){
            if (garbageBin.manualCollisionCheck(materialArrayList.get(i))){
                System.out.println("Collided");
                if (materialArrayList.get(i).getMaterialType().equals(garbageBin.getType())){
                    garbageBin.collect();
                    System.out.println(garbageBin.getScore());
                    materialArrayList.remove(i);
                    spawnMaterial();
                    materialCount++;
                    i--;
                }
                else {
                    materialArrayList.remove(i);
                    spawnMaterial();
                    materialCount++;
                    i--;
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Material material : materialArrayList){
            material.gravity();
        }
        collision();
        checkTargetScore(10);

        scoreLabel.setText("Score: " + garbageBin.getScore());
        information.setVisible(information.getVisibility());

        repaint();
    }
}
/*
class timerTask extends TimerTask{

    @Override
    public void run() {

    }
}
*/
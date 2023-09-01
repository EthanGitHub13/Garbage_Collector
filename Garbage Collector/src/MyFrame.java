import javax.swing.*;

public class MyFrame extends JFrame{
    MyPanel panel;

    public MyFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900,1000);
        this.setTitle("Garbage Collector Game");
        this.setLocationRelativeTo(null);

        panel = new MyPanel();
        this.add(panel);
        panel.setFocusable(true);

        this.setVisible(true);
    }
}

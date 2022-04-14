
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Animation extends Thread {

    private Image img;
    private int delay;
    private boolean reverse;

    private JPanel panel;

    public Animation(JPanel parrentComponent , int delay , boolean reverse){
        this.reverse = reverse;
        this.delay = delay;
        panel = parrentComponent;
        this.start();
        
    }

    public Image getFrame(){
        return(img);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        int i = 0;
        while(true){
            try {
                if(reverse == false)
                    img = ImageIO.read(new File("immagini/pulcino/sprite_" + i + ".png"));
                else
                    img = ImageIO.read(new File("immagini/pulcino_reverse/sprite_" + i + ".png"));

                Thread.sleep(delay);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            panel.repaint();
            i++;
            if(i > 14){
                i = 0;
            }
        }
    }
}

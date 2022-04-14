
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pulcino extends JPanel implements Runnable{

    private int x = 0;
    private int y = 0;
    private int mod;

    private boolean reverse;

    private Thread t;

    private JFrame frame;

    private Animation sprite;
    private Animation sprite_reverse;

    public Pulcino(JFrame parentComponent){
        frame = parentComponent;

        sprite = new Animation(this , 100 , false);
        sprite_reverse = new Animation(this, 100, true);


        x = (int) (Math.random() * (frame.getWidth() - 120) + 1);
        y = (int) (Math.random() * (frame.getHeight() - 120) + 1);

        mod = (int) (Math.random() * 6) + 1;

        this.setPreferredSize(new Dimension(100 , 100));
        this.setVisible(true);
        this.setOpaque(false);


        t = new Thread(this);
        t.start();
    }

    public void SelectTypeMod(int mod){
        switch(mod){
            case 1:
                x++;
                reverse = false;
                break;
            case 2:
                x++; y++;
                reverse = false;
                break;
            case 3:
                x++; y--; 
                reverse = false;
                break;
            case 4:
                x--; y--; 
                reverse = true;
                break;
            case 5:
                x--; y++;
                reverse = true;
                break;
            case 6:
                x--; 
                reverse = true;
                break;
            case 7:
                y--; break;
            case 8:
                y++; break;
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        if(reverse == false)
            g.drawImage(sprite.getFrame(), 0, 0, this.getWidth(), this.getHeight(), this);
        else
            g.drawImage(sprite_reverse.getFrame(), 0, 0, this.getWidth(), this.getHeight(), this);
        this.setLocation(x , y);
    }

    @Override
    public void run() {
        while(true){
            SelectTypeMod(mod);
            if(x >= (frame.getWidth() - 110)){
                while(mod <= 3)
                    mod = (int) (Math.random() * 6) + 1;
            }
            if(x <= 0){
                while(mod >= 4 && mod <= 6)
                    mod = (int) (Math.random() * 6) + 1;
            }
            if(y >= (frame.getHeight() - 130)){
                while(mod == 8 || mod == 5 || mod == 2)
                    mod = (int) (Math.random() * 6) + 1;
            }
            if(y <= 0){
                while(mod == 7 || mod == 4 || mod == 3)
                    mod = (int) (Math.random() * 6) + 1;
            }

            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            repaint();
        }
    }
    
}



import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App extends JFrame {

    public App(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400 , 400);

        this.add(new Panel(this));

        this.setVisible(true);

    }

    public class Panel extends JPanel {

        private Image background;
        private JFrame frame;
        public Panel(JFrame parrentComponent ){

            frame = parrentComponent;

            try {
                background = ImageIO.read(new File("immagini/prato2.jpg"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            for(int i = 0 ; i < 5 ; i++){
                this.add(new Pulcino(parrentComponent));
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            // TODO Auto-generated method stub
            super.paintComponent(g);
            g.drawImage(background, 0, 0 , frame.getWidth(), frame.getHeight(), this);
        }
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}

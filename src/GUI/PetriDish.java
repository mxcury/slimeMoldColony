package GUI;

import Sim.Slime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

public class PetriDish extends TimerTask {

    public final static int WIDTH = 960;
    public final static int HEIGHT = 720;

    private final ArrayList<Pixel> pixels = new ArrayList<>();
    public JPanel panel = new JPanel();
    public JLabel picLabel = new JLabel();


    public final JFrame window = new JFrame();
    public JPanel canvas = new JPanel();

    public PetriDish() {


        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Slime Colony Simulation");
        window.setResizable(false);
        window.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        window.add(canvas);

        updateImg();

        canvas.add(panel);

        window.pack();
        window.setVisible(true);
    }

    @Override
    public void run() {
        updateImg();
        window.repaint();
    }

    public void updateImg(){
        randomiseImage();
    }

    private void randomiseImage() {
//        BufferedImage noise = new BufferedImage(WIDTH,HEIGHT,TYPE_INT_ARGB);
//        for(int h = 0; h < HEIGHT; h++){
//            for(int w = 0; w < WIDTH; w++){
//                noise.setRGB(w,h,randomColor().getRGB());
//            }
//        }
//        picLabel.setIcon(new ImageIcon(noise));
        panel.setLayout(new GridLayout(WIDTH,HEIGHT));
        for(int h = 0; h < HEIGHT; h++){
            for(int w = 0; w < WIDTH; w++){
                pixels.add(new Pixel(randomColor()));
                panel.add(pixels.get(h * WIDTH + w));
            }
        }
    }

    private Color randomColor() {
        Random rand = new Random();
        Color col = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
        int red = (int) (rand.nextInt(255) * 0.299);
        int green = (int) (rand.nextInt(255) * 0.587);
        int blue = (int) (rand.nextInt(255) * 0.114);
        return new Color((red+green+blue),(red+green+blue),(red+green+blue));
    }
}

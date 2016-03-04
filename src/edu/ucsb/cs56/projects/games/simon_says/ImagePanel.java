package edu.ucsb.cs56.projects.games.simon_says;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics2D;

public class ImagePanel extends JPanel{

    private BufferedImage image;

    public  BufferedImage resizeImage(BufferedImage image, int width, int height) {
             int type=0;
            type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
            BufferedImage resizedImage = new BufferedImage(width, height,type);
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(image, 0, 0, width, height, null);
            g.dispose();
            return resizedImage;
         }

    public ImagePanel() {
       try {
          image = ImageIO.read(new File("/cs/student/davidwang/cs56/cs56-games-simon-says/src/edu/ucsb/cs56/projects/games/simon_says/Simon_Says_robredeyes2.jpg"));
          image = resizeImage(image,500,125);
      } catch (IOException ex) {
            // handle exception...
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 50, 0, null); // see javadoc for more info on the parameters
    }

}

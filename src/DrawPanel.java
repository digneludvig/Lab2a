

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    HashMap<Car, BufferedImage> imageMap = new HashMap();
    ArrayList<Car> carList;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Car> carList) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.carList = carList;
        
        // Print an error message in case file is not found with a try/catch block
        try {
            String path;
            int count = 0;
            for (Car car : carList) {
                path =  "pics/" + car.toString() + ".jpg";
                BufferedImage image = ImageIO.read(DrawPanel.class.getResourceAsStream(path));
                imageMap.put(car, image);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : imageMap.keySet()) {
            g.drawImage(imageMap.get(car), (int) car.getCurrentPosition().x, (int) car.getCurrentPosition().y,null);
        }
    }

    public Dimension getImageDimesion() {
        return new Dimension(100, 50);
    }
}
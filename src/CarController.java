import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        int y = 0;
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());
        cc.frame = new CarView("CarSim 1.0", cc);
        cc.timer.start();

        for (Car car : cc.cars) {
            car.setCurrentPosition(new Point2D.Double(0,  y));
            y += 100;
        }

    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                if (car.getXPosition() > frame.getX() - frame.getImageDimension().getWidth() || car.getXPosition() < 0) {
                    car.turnLeft();
                    car.turnLeft();
                }
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars)
            car.brake(brake);
    }

    public void setTurboOn(){
        for (Car car : cars) {
            if (car instanceof Saab95)
                ((Saab95) car).setTurboOn();
        }
    }

    public void setTurboOff(){
        for (Car car : cars) {
            if (car instanceof Saab95)
                ((Saab95) car).setTurboOff();
        }
    }

    public void tiltUp(){
        for (Car car : cars){
            if (car instanceof Scania)
                ((Scania) car).tiltUp();
        }
    }

    public void tiltDown(){
        for (Car car : cars){
            if (car instanceof Scania)
                ((Scania) car).tiltDown();
        }
    }

    public void startEngine(){
        for (Car car : cars)
            car.startEngine();
    }

    public void stopEngine(){
        for (Car car : cars)
            car.stopEngine();
    }
}

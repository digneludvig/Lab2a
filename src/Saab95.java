import java.awt.*;

/**
 * Subclass of abstract class Car.
 */
public class Saab95 extends Car {
    /**
     * Instance variable.
     */
    private boolean turboOn;
    /**
     * Method to turn on the turbo.
     */
    public void setTurboOn(){
        turboOn = true;
        System.out.println("Turbo is on!");
    }
    /**
     * Method to turn off the turbo.
     */
    public void setTurboOff(){
        turboOn = false;
        System.out.println("Turbo is off!");
    }

    /**
     * Our constructor for the subclass
     * @param nrDoors Number of doors.
     * @param enginePower Engine power.
     * @param color Color.
     * @param modelName Model name.
     * @param turboOn Boolean for turbo, if it is on or not
     */
    public Saab95(int nrDoors, double enginePower, String modelName, Color color, int carWeight, boolean turboOn) {
        super(nrDoors, enginePower, modelName, color, carWeight);
        this.turboOn = turboOn;
    }

    public Saab95() {
        this(2,120,"Saab95", Color.red, 300, true);
    }

    /**
     * Help method to the increment-/drecrementSpeed method. Overridden from superclass
     * @return Returns the speed factor
     */
    @Override
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
import java.awt.*;

/**
 * Subclass of our superclass Car
 */
public class Volvo240 extends Car {
    /**
     * Instance variable is static, since we're not going to change it later in the program
     */
    private final static double trimFactor = 1.25;

    /**
     * Constructor for our subclass. Parameters described in superclass
     * @param nrDoors Number of doors
     * @param enginePower Engine power
     * @param color Color
     * @param modelName Model name
     */
    public Volvo240(int nrDoors, double enginePower, String modelName, Color color, int carWeight) {
        super(nrDoors, enginePower, modelName, color, carWeight);
    }
    public Volvo240() {
        this(2,125,"Volvo240", Color.red, 300);
    }

    /**
     * Help method to the increment-/decrementSpeed method. Overridden from superclass
     * @return Returns the speed factor
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

}
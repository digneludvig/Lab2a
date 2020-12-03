import java.awt.*;

/**
 * Subclass to Car and an implementation of interface Loader
 */
public class Scania extends Car implements Loader {
    /**
     * The angle of the truck bed
     */
    private int truckBedAngle = 0;

    public Scania(int nrDoors, double enginePower, String modelName, Color color, int carWeight) {
        super(nrDoors, enginePower, modelName, color, carWeight);
    }
    public Scania() {
        this(2,30,"Scania", Color.red, 30000);
    }

    /**
     * Override move function from superclass Car. Can't move unless truck bed angle is equal to zero
     */
    @Override
    public void move(){
        if(truckBedAngle != 0 && getCurrentSpeed() != 0)
            System.out.println("The truck bed must be down to move.");
        else
            super.move();

    }

    /**
     * Tilting up the truck bed with 10 degree. Scania needs to be at rest.
     */
    @Override
    public void tiltUp() {
        if (getCurrentSpeed() == 0) {
            truckBedAngle = Math.min(truckBedAngle + 10, 70);
            System.out.println("Current angle: " + truckBedAngle);
        }
        else
            System.out.println("You must be at a standstill to raise ramp.");

    }
    /**
     * Tilting down the truck bed with 10 degree. Scania needs to be at rest.
     */
    @Override
    public void tiltDown() {
        if (getCurrentSpeed() == 0) {
            truckBedAngle = Math.max(truckBedAngle - 10, 0);
            System.out.println("Current angle: " + truckBedAngle);
        }
        else
            System.out.println("You must be at standstill to lower ramp.");

    }

    @Override
    public void load(Car car) {

    }

    @Override
    public void unload() {

    }

    /**
     * Getter for truckBedAngle.
     * @return truckbedAngle
     */
    public int getTruckBedAngle() { return truckBedAngle; }

    /**
     * Override speedFactor() in car
     * @return The current speed factor of the car
     */
    @Override
    double speedFactor() {
        return getEnginePower() * 0.005;
    }
}

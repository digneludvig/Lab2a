import java.awt.*;
import java.lang.reflect.Array;
import java.math.*;
import java.util.*;
import java.util.List;

public class Transporter extends Car implements Loader {

    /**
     * Appropriate instance variables that define a transporters characteristics.
     */
    private int maxAmountOfCars;
    private int maxWeightCar;
    private final int maxDistanceToLoad = 2;
    private int carCounter = 0;
    private boolean rampUp = true;
    private List<Car> carLoadedList = new ArrayList<>();

    public Transporter(int nrDoors, double enginePower, String modelName, Color color, int carWeight,
                       int maxAmountOfCars, int maxWeightCar) {
        super(nrDoors, enginePower, modelName, color, carWeight);
        this.maxAmountOfCars = maxAmountOfCars;
        this.maxWeightCar = maxWeightCar;
    }

    /**
     * Checks if ramp is up.
     * @return rampUp
     */
    public boolean isRampUp(){
        return rampUp;
    }


    /**
     * Tilts ramp up.
     */
    @Override
    public void tiltUp() {
        rampUp = true;
    }

    /**
     * Tilts ramp down.
     */
    @Override
    public void tiltDown() {
       rampUp = false;
    }

    /**
     * Loads a car on the transporter given certain criterias are met, and adds 1 to carCounter.
     * @param car
     */
    @Override
    public void load(Car car) {
        if (inRange(car) && allowedWeight(car) && isNotFull() && !isRampUp() && notItSelf(car)) {
            carLoadedList.add(0, car);
            carCounter++;
            System.out.println("Car successfully loaded!");
        } else
            throw new RuntimeException("Requirements to load are not met.");
    }
    /**
     * Removes the last added car and places it near the transporter.
     */
    @Override
    public void unload() {
        if (!isRampUp() && carLoadedList.size() != 0) {
            Car carBeingRemoved = carLoadedList.get(0);
            carLoadedList.remove(0);
            carBeingRemoved.setXPosition((int) getCurrentPosition().getX() - 2);
            carBeingRemoved.setYPosition((int) getCurrentPosition().getY());
            carCounter--;
        } else
            throw new RuntimeException("Requirements to load are not met.");

    }

    /**
     * Help method to the increment-/drecrementSpeed method in superclass.
     * @return speedfactor
     */
    @Override
    double speedFactor() {
        return getEnginePower() * 0.15;
    }

    /**
     * Gets a list of cars on transporter.
     * @return List of cars on transporter
     */
    public List<Car> getCarLoadedList() {
        return carLoadedList;
    }

    /**
     * Help-method for load(Car car) for it to not load itself.
     * @param car
     * @return boolean
     */
    private boolean notItSelf(Car car) {
        return !(car instanceof Transporter);
    }

    /**
     * Help-method for load(Car car) for it to not load a car with weight greater than maxWeightCar.
     * @param car
     * @return boolean
     */
    private boolean allowedWeight(Car car) {
        return car.getCarWeight() <= maxWeightCar;
    }

    /**
     * Help-method for load(Car car) to make sure the transporter is not full.
     * @return boolean
     */
    private boolean isNotFull() {
        return carCounter < maxAmountOfCars;
    }

    /**
     * Help-method for load(Car car) to make sure car being added is in range. Uses pythagorean theorem.
     * @param car
     * @return boolean
     */
    private boolean inRange(Car car) {
        double xDistance = Math.pow(this.getXPosition() - car.getXPosition(), 2);
        double yDistance = Math.pow(this.getYPosition() - car.getYPosition(), 2);
        double distance = Math.sqrt(xDistance + yDistance);
        return distance <= maxDistanceToLoad;
    }

    /**
     * Overrides move-method from super to make sure the positions of all cars onboard changes with transporters.
     */
    @Override
    public void move() {
        if (isRampUp()) {
            super.move();
            for (Car c : carLoadedList) {
                c.setXPosition((int)getCurrentPosition().getX());
                c.setYPosition((int)getCurrentPosition().getY());
            }
        } else
            System.out.println("Requirements to move are not met!");
    }
}

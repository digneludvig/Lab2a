import java.util.ArrayList;

/**
 * Generic class Workshop.
 * @param <C> The type being parameterized over.
 */
public class Workshop <C extends Car>{
    /**
     * Instance variables. Capacity of the workshop and a list of what cars are in the workshop
     */
    private int workshopCapacity;
    private ArrayList<C> carsInWorkshop;

    /**
     * @param workshopCapacity The amount of cars the workshop can take
     */
    public Workshop(int workshopCapacity) {
        this.workshopCapacity = workshopCapacity;
        carsInWorkshop = new ArrayList<C>();
    }

    /**
     * Add a car to the workshop(list)
     * @param c What type onject to add to the list
     */
    public void addCar(C c) {
        if (workshopCapacity != carsInWorkshop.size())
            carsInWorkshop.add(c);
    }

    /**
     * Returns the car of given index from workshop.
     * @param i index of car to be returned
     * @return car
     */
    public C returnCar(int i){
        if(carsInWorkshop.size() != 0) {
            C carRemoved = carsInWorkshop.get(i);
            carsInWorkshop.remove(carRemoved);
            return carRemoved;
        } else
            return null;
    }

    /**
     * Overwrite toString() method
     * @return A string with the cars model name
     */
    @Override
    public String toString() {
        String res = "";
        for (C c : carsInWorkshop)
            res += c.getModelName() + ", ";
        return res;
    }
}
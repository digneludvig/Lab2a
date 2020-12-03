public interface Loader {

    /**
     * Interface for the different trucksbeds.
     */

    void tiltUp();
    void tiltDown();
    void load(Car car);
    void unload();


}

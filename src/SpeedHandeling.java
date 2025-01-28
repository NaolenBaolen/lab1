public interface SpeedHandeling {

    //following methods should be implemented in car subclasses but differently in each, hence the interface
    void incrementSpeed(double amount);

    void decrementSpeed(double amount);

    double speedFactor();                       //for the speed handeling they have a speed factor that is specific for each car
}

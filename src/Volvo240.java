import java.awt.*;

public class Volvo240 extends Car implements SpeedHandeling, Movable{

    public final static double trimFactor = 1.25;    //specific for volvo hence it get to stay
//    public int nrDoors; // Number of doors on the car
//    public double enginePower; // Engine power of the car
//    public double currentSpeed; // The current speed of the car
//    public Color color; // Color of the car
//    public String modelName; // The car model name
    
//    public Volvo240(){
//        nrDoors = 4;
//        color = Color.black;
//        enginePower = 100;
//        modelName = "Volvo240";
//        stopEngine();
//    }
    public Volvo240(){
        super(4, 100, Color.black, "Volvo240");
    }


    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public void incrementSpeed(double amount){
	    setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    @Override
    public void move() {

    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void turnRight() {

    }
}

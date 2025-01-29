import java.awt.*;

public class Volvo240 extends Vehicle implements Movable{

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
        if (amount < 0 || amount > 1){
            throw new IllegalArgumentException("Gas has to be in range 0 - 1!");
        }
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (amount < 0 || amount > 1){
            throw new IllegalArgumentException("Brake has to be in range 0 - 1!");
        }
        decrementSpeed(amount);
    }

    @Override
    public void move(){
        switch(direction) {
            case UP -> y += getCurrentSpeed();
            case DOWN -> y -= getCurrentSpeed();
            case LEFT -> x -= getCurrentSpeed();
            case RIGHT -> x += getCurrentSpeed();
        }
    }

    @Override
    public void turnLeft(){
        switch(direction) {
            case UP -> direction = Volvo240.Direction.LEFT;
            case LEFT -> direction = Volvo240.Direction.DOWN;
            case DOWN -> direction = Volvo240.Direction.RIGHT;
            case RIGHT -> direction = Volvo240.Direction.UP;
        }
    }

    @Override
    public void turnRight(){
        switch(direction){
            case UP -> direction = Volvo240.Direction.RIGHT;
            case RIGHT -> direction = Volvo240.Direction.DOWN;
            case DOWN -> direction = Volvo240.Direction.LEFT;
            case LEFT -> direction = Volvo240.Direction.UP;
        }
    }
}

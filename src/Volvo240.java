import java.awt.*;

public class Volvo240 extends Vehicle implements Movable{

    private final static double trimFactor = 1.25;    //specific for volvo hence it get to stay

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

    public void gas(double amount){
        if (amount < 0 || amount > 1){
            throw new IllegalArgumentException("Gas has to be in range 0 - 1!");
        }
        incrementSpeed(amount);
    }

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

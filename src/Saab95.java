import java.awt.*;

public class Saab95 extends Vehicle implements Movable{

    private boolean turboOn;
    
    public Saab95() {
        super(2, 125, Color.red, "Saab95");
        turboOn = false;
    }
    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    @Override
    public void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
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
            case UP -> direction = Direction.LEFT;
            case LEFT -> direction = Direction.DOWN;
            case DOWN -> direction = Direction.RIGHT;
            case RIGHT -> direction = Direction.UP;
        }
    }

    @Override
    public void turnRight(){
        switch(direction){
            case UP -> direction = Direction.RIGHT;
            case LEFT -> direction = Direction.DOWN;
            case DOWN -> direction = Direction.LEFT;
            case RIGHT -> direction = Direction.UP;
        }
    }


    public void gas(double amount){
        if (amount < 0 || amount > 1 ){
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
}

import java.awt.*;

public class Saab95 extends Vehicle implements Movable{

    public boolean turboOn;
    //public int nrDoors; // Number of doors on the car
    //public double enginePower; // Engine power of the car
    //public double currentSpeed; // The current speed of the car
    //public Color color; // Color of the car
    //public String modelName; // The car model name
    
    public Saab95() {
        super(2, 125, Color.red, "Saab95");
        //nrDoors = 2;
        //color = Color.red;
        //enginePower = 125;
        turboOn = false;
       // this.direction = Direction.UP;
        //modelName = "Saab95";
        //stopEngine();
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

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (amount < 0 || amount > 1 ){
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
}

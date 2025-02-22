import java.awt.*;

public abstract class Vehicle implements Movable {
    private final int nDoors;
    private final double enginePower;
    private double currentSpeed;
    private Color color;
    private final String modelName;
    private final Weight weight;

    //position and direction
    private double x;
    private double y;
    private Direction direction; //direction car is facing (0 = up, 1 = right, 2 = down, 3 = left)

    public enum Direction {UP, DOWN, RIGHT, LEFT}
    public enum Weight {LIGHT, MEDIUM, HEAVY}

    public Vehicle (int nDoors, double enginePower, Color color, String modelName, Weight weight){
        this.nDoors = nDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;

        this.x = 0; //initial position
        this.y = 0;
        this.direction = Direction.UP;

        this.weight = weight;     //add a weight when creating new vehicle

        stopEngine();
    }
//following is the shared functionality methods
    public int getNDoors(){return nDoors;}

    public double getEnginePower(){return enginePower;}

    public double getCurrentSpeed() {return currentSpeed;}

    public void setCurrentSpeed(double currentSpeed){
        if (currentSpeed < 0){
            this.currentSpeed = 0;
        }else if (currentSpeed > enginePower){
            this.currentSpeed = enginePower;
        }else {
            this.currentSpeed = currentSpeed;
        }
    }

    public Color getColor() {return color;}

    public void setColor(Color clr){this.color = clr;}

    public void startEngine(){ currentSpeed = 0.1;}

    public void stopEngine(){currentSpeed = 0;}

    public String getModelName() {return modelName;}

    public Weight getWeight(){return weight;}

    //Speedhandling methods
    public void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    public void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    public abstract double speedFactor();

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

    public boolean isMoving(){ return getCurrentSpeed() > 0; }

    //Move functionality
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
    public void turnRight(){
        switch(direction){
            case UP -> direction = Direction.RIGHT;
            case RIGHT -> direction = Direction.DOWN;
            case DOWN -> direction = Direction.LEFT;
            case LEFT -> direction = Direction.UP;
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

    //Position handling

    public String getPosition(){return "(" + x + ", "+ y + ")";}

    public Direction getDirection() {return direction;}

    public void setX(double amount) { x = amount;}
    public void setY(double amount) {y = amount;}
    public double getX() {return x;}
    public double getY() {return y;}
}

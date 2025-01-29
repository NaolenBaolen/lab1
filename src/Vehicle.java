import java.awt.*;

public abstract class Vehicle {
    private final int nDoors;
    private final double enginePower;
    private double currentSpeed;
    private Color color;
    private final String modelName;

    //position and direction
    protected double x;
    protected double y;
    protected Direction direction; //direction car is facing (0 = up, 1 = right, 2 = down, 3 = left)

    public enum Direction {UP, DOWN, RIGHT, LEFT}

    public Vehicle (int nDoors, double enginePower, Color color, String modelName){
        this.nDoors = nDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;

        this.x = 0; //initial position
        this.y = 0;
        this.direction = Direction.UP;

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

    public void serColor(Color clr){this.color = clr;}

    public void startEngine(){ currentSpeed = 0.1;}

    public void stopEngine(){currentSpeed = 0;}


    //Abstract speedhandling methods

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);

    public abstract double speedFactor();

    public abstract void gas(double amount);

    public abstract void brake(double amount);

    //Position handling

    public String getPosition(){return "(" + x + ", "+ y + ")";}

    public Direction getDirection() {return direction;}
}

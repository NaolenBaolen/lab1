import java.awt.*;

public abstract class Vehicle {
    private final int nDoors;
    private final double enginePower;
    private double currentSpeed;
    private Color color;
    private final String modelName;

    //position and direction
    private double x;
    private double y;
    protected int direction; //direction car is facing (0 = up, 1 = right, 2 = down, 3 = left)

    public Vehicle (int nDoors, double enginePower, Color color, String modelName){
        this.nDoors = nDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;

        this.x = 0; //initial position
        this.y = 0;
        this.direction = 0;

        stopEngine();
    }
//following is the shared functionality methods
    public int getNDoors(){return nDoors;}

    public double getEnginePower(){return enginePower;}

    public double getCurrentSpeed() {return currentSpeed;}

    public void setCurrentSpeed(double currentSpeed){
        this.currentSpeed = currentSpeed;
    }

    public Color getColor() {return color;}

    public void serColor(Color clr){this.color = clr;}

    public void startEngine(){ currentSpeed = 0.1;}

    public void stopEngine(){currentSpeed = 0;}


    //Abstract speedhandling methods

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);

    public abstract double speedFactor();


    //dont know what to do with you....
    public void gas(double amount){
        //delegate this implementation to the subclass
    }

    public void brake(double amount){
        //delegate this implementation to the subclass
    }

}

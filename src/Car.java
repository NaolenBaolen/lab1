import java.awt.*;

public class Car {
    private final int nDoors;
    private final double enginePower;
    private double currentSpeed;
    private Color color;
    private final String modelName;

    public Car (int nDoors, double enginePower, Color color, String modelName){
        this.nDoors = nDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }
//following is the shared functionality methods
    public int getNDoors(){return nDoors;}

    public double getEnginePower(){return enginePower;}

    public double getCurrentSpeed() {return currentSpeed;}

    public Color getColor() {return color;}

    public void serColor(Color clr){this.color = clr;}

    public void startEngine(){ currentSpeed = 0.1;}

    public void stopEngine(){currentSpeed = 0;}

    public void gas(double amount){
        //delegate this implementation to the subclass (preferebly with abstract method)
    }

    public void brake(double amount){
        //delegate this implementation to the subclass (aslo preferably as abstract method)
    }

}

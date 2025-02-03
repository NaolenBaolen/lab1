import java.awt.*;

public abstract class TruckVehicle extends Vehicle{
    //If both trucks should have angle on their beds, implement here and make transport raiseBed = al the way up and Scania arbitrary degrees.
    //if not, implement angle in Scania subclass and up or down in Transport
    protected boolean bedRaised;
    protected double bedAngle;

    public TruckVehicle (int nDoors, double enginePower, Color clr, String modelName){
        super (nDoors, enginePower, clr, modelName);
        this.bedRaised = true;
        this.bedAngle = 0;     //bed raised means we can move (angle = 0)
    }

    @Override
    public double speedFactor(){        //maybe tweak to fit a trucks speedfactor, override if different trucks needs different speedfactors
        return getEnginePower() * 0.01;
    }

    public double getBedAngle(){ return bedAngle;}

    //implemented differently in Scania and Transport (Maybe make one general or interface?? pros and cons??)
    public abstract void raiseBed();
    public abstract void lowerBed();

    @Override
    public void move(){
        if(bedRaised){
            super.move();
        }else {
            throw new IllegalArgumentException ("Cant move with bed lowered"); //TODO maybe not throw ArgumentException here... but something needs to happen when we try to move but bed is lowered
        }
    }
}

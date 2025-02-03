import java.awt.*;

public abstract class TruckVehicle extends Vehicle{

    protected boolean bedRaised;

    public TruckVehicle (int nDoors, double enginePower, Color clr, String modelName){
        super (nDoors, enginePower, clr, modelName);
        this.bedRaised = true;  //bed raised means we can move
    }

    @Override
    public double speedFactor(){        //maybe tweak to fit a trucks speedfactor, override if different trucks needs different speedfactors
        return getEnginePower() * 0.01;
    }

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

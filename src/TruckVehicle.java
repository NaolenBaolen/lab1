import java.awt.*;

public abstract class TruckVehicle extends Vehicle{
    //TODO If both trucks should have angle on their beds, implement here and make transport raiseBed = al the way up and Scania arbitrary degrees.
    //if not, implement angle in Scania subclass and up or down in Transport
    protected boolean bedRaised;
    protected double bedAngle;

    public TruckVehicle (int nDoors, double enginePower, Color clr, String modelName){
        super (nDoors, enginePower, clr, modelName);
        this.bedRaised = false;   //bed raised means we can not move (angle = 70)
        this.bedAngle = 0;
    }

    @Override
    public double speedFactor(){        //TODO maybe tweak to fit a trucks speedfactor, override if different trucks needs different speedfactors
        return getEnginePower() * 0.01;
    }

    public double getBedAngle(){ return bedAngle;}

    //potentially use in raise and lower bed methods so that raise and lower does not occur if "isMoving == true"
    public boolean isMoving(){
        return getCurrentSpeed() > 0;
    }

    //implemented differently in Scania and Transport (Maybe make one general or interface if we have a lot of raisable and lowerable things ?? pros and cons??)
    public abstract void raiseBed();
    public abstract void lowerBed();


    @Override
    public void move(){
        if(!bedRaised){
            super.move();
        }else {
            throw new IllegalArgumentException ("Cant move with bed raised"); //TODO maybe not throw ArgumentException here... but something needs to happen when we try to move but bed is lowered
            //System.out.print("cant move with bed raised") <- might be better
        }
    }
}

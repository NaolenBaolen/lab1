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


    public void raiseBed(){
        if(isMoving()){
            System.out.print("Can not raise while moving");
        } else{
            bedAngle = 70;
            bedRaised = true;
        }
    }
    public void lowerBed(){
        if(isMoving()){
            System.out.print("Can not lower while moving");
        } else{
            bedAngle = 0;
            bedRaised = false;
        }
    }


    @Override
    public void move(){
        if(!bedRaised){
            super.move();
        }else {
            System.out.print("cant move with bed raised");
        }
    }
}

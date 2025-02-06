import java.awt.*;

public abstract class TruckVehicle extends Vehicle{
    protected boolean bedRaised;
    private double bedAngle;

    public TruckVehicle (int nDoors, double enginePower, Color clr, String modelName, Weight weight){
        super (nDoors, enginePower, clr, modelName, weight);
        this.bedRaised = false;   //bed raised means we can not move (angle = 70)
        this.bedAngle = 0;
    }

    @Override
    public double speedFactor(){        //TODO maybe tweak to fit a trucks speedfactor, override if different trucks needs different speedfactors
        return getEnginePower() * 0.01;
    }

    public double getBedAngle(){ return bedAngle;}

    public void setBedAngle(double bedAngle) {this.bedAngle = bedAngle;}


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

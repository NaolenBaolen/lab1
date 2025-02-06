import java.awt.*;

public class Scania extends TruckVehicle{

    public Scania(){
        super(2, 150, Color.blue, "Scania", Weight.MEDIUM);
    }


    public void raiseBed(double amount){
        if(isMoving()){
            System.out.print("Can not raise while moving");
        }else{
            setBedAngle(Math.min(getBedAngle() + amount, 70));
            bedRaised = getBedAngle() > 0;
        }
    }

    public void lowerBed(double amount){
        if(isMoving()){
            System.out.print("Can not lower while moving");
        } else{
            setBedAngle(Math.max(getBedAngle() - amount, 0));
            bedRaised = getBedAngle() > 0;
        }
    }
}

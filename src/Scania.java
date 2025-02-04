import java.awt.*;

public class Scania extends TruckVehicle {

    public Scania(){
        super(2, 150, Color.blue, "Scania");
    }

    //Has to be a more clean way to  implement raise and lower bed (instead of overloading methods)... well not really

    public void raiseBed(double amount){
        if(isMoving()){
            System.out.print("Can not raise while moving");
        }else{
            bedAngle = Math.min(bedAngle + amount, 70);
            bedRaised = bedAngle > 0;   //bedRaisaed = true for all values except 0
        }
    }

    public void lowerBed(double amount){
        if(isMoving()){
            System.out.print("Can not lower while moving");
        } else{
            bedAngle = Math.max(bedAngle - amount, 0);
            bedRaised = bedAngle > 0;
        }
    }
}

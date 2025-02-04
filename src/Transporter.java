import java.awt.*;

public class Transporter extends TruckVehicle{

    public Transporter(){
        super(2, 150, Color.black, "Transporter");
    }

    @Override
    public void raiseBed() {
        if(isMoving()){
            System.out.print("Can not raise while moving");
        } else{
            bedAngle = 70;
            bedRaised = true;
        }
    }

    @Override
    public void lowerBed() {
        if(isMoving()){
            System.out.print("Can not lower while moving");
        } else{
            bedAngle = 0;
            bedRaised = false;
        }
    }
}

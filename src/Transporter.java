import java.awt.*;
import java.util.LinkedList;

public class Transporter extends TruckVehicle implements Loadable<Vehicle>{

    private static final double minDist = 5.0; //minimum distance vehicles can be from transport to be able to load
    private static final int maxCap = 5; // maximum capacity for transport
    private LinkedList<Vehicle> vehicleCollection = new LinkedList<>();

    public Transporter(){
        super(2, 150, Color.black, "Transporter");
    }



    @Override
    public void load(Vehicle vehicle) {
        if(bedRaised && !fullTransport() && inProximity(vehicle)){
            vehicleCollection.add(vehicle);
        } else{
            System.out.print("Not able to load, check ramp, capacity and so vehicle is in proximity");
        }
    }

    @Override
    public void unload() {
        if(bedRaised && !vehicleCollection.isEmpty()){
            Vehicle vehicle = vehicleCollection.removeLast();
            //position again??
        }else{
            System.out.print("Ramp has to be down to unload vehicles");
        }
    }

    //Loading/unloading conditions
    private boolean fullTransport(){
        return vehicleCollection.size() >= maxCap;
    }

    private boolean inProximity(Vehicle vehicle){
        return distToTransport(vehicle) <= minDist;
    }
    //checks how far transport is from vehicle (distance formula)
    private double distToTransport(Vehicle vehicle){
        double Ax = (this.getX() - vehicle.getX());
        double Ay = (this.getY() - vehicle.getY());

        return Math.sqrt((Ax * Ax) + (Ay * Ay));
    }

}

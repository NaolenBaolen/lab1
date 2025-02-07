import java.util.LinkedList;
import java.util.List;

public abstract class CarMechanic implements Loadable<Vehicle> {
    private final int maxCap;
    private LinkedList<Vehicle> vehicleIn;
    private final List<String> acceptedModels;

    public CarMechanic(int maxCap, List<String> acceptedModels){
        this.maxCap = maxCap;
        this.vehicleIn = new LinkedList<>();
        this.acceptedModels = acceptedModels;
    }


    @Override
    public void load(Vehicle vehicle) {
        if(requirementsMet(vehicle) && !full()){
            vehicleIn.add(vehicle);
        }else{
            //trying to load "wrong" vehicle throw static (compile time) error.
        }

    }

    @Override
    public void unload() {
        if(!vehicleIn.isEmpty()){
            Vehicle vehicle = vehicleIn.remove();
            //staticly be able to now that all the vehicles that are brougth out are specified model
        }else{
            System.out.print("No vehicles in right now.");
        }
    }

    private boolean requirementsMet(Vehicle vehicle){
        return !full() && acceptedModels.contains(vehicle.getModelName());
    }

    private boolean full(){
        return  vehicleIn.size() >= maxCap;
    }
}

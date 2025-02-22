import java.util.LinkedList;

public abstract class CarMechanic<T extends Vehicle> implements Loadable<T> {
    private final int maxCap;
    private LinkedList<T> vehicleIn;

    public CarMechanic(int maxCap){
        this.maxCap = maxCap;
        this.vehicleIn = new LinkedList<>();
    }

    public int getSize(){return vehicleIn.size();}
    public boolean shopContains(T vehicle){
        return vehicleIn.contains(vehicle);
    }

    @Override
    public void load(T vehicle) {
        if(!full()){
            vehicleIn.add(vehicle);
        }else{
            System.out.print("shop full");
        }

    }

    @Override
    public void unload() {
        if(!vehicleIn.isEmpty()){
            Vehicle vehicle = vehicleIn.remove();
        }else{
            System.out.print("No vehicles in right now.");
        }
    }


    private boolean full(){
        return  vehicleIn.size() >= maxCap;
    }
}

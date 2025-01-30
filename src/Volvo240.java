import java.awt.*;

public class Volvo240 extends Vehicle implements Movable{

    private final static double trimFactor = 1.25;    //specific for volvo hence it get to stay

    public Volvo240(){
        super(4, 100, Color.black, "Volvo240");
    }


    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}

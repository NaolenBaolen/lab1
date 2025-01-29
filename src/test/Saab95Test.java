import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Saab95Test {
    private Saab95 vehicle;

    @BeforeEach
    public void setup(){
        vehicle = new Saab95();
    }
    @Test
    void testCurrentSpeedInRange(){
        vehicle.gas(126); //Control the speed
        double currentSpeed = vehicle.getCurrentSpeed();
        //speed can only be in the range [0,enginePower]
        assertTrue(currentSpeed >= 0 && currentSpeed <= vehicle.getEnginePower());
    }
    @Test
    void testGasGiveCorrectChangeOffSpeed(){
        vehicle.gas(0.5);
        double initialSpeed = vehicle.getCurrentSpeed();
        vehicle.gas(-0.1);
        double currentSpeed = vehicle.getCurrentSpeed();
        assertTrue(initialSpeed <= currentSpeed, "The speed can not be reducing when gas");
    }
    @Test
    void testBrakeGiveCorrectChangeOffSpeed(){
        double initialSpeed = vehicle.getCurrentSpeed();
        vehicle.brake(-0.2);
        double currentSpeed = vehicle.getCurrentSpeed();
        assertTrue(initialSpeed >= currentSpeed, "The speed can not be increasing when braking");
    }
    @Test
    void testGasWithValidAmount() {
        //Only accepts values in the range [0,1]
        assertThrows(IllegalArgumentException.class, () -> vehicle.gas(-0.1));
        assertThrows(IllegalArgumentException.class, () -> vehicle.gas(1.1));
    }

    @Test
    void testBrakeWithValidAmount() {
        //Only accepts values in the range [0,1]
        assertThrows(IllegalArgumentException.class, () -> vehicle.brake(-0.1));
        assertThrows(IllegalArgumentException.class, () -> vehicle.brake(1.1));
    }
}
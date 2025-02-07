import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaV2Test {
    private ScaniaV2 vehicle;

    @BeforeEach
    public void setup(){
        vehicle = new ScaniaV2();
    }
    @Test
    void getBedAngleChanges(){
        vehicle.raiseBed(50);
        System.out.print(vehicle.getBedAngle());
        vehicle.lowerBed(10);
        System.out.print(vehicle.getBedAngle());
    }
    @Test
    void angleBedInRange(){
        vehicle.lowerBed(5);
        assertEquals(0, vehicle.getBedAngle());
        vehicle.raiseBed(80);
        assertEquals(70, vehicle.getBedAngle());
    }

    @Test
    void raiseBedCorrectChangeOfAngle() {
        double initialAngle = vehicle.getBedAngle();
        vehicle.raiseBed(10);
        double currentAngle = vehicle.getBedAngle();
        assertTrue(initialAngle <= currentAngle, "The angle can not be decreasing when raising the bed");
    }

    @Test
    void lowerBedCorrectChangeOfAngle() {
        double initialAngle = vehicle.getBedAngle();
        vehicle.lowerBed(10);
        double currentAngle = vehicle.getBedAngle();
        assertTrue(initialAngle >= currentAngle, "The angle can not be increasing when lowering the bed");
    }
    @Test
    void moveRequirementBedNotFoldedUp(){
        String initialPosition = vehicle.getPosition();
        vehicle.raiseBed(10);
        vehicle.move();
        assertEquals(initialPosition, vehicle.getPosition());
    }

    @Test
    void BedAngleChangeRequirement(){
        vehicle.setCurrentSpeed(10);
        vehicle.raiseBed(10);
        assertEquals(0, vehicle.getBedAngle());
        //If the vehicle is moving the bed angle needs to be 0, and it cannot be changed while the vehicle is moving.
    }

}
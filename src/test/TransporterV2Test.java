import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransporterV2Test {
    private TransporterV2 transporter;
    private Volvo240 vehicle1;
    private Saab95 vehicle2;
    private Scania heavyVehicle;

    @BeforeEach
    public void setup(){
        transporter = new TransporterV2();
        vehicle1 = new Volvo240();
        vehicle2 = new Saab95();
        heavyVehicle = new Scania();
    }

    @Test
    void load() {
        transporter.load(vehicle1); //will not load when bed down
        assertEquals(0, transporter.collectionSize());

        transporter.raiseBed();
        transporter.load(vehicle1); //can load if bed is raised
        assertEquals(1,transporter.collectionSize());

        transporter.load(heavyVehicle); //can not load larger vehicles
        assertEquals(1, transporter.collectionSize());
    }

    @Test
    void loadTooFar(){
        vehicle2.setCurrentSpeed(50);
        vehicle2.move();
        transporter.raiseBed();
        transporter.load(vehicle2);

        assertFalse(transporter.collectionContains(vehicle2));

        vehicle2.turnLeft();
        vehicle2.turnLeft();
        vehicle2.move();

        transporter.load(vehicle2);
        assertTrue(transporter.collectionContains(vehicle2));
    }

    @Test
    void unload() {
        transporter.raiseBed();
        transporter.load(vehicle1);
        transporter.lowerBed();
        transporter.unload();
        assertEquals(1, transporter.collectionSize()); //can not unload when bed not raised

        transporter.raiseBed();
        transporter.unload();
        assertEquals(0, transporter.collectionSize()); //can unload now
    }

    @Test
    void unloadInOrder(){
        transporter.raiseBed();
        transporter.load(vehicle1);
        transporter.load(vehicle2);
        assertEquals(2, transporter.collectionSize());    //load vehicle 1 and 2

        transporter.unload();                                      //unload
        assertFalse(transporter.collectionContains(vehicle2));   //vehicle 2 removed first
        assertTrue(transporter.collectionContains(vehicle1));

    }

    @Test
    void raiseBed() {
        transporter.setCurrentSpeed(10);
        transporter.raiseBed();
        assertFalse(transporter.isBedRaised());

        transporter.stopEngine();
        transporter.raiseBed();
        assertTrue(transporter.isBedRaised());
    }

    @Test
    void lowerBed() {
        transporter.raiseBed();
        transporter.lowerBed();
        assertFalse(transporter.isBedRaised());
    }

    @Test
    void move() {
        transporter.raiseBed();
        transporter.load(vehicle1);
        transporter.load(vehicle2);
        transporter.lowerBed();
        transporter.setCurrentSpeed(50);
        transporter.move();
        assertAll(
                "all cars have position of transporter",
                () -> assertEquals(transporter.getPosition(), vehicle1.getPosition()),
                () -> assertEquals(transporter.getPosition(), vehicle2.getPosition())
                );
    }
}
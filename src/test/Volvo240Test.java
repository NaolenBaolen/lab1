import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {


    @Test
    public void initialize(){
        Volvo240 volvo = new Volvo240();

        assertAll("Check so initial values of volvo is good",
                () -> assertEquals(4, volvo.getNDoors(),"doors mismatch"), //doors match
                () -> assertEquals(100, volvo.getEnginePower(),"enginePower mismatch"), //enginepower match
                () -> assertEquals(Color.BLACK, volvo.getColor(), "Color mismatch"), //color match??
                () -> assertEquals("(0.0, 0.0)", volvo.getPosition(), "position mismatch"),    //position match
                () -> assertEquals(0, volvo.getCurrentSpeed(), "speed mismatch"));      //current speed match
    }


    @Test
    void speedFactor() {
        Volvo240 volvo = new Volvo240();
        assertEquals(1.25, volvo.speedFactor(), 0.01); //factor = enginePower * 0.01 * trimFactor
    }

    @Test
    void incrementSpeed() {
    }

    @Test
    void decrementSpeed() {
    }

   @Test
    public void moveAndTurn(){
        Volvo240 volvo = new Volvo240();

        volvo.startEngine();
        volvo.gas(1.0); //add some speed
        volvo.move();           //move it in the default position which is up

        assertEquals("(0.0, 1.35)", volvo.getPosition());    //see so the position is correct

       //test turning left
       volvo.turnLeft(); //turn from up to left = LEFT
       assertEquals(Vehicle.Direction.LEFT , volvo.getDirection());

       //test turning right
       volvo.turnRight(); //right from left = UP
       assertEquals(Vehicle.Direction.UP , volvo.getDirection());

       //turn left 2 times = DOWN
       volvo.turnLeft();
       volvo.turnLeft();
       assertEquals(Vehicle.Direction.DOWN, volvo.getDirection());

   }
}
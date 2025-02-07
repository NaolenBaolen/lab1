import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarMechanicTest {

    private Volvo240Mechanic volvoShop;
    private allroundMechanic allroundShop;
    private Volvo240 volvo;
    private Saab95 saab;
    private TransporterV2 truck;

    @BeforeEach
    void setUp(){
        volvoShop = new Volvo240Mechanic();
        allroundShop = new allroundMechanic();
        volvo = new Volvo240();
        saab = new Saab95();
        truck = new TransporterV2();
    }

    @Test
    void onlyVolvo(){
        volvoShop.load(volvo);
        //volvoShop.load(saab);   <- cannot run (compile time error

        assertEquals(1, volvoShop.getSize());
    }

    @Test
    void allround(){
        allroundShop.load(volvo);
        allroundShop.load(saab);

        assertEquals(2, allroundShop.getSize());
    }

    @Test
    void maxCap(){
        allroundShop.load(volvo);
        allroundShop.load(saab);
        allroundShop.load(truck);

        assertEquals(2, allroundShop.getSize());
    }

    @Test
    void fifoOrder(){
        allroundShop.load(volvo);
        allroundShop.load(saab);

        assertEquals(2, allroundShop.getSize());

        allroundShop.unload();

        assertTrue(allroundShop.shopContains(saab));
        assertEquals(1, allroundShop.getSize());
    }


}
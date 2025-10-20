import static org.junit.Assert.*;

public class CodingBatTest {

    @org.junit.Test
    public void sleepIn() {
        CodingBat cb = new CodingBat();
        assertEquals(true, cb.sleepIn(false,false));
        assertEquals(false, cb.sleepIn(true,false));
        assertEquals(true, cb.sleepIn(false,true));
        assertEquals(true, cb.sleepIn(true,true));
    }

    @org.junit.Test
    public void sumDouble(){
        CodingBat cb = new CodingBat();
        assertEquals(3, cb.sumDouble(1,2) );
        assertEquals(5, cb.sumDouble(3,2) );
        assertEquals(8, cb.sumDouble(2,2) );
        assertEquals(-1, cb.sumDouble(-1,0) );
        assertEquals(12, cb.sumDouble(3,3) );
        assertEquals(0, cb.sumDouble(0,0) );
        assertEquals(1, cb.sumDouble(0,1) );
        assertEquals(7, cb.sumDouble(3,4) );
    }

    @org.junit.Test
    public void bigDiff(){
        CodingBat cb = new CodingBat();
        assertEquals(7, cb.bigDiff(new int[]{10,3, 5 ,6}));
        assertEquals(8, cb.bigDiff(new int[]{7,2,10,9} ));
        assertEquals(8, cb.bigDiff(new int[]{2,10, 7 ,2}));
        assertEquals(8, cb.bigDiff(new int[]{2,10}));
        assertEquals(10, cb.bigDiff(new int[]{10,0}));
        assertEquals(1, cb.bigDiff(new int[]{2,3}));


    }
    @org.junit.Test
    public void helloName(){
        CodingBat cb = new CodingBat();
        assertEquals("Hello Bob!", cb.helloName("Bob"));
        assertEquals("Hello Alice!", cb.helloName("Alice"));
        assertEquals("Hello X!", cb.helloName("X"));
        assertEquals("Hello Dolly!", cb.helloName("Dolly"));
        assertEquals("Hello Alpha!", cb.helloName("Alpha"));
        assertEquals("Hello ho ho ho!", cb.helloName("ho ho ho"));

    }
}
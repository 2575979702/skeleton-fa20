import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffbyN {

    /** Test equalChars offbyN method */
    @Test
    public void testNequalChars(){
        OffByN n = new OffByN(5);
        boolean expected = n.equalChars('a','f');
        assertTrue(expected);
    }
}

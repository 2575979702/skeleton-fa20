import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    // Your tests go here.
    /** Test equalChars offbyone method */
    @Test
    public void testequalChars(){
        OffByOne one = new OffByOne();
        boolean expected = one.equalChars('%','&');
        assertTrue(expected);
    }

}
//Uncomment this class once you've created your CharacterComparator interface and OffByOne class. *
import junit.framework.TestCase;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@RunWith(value = Parameterized.class)
public class ArrayHelperTest extends TestCase {

    private static final DateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss:SSS");

    private int[] inputArray1;
    private int[] outputArray1;
    private int[] inputArray2;
    private boolean bool;

    public ArrayHelperTest(int[] inputArray1, int[] outputArray1, int[] inputArray2, boolean bool) {
        this.inputArray1 = inputArray1;
        this.outputArray1 = outputArray1;
        this.inputArray2 = inputArray2;
        this.bool = bool;
    }

    @Parameterized.Parameters
    public static Collection ioArrays() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, new int[]{5}, new int[]{1, 2, 3, 4, 5}, true},
                {new int[]{1, 2, 3, 4, 4}, new int[]{}, new int[]{4, 2, 3, 4, 5}, false},
                {new int[]{1, 2, 4, 3, 5}, new int[]{3, 5}, new int[]{1, 2, 3, 7, 5}, false},
                {new int[]{1, 4, 3, 1, 5}, new int[]{3, 1, 5}, new int[]{9, 2, 3, 10, 5}, false}
        });
    }

    @Test
    public void testGetNewArray() {
        Assert.assertArrayEquals(outputArray1, ArrayHelper.getNewArray(inputArray1));
    }

    @Test(expected = RuntimeException.class)
    public void testGetNewArrayException() {
        ArrayHelper.getNewArray(new int[]{1, 2, 5, 6});
        ArrayHelper.getNewArray(new int[]{});
    }

    @Test
    public void testIsNumbersInArray() {
        Assert.assertEquals(bool, ArrayHelper.isNumbersInArray(inputArray2));
    }

    @BeforeClass
    public static void start() {
        System.out.println("Start testing... " + df.format(new Date()));
    }

    @AfterClass
    public static void finish() {
        System.out.println("Finish testing... " + df.format(new Date()));
    }
    
    @Ignore
    public void ignore() {
        System.out.println("You cannot see this message.");
    }
}
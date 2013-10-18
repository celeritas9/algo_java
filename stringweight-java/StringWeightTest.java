import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringWeightTest {

    protected StringWeight solution;

    @Before
    public void setUp() {
        solution = new StringWeight();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] L = new int[]{1};

        int expected = 0;
        int actual = solution.getMinimum(L);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] L = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        int expected = 1;
        int actual = solution.getMinimum(L);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] L = new int[]{26, 2, 2};

        int expected = 8;
        int actual = solution.getMinimum(L);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] L = new int[]{25, 25, 25, 25};

        int expected = 1826;
        int actual = solution.getMinimum(L);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] L = new int[]{14, 6, 30, 2, 5, 61};

        int expected = 1229;
        int actual = solution.getMinimum(L);

        Assert.assertEquals(expected, actual);
    }

}

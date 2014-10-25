package Help.test.level15.lesson04.task04;

import org.junit.Assert;
import org.junit.Test;

public class Minimum2Test {

    public int min2(int cA, int dB) {
        if (cA > dB) {
            return dB;
        } else if (cA < dB) {
            return cA;
        } else {
            return cA;
        }
    }

    @Test
    public void minTest() {
        Assert.assertEquals(5, min2(12, 5));
        Assert.assertEquals(5, min2(5, 12));
        Assert.assertEquals(-5, min2(-5, 5));
        Assert.assertEquals(-5, min2(-5, 12));
        Assert.assertEquals(0, min2(0, 5));
        Assert.assertEquals(-5, min2(0, -5));
        Assert.assertEquals(-5, min2(-5, 0));
    }

}
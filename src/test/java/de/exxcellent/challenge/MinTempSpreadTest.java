package de.exxcellent.challenge;

import de.exxcellent.challenge.model.WeatherEntry;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author pc
 * @since 05.05.18
 */
public class MinTempSpreadTest {

    private MinTempSpread minTempSpreadComp;

    private WeatherEntry weatherEntryA;
    private WeatherEntry weatherEntryB;

    @Before
    public void setUp() throws Exception {
        minTempSpreadComp = new MinTempSpread();

        weatherEntryA = new WeatherEntry("10", 84, 64, 74, 57.5, 0, 210, 6.6, 50, 9, 3.4, 84, 40, 1019);
        weatherEntryB = new WeatherEntry("11",91,59,75,66.3,0,250,7.1,230,12,2.5,93,45,1012.6);
    }

    @Test
    public void compare() {
        Assert.assertTrue(minTempSpreadComp.compare(weatherEntryB, weatherEntryA) < 0);
        weatherEntryA.setMxt(104);
        Assert.assertTrue(minTempSpreadComp.compare(weatherEntryB, weatherEntryA) > 0);
        weatherEntryB.setMnt(51);
        Assert.assertEquals(0, minTempSpreadComp.compare(weatherEntryA, weatherEntryB));
    }
}

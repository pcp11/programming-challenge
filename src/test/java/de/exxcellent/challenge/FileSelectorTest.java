package de.exxcellent.challenge;

import de.exxcellent.challenge.model.WeatherEntry;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author pc
 * @since 05.05.18
 */
public class FileSelectorTest {

    private FileSelector fileSelector;

    private WeatherEntry result;

    @Before
    public void setUp() throws Exception {
        fileSelector = new FileSelector(App.weatherCSV, new CSVWeatherParser(), new MinTempSpread());

        result = new WeatherEntry("14",61,59,60,55.9,0,60,6.7,80,9,10,93,87,1008.6);
    }

    @Test
    public void select() {
        Assert.assertEquals(result.getDay(), fileSelector.select().getDay());
    }
}

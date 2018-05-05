package de.exxcellent.challenge;

import de.exxcellent.challenge.model.WeatherEntry;
import de.exxcellent.challenge.parser.CSVWeatherParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author pc
 * @since 05.05.18
 */
public class FileSelectorTest {

    private FileSelector<WeatherEntry> weatherEntryFileSelector;

    private WeatherEntry weatherEntry;

    @Before
    public void setUp() throws Exception {
        weatherEntryFileSelector = new FileSelector<>(App.weatherCSV, new CSVWeatherParser(), new MinTempSpread());

        weatherEntry = new WeatherEntry("14",61,59,60,55.9,0,60,6.7,80,9,10,93,87,1008.6);
    }

    @Test
    public void select() {
        Assert.assertEquals(weatherEntry.getDay(), weatherEntryFileSelector.select().getDay());
    }
}

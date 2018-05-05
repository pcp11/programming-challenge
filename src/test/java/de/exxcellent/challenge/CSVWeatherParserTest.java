package de.exxcellent.challenge;

import de.exxcellent.challenge.model.WeatherEntry;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author pc
 * @since 05.05.18
 */
public class CSVWeatherParserTest {

    private CSVWeatherParser csvWeatherParser;

    private WeatherEntry weatherEntryA;

    private WeatherEntry weatherEntryB;

    @Before
    public void setUp() throws Exception {
        csvWeatherParser = new CSVWeatherParser();

        weatherEntryA = new WeatherEntry("1",88,59,74,53.8,0,280,9.6,270,17,1.6,93,23,1004.5);
        weatherEntryB = new WeatherEntry("18",82,52,67,52.6,0,230,4,190,12,5,93,34,1021.3);
    }

    @Test
    public void parseFile() {
        List<WeatherEntry> weatherEntries = csvWeatherParser.parseFile(App.weatherCSV);

        Assert.assertEquals(weatherEntryA, weatherEntries.get(0));
        Assert.assertEquals(weatherEntryB, weatherEntries.get(17));

        Assert.assertNotEquals(weatherEntryA, weatherEntries.get(1));
        Assert.assertNotEquals(weatherEntryB, weatherEntries.get(16));
    }
}

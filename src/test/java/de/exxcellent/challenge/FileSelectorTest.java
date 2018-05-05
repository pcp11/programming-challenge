package de.exxcellent.challenge;

import de.exxcellent.challenge.comparator.MinGoalDifference;
import de.exxcellent.challenge.comparator.MinTempSpread;
import de.exxcellent.challenge.model.FootballEntry;
import de.exxcellent.challenge.model.WeatherEntry;
import de.exxcellent.challenge.parser.CSVFootballParser;
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
    private FileSelector<FootballEntry> footballEntryFileSelector;

    private WeatherEntry weatherSelectorResult;
    private FootballEntry footballSelectorResult;

    @Before
    public void setUp() throws Exception {
        weatherEntryFileSelector = new FileSelector<>(App.weatherCSV, new CSVWeatherParser(), new MinTempSpread());
        footballEntryFileSelector = new FileSelector<>(App.footballCSV, new CSVFootballParser(), new MinGoalDifference());

        weatherSelectorResult = new WeatherEntry("14",61,59,60,55.9,0,60,6.7,80,9,10,93,87,1008.6);
        footballSelectorResult = new FootballEntry("Aston_Villa",38,12,14,12,46,47,50);
    }

    @Test
    public void select() {
        Assert.assertEquals(weatherSelectorResult.getDay(), weatherEntryFileSelector.select().getDay());
        Assert.assertEquals(footballSelectorResult.getTeam(), footballEntryFileSelector.select().getTeam());
    }
}

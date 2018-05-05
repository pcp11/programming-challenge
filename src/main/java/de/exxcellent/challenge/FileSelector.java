package de.exxcellent.challenge;

import de.exxcellent.challenge.model.WeatherEntry;

import java.util.Comparator;
import java.util.List;

/**
 * @author pc
 * @since 05.05.18
 */
public class FileSelector {

    private String filePath;

    private CSVWeatherParser csvWeatherParser;

    private Comparator<WeatherEntry> comparator;

    public FileSelector(String filePath, CSVWeatherParser csvWeatherParser, Comparator<WeatherEntry> comparator) {
        this.filePath = filePath;
        this.csvWeatherParser = csvWeatherParser;
        this.comparator = comparator;
    }

    public WeatherEntry select() {
        List<WeatherEntry> weatherEntries = csvWeatherParser.parseFile(filePath);
        WeatherEntry max = null;
        for (int i = 0; i < weatherEntries.size(); ++i) {
            WeatherEntry current = weatherEntries.get(i);
            if (i == 0 || comparator.compare(current, max) > 0) {
                max = current;
            }
        }
        return max;
    }
}

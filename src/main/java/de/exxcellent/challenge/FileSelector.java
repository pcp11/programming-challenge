package de.exxcellent.challenge;

import de.exxcellent.challenge.model.WeatherEntry;

import java.util.Comparator;

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
        return null;
    }
}

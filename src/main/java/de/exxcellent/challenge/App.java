package de.exxcellent.challenge;

import de.exxcellent.challenge.comparator.MinGoalDifference;
import de.exxcellent.challenge.comparator.MinTempSpread;
import de.exxcellent.challenge.model.FootballEntry;
import de.exxcellent.challenge.model.WeatherEntry;
import de.exxcellent.challenge.parser.CSVFootballParser;
import de.exxcellent.challenge.parser.CSVWeatherParser;
import de.exxcellent.challenge.selector.FileSelector;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static final String weatherCSV = "./src/main/resources/de/exxcellent/challenge/weather.csv";

    public static final String footballCSV = "./src/main/resources/de/exxcellent/challenge/football.csv";

    public static void main(String... args) {

        // Your preparation code …
        FileSelector<WeatherEntry> weatherEntryFileSelector = new FileSelector<>(weatherCSV, new CSVWeatherParser(), new MinTempSpread());
        FileSelector<FootballEntry> footballEntryFileSelector = new FileSelector<>(footballCSV, new CSVFootballParser(), new MinGoalDifference());

        String dayWithSmallestTempSpread = weatherEntryFileSelector.select().getDay();     // Your day analysis function call …
        String teamWithSmallesGoalSpread = footballEntryFileSelector.select().getTeam(); // Your goal analysis function call …

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}

package de.exxcellent.challenge.comparator;

import de.exxcellent.challenge.model.WeatherEntry;

import java.util.Comparator;

/**
 * @author pc
 * @since 05.05.18
 */
public class MinTempSpread implements Comparator<WeatherEntry> {

    @Override
    public int compare(WeatherEntry o1, WeatherEntry o2) {
        return Double.compare(o2.getMxt() - o2.getMnt(), o1.getMxt() - o1.getMnt());
    }
}

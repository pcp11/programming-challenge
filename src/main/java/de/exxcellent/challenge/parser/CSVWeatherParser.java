package de.exxcellent.challenge.parser;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import de.exxcellent.challenge.model.WeatherEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides a parser that takes a csv file converting it into a List
 * of WeatherEntry objects.
 *
 * @author Patrick Christ
 * @since 05.05.18
 */
public class CSVWeatherParser implements FileParser<WeatherEntry> {

    private static final String[] CSV_HEADER = {"day","mxt","mnt","avt","avdp","hrp_tpcpn","pdir","avsp","dir","mxs","skyc","mxr","mn","r_avslp"};

    @Override
    public List<WeatherEntry> parseFile(String filePath) {

        List<WeatherEntry> weatherEntries = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {

            ColumnPositionMappingStrategy<WeatherEntry> mappingStrategy =
                    new ColumnPositionMappingStrategy<>();

            mappingStrategy.setType(WeatherEntry.class);
            mappingStrategy.setColumnMapping(CSV_HEADER);

            CsvToBean<WeatherEntry> csvToBean = new CsvToBeanBuilder<WeatherEntry>(fileReader)
                    .withMappingStrategy(mappingStrategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            weatherEntries.addAll(csvToBean.parse());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weatherEntries;
    }
}

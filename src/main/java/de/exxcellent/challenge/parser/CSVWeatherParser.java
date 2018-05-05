package de.exxcellent.challenge.parser;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import de.exxcellent.challenge.model.WeatherEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author pc
 * @since 05.05.18
 */
public class CSVWeatherParser implements FileParser<WeatherEntry> {

    private static final String[] CSV_HEADER = {"day","mxt","mnt","avt","avdp","hrp_tpcpn","pdir","avsp","dir","mxs","skyc","mxr","mn","r_avslp"};

    @Override
    public List<WeatherEntry> parseFile(String filePath) {

        BufferedReader fileReader = null;
        List<WeatherEntry> weatherEntries = null;
        CsvToBean<WeatherEntry> csvToBean;

        try {
            fileReader = new BufferedReader(new FileReader(filePath));

            ColumnPositionMappingStrategy<WeatherEntry> mappingStrategy =
                    new ColumnPositionMappingStrategy<>();

            mappingStrategy.setType(WeatherEntry.class);
            mappingStrategy.setColumnMapping(CSV_HEADER);

            csvToBean = new CsvToBeanBuilder<WeatherEntry>(fileReader)
                    .withMappingStrategy(mappingStrategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            weatherEntries = csvToBean.parse();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return weatherEntries;
    }
}

package de.exxcellent.challenge.parser;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import de.exxcellent.challenge.model.FootballEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author pc
 * @since 05.05.18
 */
public class CSVFootballParser implements FileParser<FootballEntry> {

    private static final String[] CSV_HEADER = {"Team", "Games", "Wins", "Losses", "Draws", "Goals", "GoalsAllowed", "Points"};

    @Override
    public List<FootballEntry> parseFile(String filePath) {

        BufferedReader fileReader = null;
        CsvToBean<FootballEntry> csvToBean;
        List<FootballEntry> result = null;

        try {
            fileReader = new BufferedReader(new FileReader(filePath));

            ColumnPositionMappingStrategy<FootballEntry> mappingStrategy =
                    new ColumnPositionMappingStrategy<>();

            mappingStrategy.setType(FootballEntry.class);
            mappingStrategy.setColumnMapping(CSV_HEADER);

            csvToBean = new CsvToBeanBuilder<FootballEntry>(fileReader)
                    .withMappingStrategy(mappingStrategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            result = csvToBean.parse();

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
        return result;
    }
}

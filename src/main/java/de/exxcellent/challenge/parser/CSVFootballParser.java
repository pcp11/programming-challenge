package de.exxcellent.challenge.parser;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import de.exxcellent.challenge.model.FootballEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides a parser, that takes a csv file converting it into a List
 * of FootballEntry objects.
 *
 * @author Patrick Christ
 * @since 05.05.18
 */
public class CSVFootballParser implements FileParser<FootballEntry> {

    private static final String[] CSV_HEADER = {"team", "games", "wins", "losses", "draws", "goals", "goalsAllowed", "points"};

    @Override
    public List<FootballEntry> parseFile(String filePath) {

        List<FootballEntry> result = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))){

            ColumnPositionMappingStrategy<FootballEntry> mappingStrategy =
                    new ColumnPositionMappingStrategy<>();

            mappingStrategy.setType(FootballEntry.class);
            mappingStrategy.setColumnMapping(CSV_HEADER);

            CsvToBean<FootballEntry> csvToBean = new CsvToBeanBuilder<FootballEntry>(fileReader)
                    .withMappingStrategy(mappingStrategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            result.addAll(csvToBean.parse());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

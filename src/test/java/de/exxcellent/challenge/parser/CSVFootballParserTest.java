package de.exxcellent.challenge.parser;

import de.exxcellent.challenge.App;
import de.exxcellent.challenge.model.FootballEntry;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author pc
 * @since 05.05.18
 */
public class CSVFootballParserTest {

    private CSVFootballParser csvFootballParser;

    private FootballEntry footballEntryA;
    private FootballEntry footballEntryB;

    @Before
    public void setUp() throws Exception {
        csvFootballParser = new CSVFootballParser();

        footballEntryA = new FootballEntry("Arsenal",38,26,9,3,79,36,87);
        footballEntryB = new FootballEntry("Tottenham",38,14,8,16,49,53,50);
    }

    @Test
    public void parseFile() {
        List<FootballEntry> footballEntries =  csvFootballParser.parseFile(App.footballCSV);

        Assert.assertEquals(footballEntryA, footballEntries.get(0));
        Assert.assertEquals(footballEntryB, footballEntries.get(8));

        Assert.assertNotEquals(footballEntryA, footballEntries.get(1));
        Assert.assertNotEquals(footballEntryB, footballEntries.get(7));
    }
}

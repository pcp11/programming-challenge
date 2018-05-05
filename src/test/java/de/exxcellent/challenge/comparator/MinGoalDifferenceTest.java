package de.exxcellent.challenge.comparator;

import de.exxcellent.challenge.model.FootballEntry;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author pc
 * @since 05.05.18
 */
public class MinGoalDifferenceTest {

    private MinGoalDifference minGoalDifferenceComp;

    private FootballEntry footballEntryA;
    private FootballEntry footballEntryB;

    @Before
    public void setUp() throws Exception {
        minGoalDifferenceComp = new MinGoalDifference();

        footballEntryA = new FootballEntry("Arsenal",38,26,9,3,79,36,87);
        footballEntryB = new FootballEntry("Tottenham",38,14,8,16,49,53,50);
    }

    @Test
    public void compare() {
        Assert.assertTrue(minGoalDifferenceComp.compare(footballEntryA, footballEntryB) < 0);
        footballEntryA.setGoalsAllowed(78);
        Assert.assertTrue(minGoalDifferenceComp.compare(footballEntryA, footballEntryB) > 0);
        footballEntryB.setGoalsAllowed(50);
        Assert.assertEquals(0, minGoalDifferenceComp.compare(footballEntryA, footballEntryB));
    }
}

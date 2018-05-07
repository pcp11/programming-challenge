package de.exxcellent.challenge.comparator;

import de.exxcellent.challenge.model.FootballEntry;

import java.util.Comparator;

/**
 * Provides a comparison for FootballEntry objects based on the
 * minimal difference between scored and received goals.
 *
 * @author Patrick Christ
 * @since 05.05.18
 */
public class MinGoalDifference implements Comparator<FootballEntry> {

    @Override
    public int compare(FootballEntry o1, FootballEntry o2) {
        return Math.abs(o2.getGoals() - o2.getGoalsAllowed()) - Math.abs(o1.getGoals() - o1.getGoalsAllowed());
    }
}

package de.exxcellent.challenge.model;

import java.util.Objects;

/**
 * Provides a representation of football data.
 *
 * @author Patrick Christ
 * @since 05.05.18
 */
public class FootballEntry {

    private String team;
    private int games, wins, losses, draws, goals, goalsAllowed, points;

    public FootballEntry() {
    }

    public FootballEntry(String team, int games, int wins, int losses, int draws, int goals, int goalsAllowed, int points) {
        this.team = team;
        this.games = games;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.goals = goals;
        this.goalsAllowed = goalsAllowed;
        this.points = points;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoalsAllowed() {
        return goalsAllowed;
    }

    public void setGoalsAllowed(int goalsAllowed) {
        this.goalsAllowed = goalsAllowed;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballEntry that = (FootballEntry) o;
        return games == that.games &&
                wins == that.wins &&
                losses == that.losses &&
                draws == that.draws &&
                goals == that.goals &&
                goalsAllowed == that.goalsAllowed &&
                points == that.points &&
                Objects.equals(team, that.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(team, games, wins, losses, draws, goals, goalsAllowed, points);
    }
}

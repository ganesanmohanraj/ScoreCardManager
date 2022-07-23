package scoreboard;

import java.util.ArrayList;
import java.util.Scanner;

/**
*
* @author Ganesan Mohanraj
*/
public class WorldCupManager {

	private final int numberOfTeams;

	private final ArrayList<FootballTeam> teamList;
	private final Scanner scanner;
	private final ArrayList<FootballMatch> matches;

	public WorldCupManager(int numberOfTeams) {

		this.numberOfTeams = numberOfTeams;
		teamList = new ArrayList<>();
		matches = new ArrayList<>();
		scanner = new Scanner(System.in);
		displayMenu();

	}

	private void displayMenu() {

		while (true) {

			System.out.println("Football World Cup menu: ");
			System.out.println("1. Add new team");
			System.out.println("2. Delete existing team");
			System.out.println("3. Add a Played Match details");
			System.out.println("4. Display Score Card");
			String line = scanner.nextLine();
			int command = 0;
			try {
				command = Integer.parseInt(line);
			} catch (Exception e) {

			}

			switch (command) {
			case 1:
				addTeam();
				break;
			case 2:
				deleteTeam();
				break;
			case 3:
				addPlayedMatch();
				break;
			case 4:
				displayScoreBoard();
				break;
			default:
	            System.out.println("Wrong Command");
			}

		}
	}

	private void addTeam() {

		if (teamList.size() == numberOfTeams) {
			System.out.println("Can't add more teams to world cup");
			return;
		}

		FootballTeam team = new FootballTeam();
		System.out.println("Enter Team Name: ");
		String line = scanner.nextLine();
		team.setName(line);

		if (teamList.contains(team)) {
			System.out.println("This Team is already in the teams list");
			return;
		}
		
		teamList.add(team);

	}

	private void deleteTeam() {

		System.out.println("Enter Team Name: ");
		String line = scanner.nextLine();
		for (FootballTeam team : teamList) {
			if (team.getName().equals(line)) {
				teamList.remove(team);
				System.out.println("Team " + team.getName() + " removed");
				return;
			}
		}
		System.out.println("No such Team in World Cup");
	}
	
	private void addPlayedMatch() {

		System.out.println("Enter Home Team: ");
		String line = scanner.nextLine();

		FootballTeam home = null;

		for (FootballTeam team : teamList) {
			if (team.getName().equals(line))
				home = team;
		}

		if (home == null) {
			System.out.println("No such team in World Cup");
			return;
		}

		System.out.println("Enter Away Team: ");
		line = scanner.nextLine();

		FootballTeam away = null;

		for (FootballTeam team : teamList) {
			if (team.getName().equals(line))
				away = team;
		}

		if (away == null) {
			System.out.println("No such team in World Cup");
			return;
		}

		System.out.println("Enter home team goals: ");
		line = scanner.nextLine();
		int homeGoals = -1;
		try {
			homeGoals = Integer.parseInt(line);
		} catch (Exception e) {
		}
		if (homeGoals == -1) {
			System.out.println("You have to enter number of goals");
			return;
		}

		System.out.println("Enter away team goals: ");
		line = scanner.nextLine();
		int awayGoals = -1;
		try {
			awayGoals = Integer.parseInt(line);
		} catch (Exception e) {
		}
		if (awayGoals == -1) {
			System.out.println("You have to enter number of goals");
			return;
		}

		FootballMatch match = new FootballMatch();
		match.setHomeTeam(home);
		match.setAwayTeam(away);
		match.setHomeTeamScore(homeGoals);
		match.setAwayTeamScore(awayGoals);
		matches.add(match);

	}
	
	private void displayScoreBoard() {
		  for(FootballMatch match : matches) {
	            System.out.println(match.getHomeTeam().getName()+" "+ match.getHomeTeamScore()+" - "+ match.getAwayTeam().getName()+" "+ match.getAwayTeamScore());
	    }
	}

}

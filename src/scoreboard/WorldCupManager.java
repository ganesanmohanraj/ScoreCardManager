package scoreboard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ganesan Mohanraj
 */
public class WorldCupManager {
	
	public static enum State {
		START, PLAYING ,END
	}

	private ArrayList<FootballTeam> teamList;
	private ArrayList<FootballMatch> matches;	
	
	private State state;

	public WorldCupManager() {
		state = State.END;
	}	
	
	
	public State getState() {
		return state;
	}


	/**
	 * Start a new game
	 */
	public void start() {
		reset();
			
		state = State.START;
		
		readTeams();
		readMatchData();
	}
	
	/**
	 * Finish the current game
	 */
	public void finish() {
		reset();
	}
	
	/**
	 * Displays the current Score Board
	 */
	public String checkPlayState() {
		
		if (state == State.END) {
			return "No game currently in progress";
		}
		
		state = State.PLAYING;
		return "Game Started";
		
		
	}

	/**
	 * Displays the current Score Board
	 */
	public void displayScoreBoard() {
		
		if (state == State.END) {
			System.out.println("No game currently in progress");
		}
		
		state = State.PLAYING;
		for (FootballMatch match : matches) {
			System.out.println(match.getHomeTeam().getName() + " " + match.getHomeTeamScore() + " - "
					+ match.getAwayTeam().getName() + " " + match.getAwayTeamScore());
		}
	}
	
	/**
	 * @param updateMatch
	 */
	public void updateMatch(FootballMatch updateMatch) {
		
		if (state == State.END) {
			System.out.println("No game currently in progress");
		}
		
		state = State.PLAYING;
		for (FootballMatch match : matches) {
			String home = match.getHomeTeam().getName();
			String updateHome= updateMatch.getHomeTeam().getName();
			String away= match.getAwayTeam().getName();
			String updateAway= updateMatch.getAwayTeam().getName();
			if((updateHome.equals(home)) && (updateAway.equals(away))) {
				matches.set( matches.indexOf(match) , updateMatch);
			}
		}
		
	}
	
	private void readTeams() {
		try {

			File file = new File("resources/teams.txt").getCanonicalFile();
			teamList = new ArrayList<>();

			Scanner scan = new Scanner(file);

			String line = "";

			while (scan.hasNextLine()) {

				line = scan.nextLine();
				FootballTeam team = new FootballTeam();
				team.setName(line);

				if (!teamList.contains(team)) {
					teamList.add(team);
				}

			}
			scan.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readMatchData() {
		try {

			File file = new File("resources/matches.txt").getCanonicalFile();

			Scanner scan = new Scanner(file);
			matches = new ArrayList<>();

			String fileString = "";

			while (scan.hasNextLine()) {

				fileString = scan.nextLine();
				String[] readInfo = fileString.split("\\\\t|:");

				if (readInfo.length == 2) {

					FootballTeam homeTeam = new FootballTeam();
					FootballTeam awayTeam = new FootballTeam();
					int homeGoals = 0;
					int awayGoals = 0;

					String[] teamInfo = readInfo[0].split("\\\\t|-");

					if (teamInfo.length == 2) {
						homeTeam.setName(teamInfo[0].trim());
						awayTeam.setName(teamInfo[1].trim());
					}

					String[] scoreInfo = readInfo[1].split("\\\\t|-");

					if (teamInfo.length == 2) {

						try {
							homeGoals = Integer.parseInt(scoreInfo[0].trim());
							awayGoals = Integer.parseInt(scoreInfo[1].trim());
						} catch (Exception e) {
						}

					}

					FootballMatch match = new FootballMatch();
					match.setHomeTeam(homeTeam);
					match.setAwayTeam(awayTeam);
					match.setHomeTeamScore(homeGoals);
					match.setAwayTeamScore(awayGoals);
					matches.add(match);

				}
			}
			scan.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reset the game to a new one.
	 */
	private void reset() {
		teamList = null;
		matches = null;
		state = State.END;
	}

}

package scoreboard;

/**
*
* @author Ganesan Mohanraj
*/
public class FootballMatch {
	
	private FootballTeam homeTeam;
	private FootballTeam awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;

	public FootballTeam getHomeTeam() {
		return homeTeam;
	}
	
	public void setHomeTeam(FootballTeam homeTeam) {
		this.homeTeam = homeTeam;
	}
	
	public FootballTeam getAwayTeam() {
		return awayTeam;
	}
	
	public void setAwayTeam(FootballTeam awayTeam) {
		this.awayTeam = awayTeam;
	}
	
	public int getHomeTeamScore() {
		return homeTeamScore;
	}

	public void setHomeTeamScore(int homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}

	public int getAwayTeamScore() {
		return awayTeamScore;
	}

	public void setAwayTeamScore(int awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}
	

}

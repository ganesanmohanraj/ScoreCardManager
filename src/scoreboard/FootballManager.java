package scoreboard;

/**
*
* @author Ganesan Mohanraj
*/
public class FootballManager {
	
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	WorldCupManager wcm = new WorldCupManager();
    	wcm.start();
    	wcm.displayScoreBoard();
    	
    	FootballMatch match = new FootballMatch();
    	
    	FootballTeam homeTeam = new FootballTeam();
    	homeTeam.setName("Mexico");
    	match.setHomeTeam(homeTeam);
    	    	
    	FootballTeam awayTeam = new FootballTeam();
    	awayTeam.setName("Canada");
    	match.setAwayTeam(awayTeam);
    	
    	match.setHomeTeamScore(1);
    	match.setAwayTeamScore(6);
    	
    	wcm.updateMatch(match);
    	System.out.println("****************After Update***********");
    	wcm.displayScoreBoard();
     	
    	wcm.finish();
    }

}

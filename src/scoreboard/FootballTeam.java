package scoreboard;

/**
*
* @author Ganesan Mohanraj
*/
public class FootballTeam {

	private String name;
	private String score;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getScore() {
		return score;
	}
	
	public void setScore(String score) {
		this.score = score;
	}
	
    @Override
    public boolean equals(Object o) {
        return this.name.equals(((FootballTeam)o).name);
    }
	
}

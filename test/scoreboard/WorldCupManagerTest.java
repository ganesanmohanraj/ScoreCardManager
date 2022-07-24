package scoreboard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WorldCupManagerTest {

	private WorldCupManager wcManger;
	
	@Before
	public void createFootball() {
		wcManger = new WorldCupManager();
	}
	
	@Test
	public void testStartGame() {
		wcManger.start();
		Assert.assertEquals(wcManger.getState(), WorldCupManager.State.START);
	}
	
	@Test
	public void testFinishGame() {
		wcManger.finish();
		Assert.assertEquals(wcManger.getState(), WorldCupManager.State.END);
	}
	
	@Test
	public void testDisplayNoGameStarted() {
				
		String tested = wcManger.checkPlayState();
		String expected = "No game currently in progress";
		
		Assert.assertEquals(tested, expected);
		Assert.assertEquals(wcManger.getState(), WorldCupManager.State.END);
	}
	
	@Test
	public void testDisplayGame() {
		testStartGame();
				
		String tested = wcManger.checkPlayState();
		String expected = "Game Started";
		
		Assert.assertEquals(tested, expected);
		Assert.assertEquals(wcManger.getState(), WorldCupManager.State.PLAYING);
	}
	
}

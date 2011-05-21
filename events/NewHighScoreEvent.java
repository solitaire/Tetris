package pl.edu.pw.elka.www.proz.tetris.events;

public class NewHighScoreEvent extends GameEvent 
{
	
	public final String playerName;
	
	public NewHighScoreEvent(String playerName)
	{
		this.playerName = playerName;
	}
	
	public final String getPlayerName()
	{
		return playerName;
	}
}

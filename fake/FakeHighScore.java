package pl.edu.pw.elka.www.proz.tetris.fake;

import java.util.Map;

public class FakeHighScore
{
	private final Map<String, Integer> highScores[];
	
	public FakeHighScore(final Map<String, Integer>[] highScores) 
	{
		this.highScores = highScores;
	}
	
	public final Map<String, Integer>[] getHighScore()
	{
		return highScores;
	}
	
}

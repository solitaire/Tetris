package tetris.events;

/**
 * Nowy wysoki wynik
 * 
 * @author Anna Stępień
 *
 */
public class NewHighScoreEvent extends GameEvent 
{
	/** Nazwa gracza */
	private final String playerName;
	/** Liczba punktów */
	private final int score;
	
	/**
	 * Tworzy zdarzenie
	 * 
	 * @param playerName nazwa gracza
	 */
	public NewHighScoreEvent(String playerName, int score)
	{
		this.playerName = playerName;
		this.score = score;
	}
	
	/**
	 * Zwraca nazwę gracza
	 * 
	 * @return nazwa gracza
	 */
	public final String getPlayerName()
	{
		return playerName;
	}
	
	/**
	 * Zwraca liczbę punktów
	 * 
	 * @return liczba punktów
	 */
	public final int getScore()
	{
		return score;
	}
}

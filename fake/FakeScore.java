package pl.edu.pw.elka.www.proz.tetris.fake;

/**
 * Reprezentuje wynik gry (wynik, poziom, liczba usuniętch wierszy)
 *
 */
public class FakeScore 
{
	
	/** Wynik */
	final int score;
	
	/** Poziom */
	final int level;
	
	/** Liczba usuniętych wierszy */
	final int removedRows;
	
	/**
	 * 
	 * @param score Wynik
	 * @param level Poziom
	 * @param removedRows Liczba usuniętych wierszy
	 */
	public FakeScore(final int score, final int level, final int removedRows)
	{
		this.score = score;
		this.level = level;
		this.removedRows = removedRows;
	}
	
	/**
	 * Zwraca wynik 
	 * @return wynik
	 */
	public final int getScore()
	{
		return score;
	}
	
	/**
	 * Zwraca poziom gry
	 * @return poziom
	 */
	public final int getLevel()
	{
		return level;
	}
	
	/**
	 * Zwraca liczbę usuniętych wierszy
	 * @return liczba usuniętych wierszy
	 */
	public final int getRemovedRows()
	{
		return removedRows;
	}

}

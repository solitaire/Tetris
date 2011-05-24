package pl.edu.pw.elka.www.proz.tetris.fake;

import java.util.ArrayList;

/**
 * Klasa reprezentująca planszę gry
 *
 */
public class FakeBoard 
{
	
	/** Bloki planszy */
	private ArrayList<ArrayList<FakeBlock>> board;
	
	
	/**
	 * Tworzy nowy obiekt planszy
	 * @param fakeRows lista wierszy składających się na planszę
	 */
	public FakeBoard(final ArrayList<ArrayList<FakeBlock>> fakeRows)
	{
		board = fakeRows;
	}
	
	/**
	 * Zwraca planszę gry przeznaczoną dla widoku
	 * @return plansza gry
	 */
	public final ArrayList<ArrayList<FakeBlock>> getRows()
	{
		return board;
	}

}

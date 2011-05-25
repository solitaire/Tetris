package pl.edu.pw.elka.www.proz.tetris.config;

import java.awt.Color;

/**
 * Konfiguracja gry
 * 
 * @author Anna Stępień
 *
 */
public class TetrisConfig 
{
	/** Bonusowe punkty za usunięty wiersz */
	public final static int REMOVED_ROWS_BONUS = 15;
	/** Bonusowe punkty za opuszczenie klocka na dno planszy */
	public final static int INSTANT_DROP_BONUS = 10;
	/** Bonusowe punkty za przyspieszenie opadania */
	public final static int FALL_BONUS = 5;
	/** Maksymalna liczba najlepszych wyników */
	public final static int MAX_HIGHSCORES = 10;
	/* Wysokość planszy*/
	public final static int HEIGHT = 22;
	/* Szerokość planszy */
	public final static int WIDTH = 12;
	/* Kolor obramowania planszy */
	public final static Color BORDER_COLOR = Color.DARK_GRAY;
	/**Plik z danymi */
	public static final String HIGHSCORE_FILE = "score.txt";
	/** Współrzędna x na której pojawia się nowy klocek */
	public static final int BOARD_X_CENTER = 6;
	/** Współrzędna y na której pojawia się nowy klocek */
	public static final int BOARD_Y_CENTER = 20;
	
	
	
	private TetrisConfig()
	{
		
	}
	

}

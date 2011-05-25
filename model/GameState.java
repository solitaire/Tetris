package pl.edu.pw.elka.www.proz.tetris.model;

/**
 * Reprezentuje stan gry
 * 
 * @author Anna Stępień
 */
enum GameState 
{
	/** Gra jest aktywna */
	RUNNING,
	/** Gra jest nie rozpoczęta */
	NOT_RUNNING,
	/** Gra jest wstrzymana */
	PAUSED,
	/** Gra została zakończona */
	ENDED
}

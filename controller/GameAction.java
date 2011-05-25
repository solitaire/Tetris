package pl.edu.pw.elka.www.proz.tetris.controller;

import pl.edu.pw.elka.www.proz.tetris.events.GameEvent;

/**
 * Abstrakcyjna klasa reprezentująca akcję gry
 *
 * @author Anna Stępień
 */
abstract class GameAction
{
	
	public abstract void execute(final GameEvent event);
	
}

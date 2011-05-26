package tetris.controller;

import tetris.events.GameEvent;

/**
 * Abstrakcyjna klasa reprezentująca akcję gry
 *
 * @author Anna Stępień
 */
abstract class GameAction
{
	
	public abstract void execute(final GameEvent event);
	
}

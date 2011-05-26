
package tetris;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import tetris.controller.Controller;
import tetris.events.GameEvent;
import tetris.model.Model;
import tetris.view.View;

/**
 * Implementacja gry Tetris
 * 
 * @author Anna Stępień
 * 
 */
public class Tetris 
{

	/**
	 * Uruchamia grę.
	 * 
	 * @param args nie używane
	 */
	public static void main(String[] args)
	{
		
		BlockingQueue<GameEvent> eventQueue = new LinkedBlockingQueue<GameEvent>();
		final View view = new View(eventQueue);
		final Model model = new Model();
		final Controller controller = new Controller(model, view, eventQueue);
		
		view.display();
		
		controller.start();

	}
}
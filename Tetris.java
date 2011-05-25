
package pl.edu.pw.elka.www.proz.tetris;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import pl.edu.pw.elka.www.proz.tetris.controller.Controller;
import pl.edu.pw.elka.www.proz.tetris.events.GameEvent;
import pl.edu.pw.elka.www.proz.tetris.model.Model;
import pl.edu.pw.elka.www.proz.tetris.view.View;

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
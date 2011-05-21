
package pl.edu.pw.elka.www.proz.tetris;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import pl.edu.pw.elka.www.proz.tetris.controller.Controller;
import pl.edu.pw.elka.www.proz.tetris.events.GameEvent;
import pl.edu.pw.elka.www.proz.tetris.model.Model;
import pl.edu.pw.elka.www.proz.tetris.view.View;

/**
 * Implementacja gry Tetris
 *
 */
public class Tetris 
{

	/**
	 * Tworzy nowy obiekt gry tetris
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		BlockingQueue<GameEvent> eventQueue = new LinkedBlockingQueue<GameEvent>();
		final View view = new View(eventQueue);
		final Model model = new Model();
		final Controller controller = new Controller(model, view, eventQueue);
		
		view.display();
		
		controller.run();
	}
}
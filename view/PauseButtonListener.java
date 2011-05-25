package pl.edu.pw.elka.www.proz.tetris.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import pl.edu.pw.elka.www.proz.tetris.events.GameEvent;
import pl.edu.pw.elka.www.proz.tetris.events.PauseButtonPressedEvent;

/**
 * Listener przycisku pauzy
 * 
 * @author Anna Stępień
 *
 */
class PauseButtonListener implements ActionListener 
{
	/** Kolejka zdarzeń */
	private final BlockingQueue<GameEvent> eventQueue;

	public PauseButtonListener(BlockingQueue<GameEvent> queue)
	{
		eventQueue = queue;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try 
		{
			eventQueue.put(new PauseButtonPressedEvent());
		} 
		catch (InterruptedException e1) 
		{
			e1.printStackTrace();
		}
	}

}

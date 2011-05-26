package tetris.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import tetris.events.GameEvent;
import tetris.events.PauseButtonPressedEvent;

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

	/**
	 * Tworzy nowy listener
	 * 
	 * @param queue kolejka zdarzeń
	 */
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

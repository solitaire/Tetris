package tetris.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import tetris.events.GameEvent;
import tetris.events.StartButtonPressedEvent;

/**
 * Listener przycisku start 
 * 
 * @author Anna Stępień
 *
 */
class StartButtonListener implements ActionListener 
{
	/** Kolejka zdarzeń */
	private BlockingQueue<GameEvent> eventQueue;
	
	/**
	 * Tworz nowy listener
	 * 
	 * @param queue kolejka zdarzeń
	 */
	public StartButtonListener(BlockingQueue<GameEvent> queue)
	{
		eventQueue = queue;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		try 
		{
			eventQueue.put(new StartButtonPressedEvent());
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

}

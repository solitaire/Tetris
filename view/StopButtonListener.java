package tetris.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import tetris.events.GameEvent;
import tetris.events.StopButtonPressedEvent;

/**
 * Listener przycisku stop
 * 
 * @author Anna Stępień
 *
 */
public class StopButtonListener implements ActionListener 
{
	/** Kolejka zdarzeń */
	private final BlockingQueue<GameEvent> blockingQueue;
	
	/**
	 * Tworzy nowy listener
	 * 
	 * @param queue kolejka zdarzeń
	 */
	public StopButtonListener(BlockingQueue<GameEvent> queue)
	{
		blockingQueue = queue;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		try 
		{
			blockingQueue.put(new StopButtonPressedEvent());
		} 
		catch (InterruptedException e1) 
		{
			e1.printStackTrace();
		}
	}

}

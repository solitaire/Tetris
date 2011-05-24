package pl.edu.pw.elka.www.proz.tetris.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import pl.edu.pw.elka.www.proz.tetris.events.GameEvent;
import pl.edu.pw.elka.www.proz.tetris.events.StopButtonPressedEvent;

public class StopButtonListener implements ActionListener 
{
	
	private final BlockingQueue<GameEvent> blockingQueue;
	
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

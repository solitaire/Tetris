package pl.edu.pw.elka.www.proz.tetris.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import pl.edu.pw.elka.www.proz.tetris.events.GameEvent;
import pl.edu.pw.elka.www.proz.tetris.events.StartButtonPressedEvent;

class StartButtonListener implements ActionListener 
{
	
	private BlockingQueue<GameEvent> eventQueue;
	
	public StartButtonListener(BlockingQueue<GameEvent> queue)
	{
		eventQueue = queue;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		eventQueue.add(new StartButtonPressedEvent());
	}

}

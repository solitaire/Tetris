package pl.edu.pw.elka.www.proz.tetris.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import pl.edu.pw.elka.www.proz.tetris.events.GameEvent;
import pl.edu.pw.elka.www.proz.tetris.events.PauseButtonPressedEvent;

class PauseButtonListener implements ActionListener {
	
	private final BlockingQueue<GameEvent> eventQueue;

	public PauseButtonListener(BlockingQueue<GameEvent> queue){
		eventQueue = queue;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		eventQueue.add(new PauseButtonPressedEvent());
	}

}

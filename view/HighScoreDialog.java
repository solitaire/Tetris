package pl.edu.pw.elka.www.proz.tetris.view;
import java.util.concurrent.BlockingQueue;

import javax.swing.JOptionPane;

import pl.edu.pw.elka.www.proz.tetris.events.GameEvent;

class HighScoreDialog{

	private static final long serialVersionUID = -6301361583149995505L;
	private final JOptionPane optionPane;

	public HighScoreDialog(BlockingQueue<GameEvent> queue) {
		optionPane = new JOptionPane();
	}


}

package pl.edu.pw.elka.www.proz.tetris.view;

import java.util.concurrent.BlockingQueue;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import pl.edu.pw.elka.www.proz.tetris.events.GameEvent;

/**
 * Panel sterujący 
 * 
 * @author Anna Stępień
 *
 */
class ControlPanel extends JPanel 
{
	
	private static final long serialVersionUID = 1L;
	/* Przycisk rozpoczynający nową grę */
	private JButton startButton;
	/* Przycisk kończący grę */
	private JButton stopButton;
	/* Przycisk pauzujący/wznawiający grę */
	private JButton pauseButton;
	/* Kolejka blokująca przechowująca zdarzenia gry */
	private BlockingQueue<GameEvent> eventQueue;
	
	/**
	 * Tworzy nowy panel kontrolny
	 * 
	 * @param queue kolejka blokująca
	 */
	public ControlPanel(BlockingQueue<GameEvent> queue)
	{
		
		eventQueue = queue;
		startButton = new JButton("Start");
		stopButton  = new JButton("Stop");
		pauseButton = new JButton("Pauza");
		
		stopButton.setEnabled(false);
		pauseButton.setEnabled(false);
		
		startButton.setFocusable(false);
		stopButton.setFocusable(false);
		pauseButton.setFocusable(false);
		
		add(startButton);
		add(stopButton);
		add(pauseButton);
		
		startButton.addActionListener(new StartButtonListener(eventQueue));
		stopButton.addActionListener(new StopButtonListener(eventQueue));
		pauseButton.addActionListener(new PauseButtonListener(eventQueue));
	}
	
	
	/**
	 * Odblokowuje przyciski odpowiedzialne za pauzę i koniec gry
	 * 
	 */
	public void handleStart()
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			
			@Override
			public void run() 
			{
				stopButton.setEnabled(true);
				pauseButton.setEnabled(true);
			}
		});
		
	}
}

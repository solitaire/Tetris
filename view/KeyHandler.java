package pl.edu.pw.elka.www.proz.tetris.view;

import java.awt.event.ActionEvent;
import java.util.concurrent.BlockingQueue;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import pl.edu.pw.elka.www.proz.tetris.events.GameEvent;
import pl.edu.pw.elka.www.proz.tetris.events.KeyDownPressedEvent;
import pl.edu.pw.elka.www.proz.tetris.events.KeyLeftPressedEvent;
import pl.edu.pw.elka.www.proz.tetris.events.KeyRightPressedEvent;
import pl.edu.pw.elka.www.proz.tetris.events.KeyUpPressedEvent;
import pl.edu.pw.elka.www.proz.tetris.events.SpacePressedEvent;

/**
 * Realizuje obsługę klawiatury
 *
 */
class KeyHandler 
{
	
	private BlockingQueue<GameEvent> eventQueue;
	private final JComponent component;
	
	public KeyHandler(JComponent jComponent, BlockingQueue<GameEvent> queue)
	{
		component = jComponent;
		eventQueue = queue;
		createInputMap();
		createActionMap();
	}
	
	private void createInputMap()
	{
	    component.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "space");
	    component.getInputMap().put(KeyStroke.getKeyStroke("UP"), "keyup");
	    component.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "keyright");
	    component.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "keydown");
	    component.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "keyleft");
	}
	
	private void createActionMap()
	{
	    component.getActionMap().put("space", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eventQueue.add(new SpacePressedEvent());
				
			}
		});
	    
		component.getActionMap().put("keyup", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				eventQueue.add(new KeyUpPressedEvent());
				
			}
		});
	    
	    component.getActionMap().put("keyright", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				eventQueue.add(new KeyRightPressedEvent());
				
			}
		});
	    
	    component.getActionMap().put("keydown", new AbstractAction() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				eventQueue.add(new KeyDownPressedEvent());
				
			}
		});
	    
	    component.getActionMap().put("keyleft", new AbstractAction() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				eventQueue.add(new KeyLeftPressedEvent());
				
			}
		});
	}

}

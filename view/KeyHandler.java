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
 * @author Anna Stępień
 */
class KeyHandler 
{
	
	/** Kolejka zdarzeń */
	private BlockingQueue<GameEvent> eventQueue;
	/** Komponent dla którego realizowana jest obsługa klawiatury */
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
	    component.getActionMap().put("space", new AbstractAction() 
	    {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try 
				{
					eventQueue.put(new SpacePressedEvent());
				} 
				catch (InterruptedException e1) 
				{
					e1.printStackTrace();
				}
				
			}
		});
	    
		component.getActionMap().put("keyup", new AbstractAction() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					eventQueue.put(new KeyUpPressedEvent());
				}
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				
			}
		});
	    
	    component.getActionMap().put("keyright", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					eventQueue.put(new KeyRightPressedEvent());
				} 
				catch (InterruptedException e) 
				{
					
					e.printStackTrace();
				}
				
			}
		});
	    
	    component.getActionMap().put("keydown", new AbstractAction() 
	    {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					eventQueue.put(new KeyDownPressedEvent());
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
	    
	    component.getActionMap().put("keyleft", new AbstractAction() 
	    {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					eventQueue.put(new KeyLeftPressedEvent());
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				
			}
		});
	}

}

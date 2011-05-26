package tetris.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import tetris.config.ViewConfig;
import tetris.events.DisplayHighScoreEvent;
import tetris.events.GameEvent;
import tetris.events.StartButtonPressedEvent;


/**
 * Glowne okno aplikacji
 * 
 * @author Anna Stępień
 */
public class GameFrame extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	/** Menu */
	private final JMenuBar menuBar;
	/** Kolejka zdarzeń */
	private BlockingQueue<GameEvent> eventQueue;
	
	/**
	 * Tworzy nowe okno aplikacji
	 * 
	 * @param queue kolejka zdarzeń
	 */
	public GameFrame(BlockingQueue<GameEvent> queue)
	{
		setSize(ViewConfig.FRAME_WIDTH, ViewConfig.FRAME_HEIGHT);
		setResizable(false);
		setTitle(Messages.getString("GameFrame.Title")); //$NON-NLS-1$
		eventQueue = queue;
		
		menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu(Messages.getString("GameFrame.MainMenu")); //$NON-NLS-1$
		JMenu helpMenu = new JMenu(Messages.getString("GameFrame.Help")); //$NON-NLS-1$
		
		JMenuItem newGameItem = new JMenuItem(Messages.getString("GameFrame.NewGame")); //$NON-NLS-1$
		JMenuItem scoreItem = new JMenuItem(Messages.getString("GameFrame.Score")); //$NON-NLS-1$
		JMenuItem exitItem = new JMenuItem(Messages.getString("GameFrame.Close")); //$NON-NLS-1$
		
		JMenuItem aboutItem = new JMenuItem(Messages.getString("GameFrame.About")); //$NON-NLS-1$
		
		
		newGameItem.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					eventQueue.put(new StartButtonPressedEvent());
				} 
				catch (InterruptedException ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		
		scoreItem.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					eventQueue.put(new DisplayHighScoreEvent());
				} 
				catch (InterruptedException e1) 
				{
					e1.printStackTrace();
				}
			}
		});
		
		
		exitItem.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		
		
		aboutItem.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				final String about = Messages.getString("GameFrame.Info"); //$NON-NLS-1$
				JOptionPane.showMessageDialog(null, about);
			}
		});
		
		
		gameMenu.add(newGameItem);
		gameMenu.add(scoreItem);
		gameMenu.addSeparator();
		gameMenu.add(exitItem);
		
		helpMenu.add(aboutItem);
		
		menuBar.add(gameMenu);
		menuBar.add(helpMenu);
		setJMenuBar(menuBar);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}

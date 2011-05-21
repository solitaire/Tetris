package pl.edu.pw.elka.www.proz.tetris.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pl.edu.pw.elka.www.proz.tetris.events.DisplayHighScores;
import pl.edu.pw.elka.www.proz.tetris.events.GameEvent;
import pl.edu.pw.elka.www.proz.tetris.events.StartButtonPressedEvent;


/**
 * Glowne okno aplikacji
 * @author Anna Stepien
 *
 */
public class GameFrame extends JFrame
{
	
	private final JMenuBar menuBar;
	private final ScoreDialog scoreDialog;
	private BlockingQueue<GameEvent> eventQueue;
	
	public GameFrame(BlockingQueue<GameEvent> queue)
	{
		setSize(640, 850);
		setResizable(false);
		setTitle("Tetris");
		eventQueue = queue;
		
		menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu("Gra");
		JMenu helpMenu = new JMenu("Pomoc");
		
		JMenuItem newGameItem = new JMenuItem("Nowa");
		JMenuItem scoreItem = new JMenuItem("Wyniki");
		JMenuItem exitItem = new JMenuItem("Zakończ");
		
		JMenuItem aboutItem = new JMenuItem("O programie");
		
		
		newGameItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					eventQueue.put(new StartButtonPressedEvent());
				} catch (InterruptedException ex) {
					
					ex.printStackTrace();
				}
			}
		});
		
		scoreItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				scoreDialog.setVisible(true);
			}
		});
		
		
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		aboutItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final String about = "Implementacja gry Tetris.\n" +
						"Autor: Anna Stępień, 2011";
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

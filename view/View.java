package pl.edu.pw.elka.www.proz.tetris.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.concurrent.BlockingQueue;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import pl.edu.pw.elka.www.proz.tetris.events.GameEvent;
import pl.edu.pw.elka.www.proz.tetris.fake.FakeBoard;
import pl.edu.pw.elka.www.proz.tetris.fake.FakeScore;
import pl.edu.pw.elka.www.proz.tetris.fake.FakeShape;

/**
 * Widok gry
 *
 */
public class View {
	
	/* Kolejka blokujaca */
	private BlockingQueue<GameEvent> eventQueue;
	
	/* Glowne okienko aplikacji */
	private GameFrame gameFrame;
	
	/* Panel zawierajacy plansze */
	private BoardPanel boardPanel;
	
	private ControlPanel controlPanel;
	
	private InfoPanel infoPanel;

	private PreviewPanel previewPanel;
	
	private Container rightContainer;
	
	private HighScoreDialog highScoreDialog;

	/**
	 * Tworzy nowy obiekt widoku
	 * @param queue Kolejka blokujaca 
	 */
	public View(BlockingQueue<GameEvent> queue)
	{
		eventQueue = queue;
		gameFrame  = new GameFrame(eventQueue);
		boardPanel = new BoardPanel(eventQueue);
		controlPanel = new ControlPanel(eventQueue);
		infoPanel = new InfoPanel();
		rightContainer = new Container();
		previewPanel = new PreviewPanel();

		
		gameFrame.setLayout(new BorderLayout());
		rightContainer.setLayout(new GridLayout(3, 0));
		
		gameFrame.add(boardPanel, BorderLayout.CENTER);
		rightContainer.add(previewPanel);
		rightContainer.add(infoPanel);
		rightContainer.add(controlPanel);
		gameFrame.add(rightContainer, BorderLayout.LINE_END);
		
		gameFrame.pack();
	}
	
	/**
	 * Wyswietla główne okno aplikacji
	 */
	public void display()
	{
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() 
			{
				gameFrame.setVisible(true);	
			}
		});
	}

	/**
	 * Aktualizuje planszę
	 * @param board Plansza gry
	 */
	public void updateBoard(final FakeBoard board)
	{
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() 
			{
				boardPanel.updateBoard(board);
			}
		});
	}
	
	/**
	 * Czyści planszę
	 */
	public void clearBoard()
	{
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() 
			{
				boardPanel.clear();
			}
		});
	}
	
	/**
	 * Aktualizuje podgląd na następny klocek
	 * @param shape Nastepny klocek
	 */
	public void updatePreviewBoard(final FakeShape shape)
	{
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() 
			{
				previewPanel.updateNextShape(shape);
			}
		});
	}
	
	/**
	 * Aktualizuje punktację
	 * @param score Informacja o punktach
	 */
	public void updateScore(final FakeScore score)
	{
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() 
			{
				infoPanel.updateScore(score);
				infoPanel.updateLevel(score);
				infoPanel.updateRemovedRows(score);
			}
		});
	}

	/**
	 * Odblokowuje przyciski sterowania
	 */
	public void enableButtons() 
	{
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() 
			{
				controlPanel.handleStart();
			}
		});
	}

	public void showGameOverDialog() {
		JOptionPane.showMessageDialog(gameFrame,"Koniec gry!", "Tetris", JOptionPane.PLAIN_MESSAGE);	
	}
	
	public void showHighScoreDialog(){
	
	}
}

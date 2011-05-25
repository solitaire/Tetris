package pl.edu.pw.elka.www.proz.tetris.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

import javax.swing.JPanel;

import pl.edu.pw.elka.www.proz.tetris.config.ViewConfig;
import pl.edu.pw.elka.www.proz.tetris.events.GameEvent;
import pl.edu.pw.elka.www.proz.tetris.fake.FakeBlock;
import pl.edu.pw.elka.www.proz.tetris.fake.FakeBoard;

/**
 * Panel wyświetlający planszę gry
 * 
 * @author Anna Stępień
 */
class BoardPanel extends JPanel
{
	
	private static final long serialVersionUID = 1L;

	/* Kolejka blokująca przechowująca zdarzenia gry */
	private BlockingQueue<GameEvent> eventQueue;
	/* Obłsuga klawiatury */
	private KeyHandler keyHandler;
	/* Obrazek na którym rysowana jest plansza */
	private Image grid;
	
	/**
	 * Tworzy nowy panel planszy
	 * 
	 * @param queue Kolejka zdarzeń gry
	 */
	public BoardPanel(BlockingQueue<GameEvent> queue)
	{
		
		eventQueue = queue;
		keyHandler = new KeyHandler(this, eventQueue);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(ViewConfig.BOARD_WIDTH, ViewConfig.BOARD_HEIGHT));
		
	}
	
	@Override
	protected void paintComponent(Graphics g) 
	{
		
		super.paintComponent(g);
		if (grid != null)
			g.drawImage(grid, 5, 5, null);
		
	}
	
	/**
	 * Rysuje planszę gry wraz z siatką
	 * 
	 * @param board Plansza gry
	 */
	public void updateBoard(FakeBoard board)
	{
		
		Graphics g;
		grid = createImage(ViewConfig.BOARD_WIDTH - 10, ViewConfig.FRAME_HEIGHT - 10);
		g = grid.getGraphics();
		try{
			for (ArrayList<FakeBlock> row : board.getRows()) 
			{
				for (FakeBlock block : row) 
				{
					paintBlock(g, block);
				}
			}
		}
		catch(NullPointerException e)
		{
			grid = null;
		}
		finally
		{
			repaint();
		}
		
	}
	
	/**
	 * Przywraca poczatkowy wygląd planszy
	 * 
	 */
	public void clear()
	{
		
		grid = null;
		repaint();
		
	}
	
	/**
	 * Rysuje pojedynczy kolorowy blok na planszy
	 * 
	 * @param g obiekt Graphics
	 * @param block blok planszy
	 */
	private void paintBlock(Graphics g, FakeBlock block)
	{
		
		g.setColor(Color.GRAY);
		g.drawRect((block.getPosition().getX())*30, (block.getPosition().getY())*30, 30, 30);
		
		if (block.getColor() != null)
		{
			g.setColor(block.getColor());
			g.fillRect((block.getPosition().getX()*30)+1, (block.getPosition().getY()*30)+1, 29, 29);
		}
	}
	
}

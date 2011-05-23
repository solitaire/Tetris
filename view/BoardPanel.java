package pl.edu.pw.elka.www.proz.tetris.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

import javax.swing.JPanel;

import pl.edu.pw.elka.www.proz.tetris.events.GameEvent;
import pl.edu.pw.elka.www.proz.tetris.fake.FakeBlock;
import pl.edu.pw.elka.www.proz.tetris.fake.FakeBoard;

/**
 * Panel wyświetlający planszę gry
 *
 */
class BoardPanel extends JPanel
{
	
	private static final long serialVersionUID = -6725326326347514513L;

	/* Kolejka blokująca przechowująca zdarzenia gry */
	private BlockingQueue<GameEvent> eventQueue;
	
	/* Obłsuga klawiatury */
	private KeyHandler keyHandler;
	
	/* Obrazek na którym rysowana jest plansza */
	private Image grid;
	
	/**
	 * Tworzy nowy panel planszy
	 * @param queue Kolejka zdarzeń gry
	 */
	public BoardPanel(BlockingQueue<GameEvent> queue)
	{
		
		eventQueue = queue;
		keyHandler = new KeyHandler(this, eventQueue);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(375, 675));
		
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
	 * @param board
	 */
	public void updateBoard(FakeBoard board)
	{
		
		Graphics g;
		grid = createImage(365, 665);
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
	 */
	public void clear()
	{
		
		grid = null;
		repaint();
		
	}
	
	/**
	 * Rysuje pojedynczy kolorowy blok na planszy
	 * @param g
	 * @param block
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

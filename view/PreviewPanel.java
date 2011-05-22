package pl.edu.pw.elka.www.proz.tetris.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import pl.edu.pw.elka.www.proz.tetris.fake.FakeBlock;
import pl.edu.pw.elka.www.proz.tetris.fake.FakeShape;

/**
 * Panel wyświetlający podgląd na następny klocek
 *
 */
class PreviewPanel extends JPanel 
{
	
	private static final long serialVersionUID = -681786707529383734L;
	private Image preview;
	
	
	public PreviewPanel()
	{
		setPreferredSize(new Dimension(150, 150));
	}
	
	@Override
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
	    if (preview != null)
	    	g.drawImage(preview, 60, 50, null);
	}
	
	
	/**
	 * 
	 * @param fake Obiekt reprezentujący klocek przeznaczony dla widoku
	 */
	public void updateNextShape(FakeShape shape)
	{
		Graphics g;
		preview = createImage(150, 150);
		g = preview.getGraphics();
	    g.setColor(Color.WHITE);
	    g.fillRect(0,0,100,100);
	    
	    try
	    {
			for (FakeBlock block : shape.getBlocks()) 
			{
				g.setColor(Color.GRAY);
				g.drawRect(((2+block.getPosition().getX())*20), (((2-block.getPosition().getY()))*20), 20, 20);
				g.setColor(block.getColor());
				g.fillRect(((2+block.getPosition().getX())*20)+1, (((2-block.getPosition().getY()))*20)+1, 19, 19);
			}
	    }
	    catch (NullPointerException e)
	    {
	    	preview = null;
	    }
	    finally
	    {	
	    	repaint();
	    }
	}
}

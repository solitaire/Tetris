package pl.edu.pw.elka.www.proz.tetris.fake;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import pl.edu.pw.elka.www.proz.tetris.model.Coordinates;

/**
 * Klasa reprezentująca klocek
 * 
 * @author Anna Stępień
 */
public class FakeShape 
{
	
	/** Bloki klocka */
	private final Set<FakeBlock> blocks;
	
	/**
	 * Tworzy nowy obiekt klocka przeznaczony dla widoku
	 * 
	 * @param shapeBlocks Zbiór współrzędnych z jakich składa się klocek
	 * @param color kolor klocka
	 */
	public FakeShape(final Set<Coordinates> shapeBlocks, final Color color)
	{
		blocks = new HashSet<FakeBlock>();
		
		for (Coordinates block : shapeBlocks) 
		{
			blocks.add(new FakeBlock(new Coordinates(block.getX(), (block.getY())), color));
		}
	}
	
	
	/**
	 * Zwraca zbiór bloczków z których zbudowany jest klocek
	 * 
	 * @return bloczki składające się na kocek
	 */
	public final Set<FakeBlock> getBlocks()
	{
		return blocks;
	}

}

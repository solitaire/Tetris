package pl.edu.pw.elka.www.proz.tetris.model;

import java.awt.Color;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import pl.edu.pw.elka.www.proz.tetris.fake.FakeShape;


/**
 * Klasa reprezentująca klocek
 */
class Shape 
{
	
	/*  Współrzdne środka */
	private Coordinates center;
	/*Kolor*/
	private Color color;
	/* Zbiór punktów tworzących klocek */
	private Set<Coordinates> blocks;
	/** Strategia obrotów */
	private RotationStrategy rotationStrategy;
	
	
	/**
	 * Tworzy nowy obiekt klocka o zadanych współrzędnych i kolorze
	 * @param blocks zbiór punktów reprezentujących klocek
	 * @param color kolor klocka
	 * @param rotationStrategy sposób obrotów
	 */
    public Shape(final Set<Coordinates> blocks, final Color color, RotationStrategy rotationStrategy)
    {
    	this.blocks = blocks;
    	this.color = color;
    	this.rotationStrategy = rotationStrategy;
		setCenter(new Coordinates(0, 0));
	}
	
	/**
	 * Zwraca kolor klocka
	 * @return Kolor klocka
	 */
	public final Color getColor()
	{
		return color;
	}
	
	/**
	 * Zwraca zbiór współrzędnych
	 * @return zbiór punktów tworzących kolcek
	 */
	public final Set<Coordinates> getCoords()
	{
		return blocks;
	}
	
	/**
	 * Przesuwa klocek w lewo
	 */
	public void moveLeft()
	{
		center.setX(center.getX()-1);
	}
	
	/**
	 * Przesuwa klocek w prawo
	 */
	public void moveRight()
	{
		center.setX(center.getX()+1);
	}
	
	/**
	 * Przesuwa klocek w dół
	 */
	public void moveDown()
	{
		center.setY(center.getY()-1);
	}
	
	/**
	 * Obraca zgodnie z przyjętą strategią obrotów
	 */
	public void rotate()
	{
		HashSet<Coordinates> newCoords = new HashSet<Coordinates>();
		for (Coordinates block : blocks) {
			newCoords.add(rotationStrategy.rotate(block));
		}
		blocks = newCoords;
	}
	
	/**
	 * Zwraca obiekt klocka po wykonaniu obrotu
	 * @return Obiekt klocka po wykonaniu pojedynczego obrotu, nie zmienia współrzędnch
	 */
	public Shape getNextRotation()
	{
		Shape shape = new Shape(blocks, color, rotationStrategy);
		shape.setCenter(center);
		shape.rotate();
		return shape;
	}
	
	/**
	 * Ustawia strategię obrotów
	 * @param rotationStrategy Strategia obrotów
	 */
	public void setRotationStrategy(final RotationStrategy rotationStrategy)
	{
		this.rotationStrategy = rotationStrategy;
	}

	/**
	 * Ustawia nowe wspoółrzędne środka klocka
	 * @param center Nowe współrzędne środka klocka
	 */
	public void setCenter(final Coordinates center) 
	{
		this.center = center;
	}

	/**
	 * 
	 * @return Współrzędne środka klocka
	 */
	public final Coordinates getCenter() 
	{
		return center;
	}
	
	/**
	 * Zwraca wysokość klocka
	 * @return wysokość klocka
	 */
	public final int getHeight()
	{
		Set<Integer> yCoords = new HashSet<Integer>();
		for (Coordinates coords : blocks)
		{
			yCoords.add(coords.getY());
		}
		
		return Collections.max(yCoords) - Collections.min(yCoords) +1;
	}
	
	/**
	 * Zwraca szerokość klocka
	 * @return szerokość klocka
	 */
	public final int getWidth()
	{
		Set<Integer> xCoords = new HashSet<Integer>();
		for (Coordinates coords : blocks)
		{
			xCoords.add(coords.getX());
		}
		
		return Collections.max(xCoords) - Collections.min(xCoords) +1;
	}
	
	
	/**
	 * Sprawdza czy klocek może znaleźć się w nowym położeniu 
	 * @param board Obiekt planszy
	 * @return true jeśli występuje kolizja, false w przeciwnym wypadku
	 */
	public boolean collide(final TetrisBoard board, final Coordinates newCenter)
	{
		for (Coordinates block : blocks) 
		{
			if (board.isOccupied(new Coordinates(newCenter.getX()+block.getX(), newCenter.getY()+block.getY())))
				return false;
		}
		return true;
	}
	
	/**
	 * Zwraca obeikt klocka przeznaczony dla widoku
	 * @return obiekt klocka przeznaczony dla widoku
	 */
	public FakeShape getFake()
	{
		Set<Coordinates> fakeShape = new HashSet<Coordinates>();
		for (Coordinates coords : blocks) 
		{
			fakeShape.add(new Coordinates(coords.getX(), coords.getY()));
		}
		return new FakeShape(fakeShape, color);
	}
	
}

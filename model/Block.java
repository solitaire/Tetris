package pl.edu.pw.elka.www.proz.tetris.model;

import java.awt.Color;

/**
 * Klasa reprezentująca pojedynczy blok planszy
 */
public class Block
{

	/* Kolor bloku*/
	private Color color;
	
	public Block()
	{
		color = null;
	}
	
	/**
	 * Tworzy nowy blok o określonym kolorze
	 * @param color kolor bloku
	 */
	public Block(final Color color)
	{
		this.color = color;
	}

	/**
	 * 
	 * @return kolor bloku
	 */
	public final Color getColor()
	{
		return color;
	}
	
	/**
	 * 
	 * @param color nowy kolor
	 */
	public void setColor(final Color color)
	{
		this.color = color;
	}

}

package pl.edu.pw.elka.www.proz.tetris.model;

import java.awt.Color;

/**
 * Klasa reprezentująca pojedynczy blok planszy
 * 
 * @author Anna Stępień
 */
public class Block
{

	/* Kolor bloku*/
	private Color color;
	
	/**
	 * Tworzy nowy pusty blok
	 * 
	 */
	public Block()
	{
		color = null;
	}
	
	/**
	 * Tworzy nowy blok o określonym kolorze
	 * 
	 * @param color kolor bloku
	 */
	public Block(final Color color)
	{
		this.color = color;
	}

	/**
	 * Zwraca kolor bloku
	 * 
	 * @return kolor bloku
	 */
	public final Color getColor()
	{
		return color;
	}
	
	/**
	 * Ustawia nowy kolor bloku
	 * 
	 * @param color nowy kolor
	 */
	public void setColor(final Color color)
	{
		this.color = color;
	}

}

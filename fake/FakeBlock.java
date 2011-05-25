package pl.edu.pw.elka.www.proz.tetris.fake;

import java.awt.Color;

import pl.edu.pw.elka.www.proz.tetris.model.Coordinates;

/**
 * Klasa reprezentująca pojedyczny blok planszy
 * 
 * @author Anna Stępień
 */
public class FakeBlock 
{
	
	
	/** Współrzędne bloku */
	private Coordinates positon;
	/** Kolor bloku */
	private Color color;
	
	/**
	 * Tworzy nowy obiekt bloczka przeznaczony dla widoku
	 * 
	 * @param positon Położenie bloczka
	 * @param color Kolor bloczka
	 */
	public FakeBlock(final Coordinates positon, final Color color)
	{
		this.positon = positon;
		this.color = color;
	}
	
	/**
	 * Zwraca położenie bloczka
	 * 
	 * @return położenie
	 */
	public final Coordinates getPosition()
	{
		return positon;
	}
	
	/**
	 * Zwraca kolor bloczka
	 * 
	 * @return kolor 
	 */
	public final Color getColor()
	{
		return color;
	}
	
}

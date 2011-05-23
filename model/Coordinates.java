package pl.edu.pw.elka.www.proz.tetris.model;

/**
 * Klasa reprezentująca współrzędne punktu
 *
 */
public class Coordinates 
{
	
	/** Współrzędna x */
	private int x;
	/** Współrzędna y */
	private int y;
	
	/**
	 * Tworzy nowy obiekt współrzędnych
	 * @param x współrzędna x
	 * @param y współrzędna y
	 */
	public Coordinates(final int x, final int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @return współrzędna x
	 */
	public final int getX()
	{
		return x;
	}
	
	/**
	 * 
	 * @return wspólrzędna y
	 */
	public final int getY()
	{
		return y;
	}
	
	/**
	 * 
	 * @param x nowa współrzędna x
	 */
	public void setX(final int x)
	{
		this.x = x;
	}
	
	/**
	 * 
	 * @param y nowa współrzędna y
	 */
	public void setY(final int y)
	{
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		Coordinates other = (Coordinates) obj;
		if (other.getX() == this.x && other.getY() == this.y)
			return true;
		else
			return false;
	}
	
	@Override
	public int hashCode() 
	{
		return (x*13) >> y;
	}

}

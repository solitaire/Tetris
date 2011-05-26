package tetris.model;

/**
 * Klasa reprezentująca współrzędne punktu
 * 
 * @author Anna Stępień
 */
public class Coordinates 
{
	
	/** Współrzędna x */
	private int x;
	/** Współrzędna y */
	private int y;
	
	/**
	 * Tworzy nowy obiekt współrzędnych
	 * 
	 * @param x współrzędna x
	 * @param y współrzędna y
	 */
	public Coordinates(final int x, final int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Zwraca współrzędną x punktu
	 * 
	 * @return współrzędna x
	 */
	public final int getX()
	{
		return x;
	}
	
	/**
	 * Zwraca współrzędną y punktu
	 * 
	 * @return wspólrzędna y
	 */
	public final int getY()
	{
		return y;
	}
	
	/**
	 * Ustwia nową współrzędną x 
	 * 
	 * @param x nowa współrzędna x
	 */
	public void setX(final int x)
	{
		this.x = x;
	}
	
	/**
	 * Ustawia nową współrzędną y
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
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (obj.getClass() != getClass())
			return false;
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

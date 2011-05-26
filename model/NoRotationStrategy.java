package tetris.model;

/**
 * Pozostawia współrzędne bez zmian
 * 
 * @author Anna Stępień
 */
public class NoRotationStrategy implements RotationStrategy 
{

	@Override
	public Coordinates rotate(final Coordinates coords) 
	{
		return new Coordinates(coords.getX(), coords.getY());
	}

}

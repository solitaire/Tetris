package pl.edu.pw.elka.www.proz.tetris.model;

/**
 * Pozostawia współrzędne bez zmian
 *
 */
public class NoRotationStrategy implements RotationStrategy 
{

	@Override
	public Coordinates rotate(final Coordinates coords) 
	{
		return new Coordinates(coords.getX(), coords.getY());
	}

}

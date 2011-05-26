package tetris.model;

/**
 * Interfejs obrotu współrzędnych
 * 
 * @author Anna Stępień
 */
interface RotationStrategy 
{
	public Coordinates rotate(final Coordinates coords);
}

package tetris.model;

/**
 * Klasa reprezentująca obrót punktu przeciwnie do ruchu wskazówek zegara
 * 
 * @author Anna Stępień
 */
class CounterClockwiseRotationStrategy implements RotationStrategy 
{

	@Override
	public Coordinates rotate(final Coordinates coords) 
	{
		return new Coordinates(-coords.getY(), coords.getX());
	}

}

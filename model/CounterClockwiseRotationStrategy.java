package pl.edu.pw.elka.www.proz.tetris.model;

/**
 * Klasa reprezentująca obrót punktu przeciwnie do ruchu wskazówek zegara
 *
 */
class CounterClockwiseRotationStrategy implements RotationStrategy 
{

	@Override
	public Coordinates rotate(final Coordinates coords) 
	{
		return new Coordinates(-coords.getY(), coords.getX());
	}

}

package pl.edu.pw.elka.www.proz.tetris.model;

/**
 * Klasa reprezentując obrót zgodny z ruchem wskazówek zegara
 * 
 * @author Anna Stępień
 */
class ClockwiseRotationStrategy implements RotationStrategy 
{

	@Override
	public Coordinates rotate(final Coordinates coords) 
	{
		
		return new Coordinates(coords.getX(), coords.getY());
		
	}

}

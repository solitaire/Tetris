package pl.edu.pw.elka.www.proz.tetris.model;

/**
 * Interfejs obrotu współrzędnych
 */
interface RotationStrategy 
{
	public Coordinates rotate(final Coordinates coords);
}

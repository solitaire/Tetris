package pl.edu.pw.elka.www.proz.tetris.model;

/**
 * Interfejs fabryki konstruującej obiekty typu Shape
 */
interface Factory 
{
	
	/**
	 * Konstruuje obiekt klocka o określonych cechach
	 * @return klocek
	 */
	public Shape buildShape();

}

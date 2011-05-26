package tetris.model;

/**
 * Interfejs fabryki konstruującej obiekty typu Shape
 * 
 * @author Anna Stępień
 */
interface Factory 
{
	
	/**
	 * Konstruuje obiekt klocka o określonych cechach
	 * 
	 * @return klocek
	 */
	public Shape buildShape();

}

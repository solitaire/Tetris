package tetris.model;

import java.util.Random;

/**
 * Tworzy losowy obiekt klocka
 * 
 * @author Anna Stępień
 * 
 */
class RandomShapeFactory 
{
	
	enum ShapeTypes
	{
		/** Klocek typu IShape */
		I_SHAPE
		{
			Factory getFactory() 
			{ 
				return new IShapeFactory();
			}
		},
		
		/** Klocek typu OShape */
		O_SHAPE
		{ 
			Factory getFactory() 
			{ 
				return new OShapeFactory(); 
			}
		},
		
		/** Klocek typu TShape */
		T_SHAPE
		{ 
			Factory getFactory() 
			{ 
				return new TShapeFactory(); 
			}
		},
		
		/** Klocek typu ZShape */
		Z_SHAPE
		{ 
			Factory getFactory() 
			{ 
				return new ZShapeFactory();
			}
		},
		
		/** Klocek typu SShape */
		S_SHAPE
		{ 
			Factory getFactory() 
			{ 
				return new SShapeFactory();
			}
		},
		
		/** Klocek typu JShape */
		J_SHAPE
		{ 
			Factory getFactory() 
			{ 
				return new JShapeFactory();
			}
		},
		
		/** Klocek typu LShape */
		L_SHAPE
		{ 
			Factory getFactory() 
			{ 
				return new LShapeFactory(); 
			}
		};
		
		abstract Factory getFactory();
	}
	
	/**
	 * Zwraca losowy obiekt klocka
	 * 
	 * @return losowy obiekt klocka
	 */
	public Shape getRandomShape()
	{
		return ShapeTypes.values()[generate()].getFactory().buildShape();
	}
	
	private final int generate()
	{
		return new Random().nextInt(ShapeTypes.values().length);
	}

}

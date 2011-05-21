package pl.edu.pw.elka.www.proz.tetris.model;

import java.util.Random;

/**
 * Tworzy losowy obiekt klocka
 *
 */
class RandomShapeFactory 
{
	
	enum ShapeTypes{
		I_SHAPE{ Factory getFactory() { return new IShapeFactory(); }},
		O_SHAPE{ Factory getFactory() { return new OShapeFactory(); }},
		T_SHAPE{ Factory getFactory() { return new TShapeFactory(); }},
		Z_SHAPE{ Factory getFactory() { return new ZShapeFactory(); }},
		S_SHAPE{ Factory getFactory() { return new SShapeFactory(); }},
		J_SHAPE{ Factory getFactory() { return new JShapeFactory(); }},
		L_SHAPE{ Factory getFactory() { return new LShapeFactory(); }};
		
		abstract Factory getFactory();
	}
	
	/**
	 * Zwraca losowy obiekt klocka
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

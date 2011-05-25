package pl.edu.pw.elka.www.proz.tetris.model;

import java.util.HashSet;
import java.util.Set;

import pl.edu.pw.elka.www.proz.tetris.config.ShapeConfig;

/**
 * Fabryka klocka typu LShape
 * 
 * @author Anna Stępień
 *
 */
class LShapeFactory implements Factory
{

	@Override
	public Shape buildShape() 
	{
		Set<Coordinates> blocks = new HashSet<Coordinates>();
		
		blocks.add(new Coordinates(-1, 0));
		blocks.add(new Coordinates(-1, -1));
		blocks.add(new Coordinates(0, 0));
		blocks.add(new Coordinates(1, 0));
		
		return new Shape(blocks, ShapeConfig.LSHAPE_COLOR, new CounterClockwiseRotationStrategy());
	}

}

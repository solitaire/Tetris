package tetris.model;

import java.util.HashSet;
import java.util.Set;

import tetris.config.ShapeConfig;

/**
 * Fabryka klocka typu IShape
 * 
 * @author Anna Stępień
 *
 */
class IShapeFactory implements Factory 
{

	@Override
	public Shape buildShape() 
	{
		Set<Coordinates> blocks= new HashSet<Coordinates>();
		
		blocks.add(new Coordinates(-2, 0));
		blocks.add(new Coordinates(-1, 0));
		blocks.add(new Coordinates(0, 0));
		blocks.add(new Coordinates(1, 0));
		
		return new Shape(blocks, ShapeConfig.ISHAPE_COLOR, new CounterClockwiseRotationStrategy());
	}

}

package tetris.model;

import java.util.HashSet;
import java.util.Set;

import tetris.config.ShapeConfig;

/**
 * Fabryka klocka typu ZShape
 * 
 * @author Anna Stępień
 *
 */
class ZShapeFactory implements Factory 
{

	@Override
	public Shape buildShape() 
	{
		Set<Coordinates> blocks = new HashSet<Coordinates>();
		
		blocks.add(new Coordinates(-1, 0));
		blocks.add(new Coordinates(0, 0));
		blocks.add(new Coordinates(0, -1));
		blocks.add(new Coordinates(1, -1));
		
		return new Shape(blocks, ShapeConfig.ZSHAPE_COLOR, new CounterClockwiseRotationStrategy());
	}
}

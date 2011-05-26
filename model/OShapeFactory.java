package tetris.model;

import java.util.HashSet;
import java.util.Set;

import tetris.config.ShapeConfig;

/**
 * Fabryka klocka typu OShape
 * 
 * @author Anna Stępień
 *
 */
class OShapeFactory implements Factory 
{
	

	@Override
	public Shape buildShape() 
	{
		Set<Coordinates> blocks = new HashSet<Coordinates>();
		
		blocks.add(new Coordinates(0, 0));
		blocks.add(new Coordinates(0, -1));
		blocks.add(new Coordinates(-1, -1));
		blocks.add(new Coordinates(-1, 0));
		
		return new Shape(blocks, ShapeConfig.OSHAPE_COLOR, new NoRotationStrategy());
	}

}

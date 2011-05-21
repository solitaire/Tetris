package pl.edu.pw.elka.www.proz.tetris.model;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

class JShapeFactory implements Factory 
{

	@Override
	public Shape buildShape() 
	{
		Set<Coordinates> blocks = new HashSet<Coordinates>();
		
		blocks.add(new Coordinates(-1, 0));
		blocks.add(new Coordinates(0, 0));
		blocks.add(new Coordinates(1, 0));
		blocks.add(new Coordinates(1, -1));
		
		return new Shape(blocks, Color.YELLOW, new CounterClockwiseRotationStrategy());
	}

}

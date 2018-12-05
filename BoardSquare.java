import java.awt.Color;

import acm.graphics.GObject;

public class BoardSquare extends SquareObject {

	BoardSquare(BoardLocation location) {
		super(location, 6);
	}
	
	@Override
	Color getColor() {
		
		if ((location.x + location.y) % 2 == 0)
			return Color.LIGHT_GRAY;		
		return Color.GRAY;
	}
}

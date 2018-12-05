import java.awt.Color;
import java.util.ArrayList;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class PirateShip extends LongRangePiece {

	GRect rect;
	
	public PirateShip(BoardLocation location, Color color) {
		super(location, color);
		int width = PirateChess.SQUARE_WIDTH;
		rect = new GRect(
				location.x*width+10, location.y*width+20,
				width-2*10, width-2*20);
		rect.setColor(getColor());
		rect.setFilled(true);
	}
	
	protected void setupMoveDirections() {
		moveDirections = new ArrayList<BoardLocation>();
		moveDirections.add(new BoardLocation(1,0));
		moveDirections.add(new BoardLocation(-1,0));
		moveDirections.add(new BoardLocation(0,1));
		moveDirections.add(new BoardLocation(0,-1));
	}

	protected boolean canCapture() {
		return true;
	}
	
	@Override
	public GObject getGObject() {
		return rect;
	}
	
	@Override
	protected boolean canBeCaptured() {
		return true;
	}
	
}

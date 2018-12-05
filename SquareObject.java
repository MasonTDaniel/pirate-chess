import java.awt.Color;
import acm.graphics.GObject;
import acm.graphics.GRect;


public abstract class SquareObject implements DrawableObject {
	
	BoardLocation location;
	GRect square;
	
	abstract Color getColor();
	
	SquareObject(BoardLocation location, int padding) {
		this.location = location;
		
		int width = PirateChess.SQUARE_WIDTH;
		square = new GRect(
				location.x*width+padding, location.y*width+padding,
				width-2*padding, width-2*padding);
		square.setColor(getColor());
		square.setFilled(true);
	}
	
	@Override
	public GObject getGObject() {
		return square;
	}
	@Override
	public boolean sendToFront() {
		return false;
	}
	@Override
	public boolean sendToBack() {
		return false;
	}	
}

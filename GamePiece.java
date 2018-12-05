import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.GObject;

public abstract class GamePiece implements DrawableObject {

	protected BoardLocation location;
	
	protected Color color;
	
	// returns a list of possible locations to move the piece
	// override this function to ensure that you can move
	// your piece on the board
	public ArrayList<BoardLocation> getCandidateLocations(GamePiece[][] gamePieces) {
		return new ArrayList<BoardLocation>();
	}
	
	// override this function to return true if the piece
	// can be captured
	protected boolean canBeCaptured() {
		return false;
	}
	
	// override this function to return false if
	// the piece cannot capture other pieces
	protected boolean canCapture() {
		return true;
	}
	
	GamePiece(BoardLocation location, Color color) {
		this.location = location;
		this.color = color;
	}
	
	// move the GObject for this piece (i.e., the object that is
	// actually displayed by the graphics) to the correct new location
	// and update the location that the piece is storing
	public void moveTo(BoardLocation newLocation) {
		GObject gobject = getGObject();
		int di = newLocation.x - location.x;
		int dj = newLocation.y - location.y;
		gobject.move(di*PirateChess.SQUARE_WIDTH, 
				dj*PirateChess.SQUARE_WIDTH);		
		
		location.x = newLocation.x;
		location.y = newLocation.y;
	}
	
	Color getColor() {
		return color;
	}

	// game pieces are always sent to the front of the graphics display
	// (above the board squares and background highlighting)
	@Override
	public boolean sendToFront() {
		return true;
	}

	@Override
	public boolean sendToBack() {
		return false;
	}
}

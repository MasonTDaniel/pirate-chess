import java.awt.Color;
import java.util.ArrayList;
import acm.graphics.GObject;


// LongRangePieces are pieces which can move an arbitrary number of
// squares in one or more directions until they are blocked by
// another piece
public abstract class LongRangePiece extends GamePiece {

	// the "move directions" is just a list of offset directions
	// in which the piece can move
	protected ArrayList<BoardLocation> moveDirections;

	// setupMoveDirections needs to create and fill the moveDirections
	// ArrayList above
	protected abstract void setupMoveDirections();
	
	public LongRangePiece(BoardLocation location, Color color) {
		super(location, color);
		setupMoveDirections();
	}
	
	@Override
	public ArrayList<BoardLocation> getCandidateLocations(GamePiece[][] gamePieces) {
		ArrayList<BoardLocation> locations = new ArrayList<BoardLocation>();
		for (BoardLocation moveDirection : moveDirections) {
			BoardLocation testLoc = 
					new BoardLocation(location.x + moveDirection.x, 
							location.y + moveDirection.y);
			while (testLoc.x >= 0 && testLoc.x < PirateChess.N_SQUARES &&
					testLoc.y >= 0 && testLoc.y < PirateChess.N_SQUARES) {
				GamePiece blockingPiece = gamePieces[testLoc.x][testLoc.y];
				if (blockingPiece == null) {
					locations.add(new BoardLocation(testLoc.x, testLoc.y));
				} else {
					if (canCapture() && 
						blockingPiece.canBeCaptured() && 
						blockingPiece.getColor() != getColor())
						locations.add(new BoardLocation(testLoc.x, testLoc.y));
					break;
				}
				testLoc.x = testLoc.x + moveDirection.x;
				testLoc.y = testLoc.y + moveDirection.y;
			}
		}
		return locations;
	}
	
}

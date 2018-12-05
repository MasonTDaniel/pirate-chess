import java.awt.Color;
import java.util.ArrayList;


public class PirateChessGame {

	private PirateChess program;
	
	// objects displayed
	private BoardSquare[][] boardSquares = null;
	private GamePiece[][] gamePieces = null;
	private ArrayList<BoardLocation> candidateLocations = null;
	private SelectSquare selectSquare = null;
	
	// game status
	Color currentPlayer = Color.YELLOW;
	private GamePiece pieceSelected = null;	
	private boolean gameOver = false;
	
	public PirateChessGame(PirateChess program) {
		this.program = program;
	}
	
	public void init() {
		initBoard();
		initPieces();
		program.setConsoleOutput("Pirate Chess: " + getCurrentPlayerName() + " Plays First.");
	}
	
	// initialize the board squares
	public void initBoard() {
		boardSquares = new BoardSquare[PirateChess.N_SQUARES][PirateChess.N_SQUARES];
		for (int x=0; x<PirateChess.N_SQUARES; x++) {
			for (int y=0; y<PirateChess.N_SQUARES; y++) {
				boardSquares[x][y] = new BoardSquare(new BoardLocation(x,y));
				program.addObject(boardSquares[x][y]);
			}
		}
		selectSquare = null;
		candidateLocations = null;
		
		currentPlayer = Color.YELLOW;
	}
	
	// initialize the pieces in their starting squares
	public void initPieces() {
		gamePieces = new GamePiece[PirateChess.N_SQUARES][PirateChess.N_SQUARES];
		for (int x=0; x<PirateChess.N_SQUARES; x++) {
			for (int y=0; y<PirateChess.N_SQUARES; y++) {
				gamePieces[x][y] = null;
			}
		}

		// todo: add the other game pieces to the board here
		//       once you have implemented the different classes
		
		gamePieces[2][8] = new PirateShip(new BoardLocation(2, 8), Color.YELLOW);

		gamePieces[2][0] = new PirateShip(new BoardLocation(2, 0), Color.BLACK);
		
		for (int x=0; x<PirateChess.N_SQUARES; x++) {
			for (int y=0; y<PirateChess.N_SQUARES; y++) {
				if (gamePieces[x][y] != null)
					program.addObject(gamePieces[x][y]);
			}
		}		
	}

	// given the color of a piece, can it be moved by the current player?
	private boolean canMove(Color pieceColor) {
		if (pieceColor == Color.YELLOW && currentPlayer == Color.BLACK)
			return false;
		if (pieceColor == Color.BLACK && currentPlayer == Color.YELLOW)
			return false;
		return true;
	}

	// act based on a user clicking a square...
	//   - if the game is over, do nothing
	//   - if no piece is selected and the current player
	//        selects a valid piece to move, highlight the piece
	//        and the candidate squares to select
	//   - if a piece is already selected and the player clicked
	//        a valid move location, move the piece, capturing
	//        an opposing piece if possible
	public void squareClicked(BoardLocation location) {
		if (gameOver)
			return;
		if (candidateLocations == null) {
			// player is selecting a piece
			GamePiece piece = gamePieces[location.x][location.y];
			if (piece != null && canMove(piece.getColor())) {
				candidateLocations = piece.getCandidateLocations(gamePieces);
				if (candidateLocations.size() > 0) {
					// a valid piece was selected... update the game
					pieceSelected = piece;
					
					// draw the select square
					selectSquare = new SelectSquare(location);
					program.addObject(selectSquare);

					// todo: also draw the squares highlighting
					//       the possible move locations
				} else {
					candidateLocations = null;
				}
			}
		} else {
			// player is attempting to move a piece
			// check if a valid square was clicked
			boolean validLocation = false;
			for (BoardLocation candidateLoc : candidateLocations) {
				if (candidateLoc.equals(location)) 
					validLocation = true;
			}
			if (validLocation)
			{
				// clear the selection squares
				program.removeObject(selectSquare);
				// todo: clear the selection squares
				
				// capture existing piece
				GamePiece toCapture = gamePieces[location.x][location.y];
				if (toCapture != null) {
					program.removeObject(toCapture);
					
					// todo: check if the Pirate was captured and if so
					//       set gameOver to true and print the Game Over
					//       message

				}
				
				// move the piece to this location
				gamePieces[pieceSelected.location.x][pieceSelected.location.y] = null;
				pieceSelected.moveTo(location);
				gamePieces[location.x][location.y] = pieceSelected;

				selectSquare = null;
				candidateLocations = null;
				pieceSelected = null;

				// check if someone has won...
				
				// other player moves next
				if (currentPlayer == Color.YELLOW)
					currentPlayer = Color.BLACK;
				else
					currentPlayer = Color.YELLOW;	
				if (!gameOver)
					program.setConsoleOutput("Pirate Chess: " + getCurrentPlayerName() + " Plays Next.");
			}
		}
	}
	
	private String getCurrentPlayerName() {
		if (currentPlayer == Color.BLACK)
			return "Black";
		return "Gold";
	}
}

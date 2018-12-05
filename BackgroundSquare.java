public abstract class BackgroundSquare extends SquareObject {

	public BackgroundSquare(BoardLocation location) {
		super(location,0);
	}
	
	public boolean sendToBack() {
		return true;
	}
}

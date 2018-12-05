import java.awt.Color;

public class SelectSquare extends BackgroundSquare {

	public SelectSquare(BoardLocation location) {
		super(location);
	}

	@Override
	Color getColor() {
		return Color.RED;
	}

}

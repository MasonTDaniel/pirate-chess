public class BoardLocation {

	public int x;
	public int y;
	
	BoardLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(BoardLocation loc){
		return (x == loc.x && y == loc.y);
	}
	
}

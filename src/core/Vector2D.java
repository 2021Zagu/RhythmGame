package core;

public class Vector2D {
	public int x;
	public int y;

	public Vector2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2D add(Vector2D v) {
		return new Vector2D(this.x + v.x, this.y + v.y);
	}
}

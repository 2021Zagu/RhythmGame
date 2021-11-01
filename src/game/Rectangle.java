package game;

import core.GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends GameObject {
	public int width;
	public int height;
	public Color color;
	
	public Rectangle(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public void init() {
		this.addComponent(new PlayerMover(this));
	}
	
	public void render(GraphicsContext gc) {
        gc.setFill(this.color);
        gc.fillRect(this.position.x, this.position.y, this.width, this.height);
	}
}

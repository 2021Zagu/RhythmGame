package core;

import java.util.HashSet;
import java.util.Vector;

import javafx.scene.canvas.GraphicsContext;

public abstract class GameObject {
	public Vector2D position = new Vector2D(0, 0);
	public HashSet<GameComponent> components = new HashSet<>();
	private Scene scene;
	
	public void render(GraphicsContext gc) {};
	public void init() {};
	
	public void addComponent(GameComponent component) {
		this.components.add(component);
	}
	public <T> T getComponent(Class<T> Component) {
		for(GameComponent component: this.components) {
			if(Component.isInstance(component)) {
				return (T) component;
			}
		}
		return null;
	}
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	public <T> T getSystem(Class<T> System) {
		return this.scene.getGameSystem(System);
	}
}
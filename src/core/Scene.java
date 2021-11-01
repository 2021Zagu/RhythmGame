package core;

import java.util.HashSet;
import java.util.function.Consumer;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Scene {
	private GraphicsContext gc;
	private Canvas canvas;
	private HashSet<GameObject> gameObjects;
	private HashSet<GameSystem> gameSystems;
	private AnimationTimer animationTimer;
	
	boolean running;
	
	public Scene(GraphicsContext gc) {
		this.gameObjects = new HashSet<>();
		this.gameSystems = new HashSet<>();
		this.running = false;
		this.gc = gc;
		this.canvas = gc.getCanvas();
	}
	public void start() {
		this.running = true;
		
		Scene self = this;
		this.animationTimer = 
	        new AnimationTimer() {
	            public void handle(long currentNanoTime)
	            {
	            	self.frame();
	            }
	        };
	    
	    for(GameSystem gameSystem: this.gameSystems)
	    	gameSystem.start();
	    
	    this.animationTimer.start();
	}
	public void stop() {
		this.animationTimer.stop();
		for(GameObject gameObject: this.gameObjects)
			gameObject.setScene(null);
	    for(GameSystem gameSystem: this.gameSystems)
	    	gameSystem.stop();
		this.running = false;
	}
	
	public void addGameObject(GameObject gameObject) {
		gameObject.setScene(this);
		gameObject.init();
		this.gameObjects.add(gameObject);
	}
	public void removeGameObject(GameObject gameObject) {
		gameObject.setScene(null);
		this.gameObjects.remove(gameObject);
	}
	public void addGameSystem(GameSystem gameSystem) {
		this.gameSystems.add(gameSystem);
	}
	public void removeGameSystem(GameSystem gameSystem) {
		this.gameSystems.remove(gameSystem);
	}
	public <T> T getGameSystem(Class<T> System) {
		for(GameSystem gameSystem: this.gameSystems) {
			if(System.isInstance(gameSystem)) {
				return (T) gameSystem;
			}
		}
		
		return null;
	}
	
	private void frame() {
		this.update();
		this.afterUpdate();
		this.render();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void update() {
	    for(GameSystem gameSystem : this.gameSystems)
	    	gameSystem.update();
		for(GameObject gameObject: this.gameObjects) {
			for(GameComponent component: gameObject.components) {
				component.update();
			}
		}
	}
	private void afterUpdate() {
	    for(GameSystem gameSystem : this.gameSystems)
	    	gameSystem.afterUpdate();
		for(GameObject gameObject: this.gameObjects) {
			for(GameComponent component: gameObject.components) {
					component.afterUpdate();
			}
		}
	}
	private void render() {
		this.gc.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
		for(GameObject gameObject: this.gameObjects) {
			// this.gc.translate(gameObject.position.x, gameObject.position.y);
			gameObject.render(gc);
			// this.gc.translate(-gameObject.position.x, -gameObject.position.y);
		}
	}
}

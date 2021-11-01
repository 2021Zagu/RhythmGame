package core;

public abstract class GameComponent {
	final public GameObject gameObject;
	
	public GameComponent(GameObject gameObject) {
		this.gameObject = gameObject;
	}
	
	public void update() {};
	public void afterUpdate() {};
}

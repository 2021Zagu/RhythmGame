package game;

import java.util.HashSet;

import core.GameComponent;
import core.GameObject;
import core.gamesystem.KeyboardInput;
import core.gamesystem.Timer;
import javafx.scene.input.KeyCode;

public class PlayerMover extends GameComponent {
	private KeyboardInput keyboardInput;
	private Timer timer;

	public PlayerMover(GameObject gameObject) {
		super(gameObject);

		this.keyboardInput = this.gameObject.getSystem(KeyboardInput.class);
		this.timer = this.gameObject.getSystem(Timer.class);
	}
	
	public void update() {
		HashSet<KeyCode> pressedKeys = this.keyboardInput.pressedKeys;
		if(pressedKeys.contains(KeyCode.W)) {
			this.gameObject.position.y -= 500 * this.timer.getDeltaTime();
		}
		if(pressedKeys.contains(KeyCode.S)) {
			this.gameObject.position.y += 500 * this.timer.getDeltaTime();
		}
		if(pressedKeys.contains(KeyCode.A)) {
			this.gameObject.position.x -= 500 * this.timer.getDeltaTime();
		}
		if(pressedKeys.contains(KeyCode.D)) {
			this.gameObject.position.x += 500 * this.timer.getDeltaTime();
		}
	}
}

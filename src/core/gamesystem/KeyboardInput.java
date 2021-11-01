package core.gamesystem;

import java.util.HashSet;

import core.GameSystem;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardInput implements GameSystem {
	private Scene scene;

	private EventHandler<KeyEvent> keyPressedHandler;
	private EventHandler<KeyEvent> keyReleasedHandler;
	
	public HashSet<KeyCode> pressedKeys;
	
	public KeyboardInput(Scene scene) {
		this.scene = scene;
		this.pressedKeys = new HashSet<>();
		
		this.keyPressedHandler = 
			new EventHandler<KeyEvent>() {
				public void handle(KeyEvent e)
				{
					KeyCode code = e.getCode();
					pressedKeys.add(code);
				}
			};
		this.keyReleasedHandler = 
			new EventHandler<KeyEvent>() {
				public void handle(KeyEvent e)
				{
					KeyCode code = e.getCode();
					pressedKeys.remove(code);
				}
			};
	}
	
	public void start() {
		this.scene.setOnKeyPressed(this.keyPressedHandler);
		this.scene.setOnKeyReleased(this.keyReleasedHandler);
	}
	
	public void stop() {
		this.scene.removeEventHandler(KeyEvent.KEY_PRESSED, this.keyPressedHandler);
		this.scene.removeEventHandler(KeyEvent.KEY_RELEASED, this.keyReleasedHandler);
	}
}

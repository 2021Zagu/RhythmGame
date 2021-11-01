package core;

public interface GameSystem {
	default void start() {};
	default void stop() {};
	default void update() {};
	default void afterUpdate() {};
}

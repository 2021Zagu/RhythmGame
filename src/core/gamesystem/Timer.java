package core.gamesystem;

import java.util.Date;

import core.GameSystem;

public class Timer implements GameSystem {
	private long lastTime;
	private double deltaTime;
	public void start() {
		this.lastTime = this.getCurrentTime();
	}
	public void update() {
		long currentTime = this.getCurrentTime();
		this.deltaTime = ((double)currentTime -  this.lastTime) / (1000.0);
		this.lastTime = currentTime;
	}
	public long getCurrentTime() {
		return (new Date()).getTime();
	}
	public double getDeltaTime() {
		return this.deltaTime;
	}
}

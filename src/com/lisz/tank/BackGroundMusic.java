package com.lisz.tank;

public class BackGroundMusic extends Audio {
	public BackGroundMusic(String fileName) {
		super(fileName);
	}

	@Override
	public void run() {
		loop();
	}
}

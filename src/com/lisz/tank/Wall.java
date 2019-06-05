package com.lisz.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends GameObject {

	public Wall(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		live = true; // Important!!
	}
	
	@Override
	public void move() {}

	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, height);
		g.setColor(c);
	}

	@Override
	public void fire() {}

}

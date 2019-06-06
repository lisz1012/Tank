package com.lisz.tank;

import java.awt.Color;
import java.awt.Graphics;

public class BloodBanner extends GameObject {
	private Tank tank;

	public BloodBanner(Tank tank) {
		super();
		this.tank = tank;
	}

	@Override
	public void move() {}

	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillRect(tank.getX(), tank.getY() - 25, tank.getWidth(), 15);
		g.setColor(c);
	}

	@Override
	public void fire() {}

}

package com.lisz.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Explosion extends GameObject {
	private int state = 0;
	public Explosion(int x, int y) {
		this.x = x;
		this.y = y;
		live = true;
	}
	@Override
	public void move() {}

	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.drawImage(ResourceMgr.EXPLOSION_IMGS[state++], x, y, null);
		g.setColor(c);
		if (state == ResourceMgr.EXPLOSION_IMGS.length) {
			live = false;
		}
	}

	@Override
	public void fire() {}

}

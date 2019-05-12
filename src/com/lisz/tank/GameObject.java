package com.lisz.tank;

import java.awt.Graphics;

public interface GameObject {
	void move();
	void setDir(Dir dir);
	public int getX();
	public int getY();
	void paint(Graphics g);
}

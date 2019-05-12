package com.lisz.tank;

import java.awt.Graphics;

public interface GameObject {
	void move();
	Dir getDir();
	void setDir(Dir dir);
	public int getX();
	public int getY();
	void paint(Graphics g);
	boolean isMoving();
	void setMoving(boolean moving);
	void fire();
}

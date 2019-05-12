package com.lisz.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet implements GameObject {
	private static final int SPEED = 15;
	private static final int WIDTH = 5;
	private static final int HEIGHT = 5;
	
	private Dir dir;
	private int x;
	private int y;
	private boolean moving = true;
	private boolean live = true;
	
	public Bullet(Dir dir, int x, int y) {
		super();
		this.dir = dir;
		this.x = x;
		this.y = y;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void move() {
		if (!moving) return;
		switch (dir) {
		case DOWN: y += SPEED; break;
		case UP: y -= SPEED; break;
		case LEFT: x -= SPEED; break;
		case RIGHT: x += SPEED; break;
		case LEFT_UP: x -= SPEED; y -= SPEED; break;
		case RIGHT_UP: x += SPEED; y -= SPEED; break;
		case RIGHT_DOWN: x += SPEED; y += SPEED; break;
		case LEFT_DOWN: x -= SPEED; y += SPEED; break;
		default:break;
		}
	}

	@Override
	public Dir getDir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDir(Dir dir) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		move();
	}

	@Override
	public boolean isMoving() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setMoving(boolean moving) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub
		
	}

}

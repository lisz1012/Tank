package com.lisz.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends GameObject {
	private static final int SPEED = 15;
	private static final int WIDTH = 5;
	private static final int HEIGHT = 5;
	
	public Bullet(Dir dir, int x, int y, TankFrame tf, boolean good) {
		super();
		this.dir = dir;
		this.x = x;
		this.y = y;
		this.tf = tf;
		this.good = good;
		live = true;
		moving = true;
		width = WIDTH;
		height = HEIGHT;
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
		if (outOfBound(tf)) {
			live = false;
		}
	}

	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, width, height);
		g.setColor(c);
		move();
	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub
		
	}

}

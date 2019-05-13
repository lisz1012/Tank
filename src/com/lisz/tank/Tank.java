package com.lisz.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank extends GameObject {
	private static final int WIDTH = 50;
	private static final int HEIGHT = 50;
	private static final int SPEED = 10;
	
	public Tank (int x, int y, Dir dir, TankFrame tf, boolean good) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		live = true;
		this.good = good;
		width = WIDTH;
		height = HEIGHT;
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
	public void setDir(Dir dir) {
		this.dir = dir;
	}
	
	@Override
	public Dir getDir() {
		return dir;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	@Override
	public boolean isMoving() {
		return moving;
	}

	@Override
	public void setMoving(boolean moving) {
		if (!moving) {
			System.out.println("Set moving to false!");
		}
		this.moving = moving;
	}

	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		if (good) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.BLUE);
		}
		g.fillRect(x, y, width, height); // TODO change it when using image
		g.setColor(c);
		move();
	}

	@Override
	public void fire() {
		tf.gameObjects.add(new Bullet(dir, x + 25, y + 25, tf, good)); // TODO change it when using image
		System.out.println("DIR: " + dir);
		System.out.println("FIRE!");
	}

}
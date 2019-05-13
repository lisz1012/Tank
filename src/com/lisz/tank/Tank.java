package com.lisz.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank extends GameObject {
	private int x = 200;
	private int y = 200;
	private Dir dir = Dir.UP;
	private TankFrame tf;
	private boolean moving = false;
	private static final int SPEED = 10;
	

	//public Tank() {}
	
	public Tank (int x, int y, Dir dir, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		live = true;
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

	@Override
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public int getX() {
		return x;
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
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 50, 50);
		g.setColor(c);
		move();
	}

	@Override
	public void fire() {
		tf.gameObjects.add(new Bullet(dir, x, y, tf));
		System.out.println("DIR: " + dir);
		System.out.println("FIRE!");
	}

}

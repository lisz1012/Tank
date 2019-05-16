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
		origX = x;
		origY = y;
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
			x = origX;
			y = origY;
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
		switch (dir) {
		case LEFT: 		 g.drawImage(ResourceMgr.TANK_L, x, y, null);	break;
		case RIGHT: 	 g.drawImage(ResourceMgr.TANK_R, x, y, null);	break;
		case UP: 		 g.drawImage(ResourceMgr.TANK_U, x, y, null);	break;
		case DOWN:  	 g.drawImage(ResourceMgr.TANK_D, x, y, null);	break;
		case LEFT_UP: 	 g.drawImage(ResourceMgr.TANK_LU, x, y, null);  break;
		case RIGHT_UP: 	 g.drawImage(ResourceMgr.TANK_RU, x, y, null);	break;
		case LEFT_DOWN:  g.drawImage(ResourceMgr.TANK_LD, x, y, null);	break;
		case RIGHT_DOWN: g.drawImage(ResourceMgr.TANK_RD, x, y, null);	break;
		default:
			break;
		}
		move();
	}

	@Override
	public void fire() {
		tf.gameObjects.add(new Bullet(dir, x + 25, y + 25, tf, good)); // TODO change it when using image
		System.out.println("DIR: " + dir);
		System.out.println("FIRE!");
	}

}

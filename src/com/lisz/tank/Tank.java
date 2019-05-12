package com.lisz.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank implements GameObject {
	private int x = 200;
	private int y = 200;
	private Dir dir = Dir.UP;
	private TankFrame tf;
	
	private static final int SPEED = 10;
	private boolean bL = false;
	private boolean bU = false;
	private boolean bR = false;
	private boolean bD = false;

	public Tank() {}
	
	public Tank (int x, int y, Dir dir, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}
	
	@Override
	public void move() {
		switch (dir) {
		case DOWN: y += SPEED; break;
		case UP: y -= SPEED; break;
		case LEFT: x -= SPEED; break;
		case RIGHT: x += SPEED; break;
		case LEFT_UP: x -= SPEED; y -= SPEED; break;
		case RIGHT_UP: x += SPEED; y -= SPEED; break;
		case RIGHT_DOWN: x += SPEED; y += SPEED; break;
		case LEFT_DOWN: x -= SPEED; y += SPEED; break;
		}
	}
	
	@Override
	public void setMainTankDir() {
		if (bD && !bU && !bR && !bL) {
			dir = Dir.DOWN;
		} else if (!bD && bU && !bR && !bL) {
			dir = Dir.UP;
		} else if (!bD && !bU && bR && !bL) {
			dir = Dir.RIGHT;
		} else if (!bD && !bU && !bR && bL) {
			dir = Dir.LEFT;
		} else if (!bD && bU && !bR && bL) {
			dir = Dir.LEFT_UP;
		} else if (!bD && bU && bR && !bL) {
			dir = Dir.RIGHT_UP;
		} else if (bD && !bU && bR && !bL) {
			dir = Dir.RIGHT_DOWN;
		} else if (bD && !bU && !bR && bL) {
			dir = Dir.LEFT_DOWN;
		} 
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void setbL(boolean bL) {
		this.bL = bL;
	}

	public void setbU(boolean bU) {
		this.bU = bU;
	}

	public void setbR(boolean bR) {
		this.bR = bR;
	}

	public void setbD(boolean bD) {
		this.bD = bD;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, tf.getWidth(), tf.getHeight());
		g.setColor(new Color(0, 0, 0));
		g.fillRect(x, y, 50, 50);
	}

}

package com.lisz.tank;

import java.awt.Graphics;

public abstract class GameObject implements GameModel {
	protected int x = 200;
	protected int y = 200;
	protected int width;
	protected int height;
	protected boolean live;
	protected Dir dir = Dir.UP;
	protected TankFrame tf;
	protected boolean moving = false;
	protected boolean good;
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public abstract void move();

	@Override
	public Dir getDir() {
		return dir;
	}

	@Override
	public void setDir(Dir dir) {
		this.dir = dir;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	public abstract void paint(Graphics g);

	@Override
	public boolean isMoving() {
		return moving;
	}

	@Override
	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public abstract void fire() ;

	@Override
	public boolean hit() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}

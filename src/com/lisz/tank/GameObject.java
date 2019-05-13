package com.lisz.tank;

import java.awt.Graphics;

public class GameObject implements GameModel {
	protected boolean live;
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	@Override
	public void move() {

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
		// TODO Auto-generated method stub

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

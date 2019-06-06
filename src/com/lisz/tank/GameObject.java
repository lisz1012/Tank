package com.lisz.tank;

import java.awt.Graphics;

public abstract class GameObject implements GameModel {
	protected int x = 200;
	protected int y = 200;
	protected int origX;
	protected int origY;
	protected int width;
	protected int height;
	protected boolean live;
	protected Dir dir = Dir.UP;
	protected boolean moving = false;
	protected Group group;
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

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

	@Override
	public int getWidth() {
		return width;
	}
	
	@Override
	public int getHeight() {
		return height;
	}

	public abstract void fire() ;

	@Override
	public boolean outOfBound(GameFacade facade) {
		return x + width > facade.getGameWidth() || x < 0 || y + height > facade.getGameHeight() || y < 20;
	}

	public int getOrigX() {
		return origX;
	}

	public int getOrigY() {
		return origY;
	}

	@Override
	public void die() {
		live = false;
	}
}

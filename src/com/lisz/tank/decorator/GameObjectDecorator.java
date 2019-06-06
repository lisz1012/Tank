package com.lisz.tank.decorator;

import java.awt.Graphics;

import com.lisz.tank.GameObject;

public abstract class GameObjectDecorator extends GameObject {
	protected GameObject gameObject;
	
	public GameObjectDecorator(GameObject gameObject) {
		super();
		this.gameObject = gameObject;
	}

	@Override
	public void move() {
		gameObject.move();
	}

	@Override
	public void paint(Graphics g) {
		gameObject.paint(g);
		decorate(g);
	}

	@Override
	public void fire() {
		gameObject.fire();
	}

	public abstract void decorate(Graphics g);
}

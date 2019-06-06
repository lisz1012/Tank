package com.lisz.tank.decorator;

import java.awt.Color;
import java.awt.Graphics;

import com.lisz.tank.GameObject;

public class BloodDecorator extends GameObjectDecorator {

	public BloodDecorator(GameObject gameObject) {
		super(gameObject);
	}

	@Override
	public void decorate(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillRect(gameObject.getX(), gameObject.getY() - 25, gameObject.getWidth(), 15);
		g.setColor(c);
	}
}

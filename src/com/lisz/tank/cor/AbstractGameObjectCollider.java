package com.lisz.tank.cor;

import com.lisz.tank.GameObject;

public abstract class AbstractGameObjectCollider implements Collider {

	@Override
	public boolean hit(GameObject o1, GameObject o2) {
		return o1.getX() > o2.getX() - o1.getWidth() && o1.getX() < o2.getX() + o2.getWidth() && 
				   o1.getY() > o2.getY() - o1.getHeight() && o1.getY() < o2.getY() + o2.getHeight();
	}

	@Override
	public void collide(GameObject o1, GameObject o2) {
		if (isEnactable(o1, o2)) {
			collideImpl(o1, o2);
		}
	}
	
	abstract void collideImpl(GameObject o1, GameObject o2);
}

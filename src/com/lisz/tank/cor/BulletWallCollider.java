package com.lisz.tank.cor;

import com.lisz.tank.Bullet;
import com.lisz.tank.GameObject;
import com.lisz.tank.Wall;

public class BulletWallCollider extends AbstractGameObjectCollider {

	@Override
	public boolean typeMatch(GameObject o1, GameObject o2) {
		return o1 instanceof Bullet && o2 instanceof Wall || o1 instanceof Wall && o2 instanceof Bullet;
	}

	@Override
	public boolean isEnactable(GameObject o1, GameObject o2) {
		return typeMatch(o1, o2) && hit(o1, o2);
	}

	@Override
	void collideImpl(GameObject o1, GameObject o2) {
		if (o1 instanceof Bullet) {
			((Bullet)o1).dieWithExplosion();
		} else {
			((Bullet)o2).dieWithExplosion();
		}
	}

}

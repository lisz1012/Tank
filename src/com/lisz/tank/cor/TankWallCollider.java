package com.lisz.tank.cor;

import com.lisz.tank.GameObject;
import com.lisz.tank.Tank;
import com.lisz.tank.Wall;

public class TankWallCollider extends AbstractGameObjectCollider {

	@Override
	public boolean typeMatch(GameObject o1, GameObject o2) {
		return o1 instanceof Tank && o2 instanceof Wall || o1 instanceof Wall && o2 instanceof Tank;
	}

	@Override
	public boolean isEnactable(GameObject o1, GameObject o2) {
		return typeMatch(o1, o2) && hit(o1, o2);
	}

	@Override
	void collideImpl(GameObject o1, GameObject o2) {
		if (o1 instanceof Tank) {
			((Tank) o1).back();
		} else {
			((Tank) o2).back();
		}
	}

}

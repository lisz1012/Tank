package com.lisz.tank.cor;

import com.lisz.tank.GameObject;
import com.lisz.tank.Tank;

public class TankTankCollider extends AbstractGameObjectCollider {

	@Override
	public boolean typeMatch(GameObject o1, GameObject o2) {
		return (o1 instanceof Tank) && (o2 instanceof Tank);
	}

	@Override
	public boolean isEnactable(GameObject o1, GameObject o2) {
		return (typeMatch(o1, o2)) 
				   && hit(o1, o2);
	}

	@Override
	public void collide(GameObject o1, GameObject o2) {
		if (isEnactable(o1, o2)) {
			Tank t = (Tank)o1;
			t.setX(t.getOrigX());
			t.setY(t.getOrigY());
		}
	}

}

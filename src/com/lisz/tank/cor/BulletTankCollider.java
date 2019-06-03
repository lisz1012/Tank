package com.lisz.tank.cor;

import com.lisz.tank.Bullet;
import com.lisz.tank.GameObject;
import com.lisz.tank.Tank;

public class BulletTankCollider extends AbstractGameObjectCollider {

	@Override
	public void collide(GameObject o1, GameObject o2) {
		if (isEnactable(o1, o2)) {
			o1.die();
			o2.die();
		}
	}

	@Override
	public boolean isEnactable(GameObject o1, GameObject o2) {
	    return (typeMatch(o1, o2)) 
			   && hit(o1, o2) && o1.getGroup() != o2.getGroup();
	}

	@Override
	public boolean typeMatch(GameObject o1, GameObject o2) {
		return (o1 instanceof Bullet) && (o2 instanceof Tank) || (o1 instanceof Tank) && (o2 instanceof Bullet);
	}

	
}

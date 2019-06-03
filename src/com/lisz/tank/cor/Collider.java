package com.lisz.tank.cor;

import com.lisz.tank.GameObject;

public interface Collider {
	boolean typeMatch(GameObject o1, GameObject o2);
	boolean isEnactable(GameObject o1, GameObject o2);
	boolean hit(GameObject o1, GameObject o2);
	void collide(GameObject o1, GameObject o2);
}

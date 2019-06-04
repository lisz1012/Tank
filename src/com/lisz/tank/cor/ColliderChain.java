package com.lisz.tank.cor;

import java.util.LinkedList;
import java.util.List;

import com.lisz.tank.GameObject;


public class ColliderChain extends AbstractGameObjectCollider {
	private List<Collider> colliders = new LinkedList<>();

	public ColliderChain() {
		add(new TankTankCollider()).
		add(new BulletTankCollider());
	}

	public ColliderChain add(Collider collider) {
		colliders.add(collider);
		return this;
	}

	public void collide(GameObject gameObject, GameObject other) {
		for (Collider collider : colliders) {
			collider.collide(gameObject, other);
		}
	}

	@Override
	public boolean typeMatch(GameObject o1, GameObject o2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnactable(GameObject o1, GameObject o2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void collideImpl(GameObject o1, GameObject o2) {
	}
}

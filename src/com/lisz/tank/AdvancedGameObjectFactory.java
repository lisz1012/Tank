package com.lisz.tank;

public class AdvancedGameObjectFactory implements GameObjectFactory {

	@Override
	public Tank createTank(int x, int y, Dir dir, TankFrame tf, Group group, Cannon cannon) {
		return new Tank(x, y, dir, tf, group, cannon);
	}

	@Override
	public Bullet createBullet(Dir dir, int x, int y, TankFrame tf, Group group) {
		return new Bullet(dir, x, y, tf, group);
	}

	@Override
	public Explosion createExlposion(int x, int y) {
		return new Explosion(x, y);
	}

}

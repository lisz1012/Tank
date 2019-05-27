package com.lisz.tank;

public class DefaultGameObjectFactory implements GameObjectFactory {

	@Override
	public Tank createTank(int x, int y, Dir dir, TankFrame tf, Group group, Cannon cannon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bullet createBullet(Dir dir, int x, int y, TankFrame tf, Group group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Explosion createExlposion(int x, int y) {
		return new Explosion(x, y);
	}

}

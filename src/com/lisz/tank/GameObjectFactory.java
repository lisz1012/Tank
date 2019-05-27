package com.lisz.tank;

public interface GameObjectFactory {
	Tank createTank(int x, int y, Dir dir, TankFrame tf, Group group, Cannon cannon);
	Bullet createBullet(Dir dir, int x, int y, TankFrame tf, Group group);
	Explosion createExlposion(int x, int y);
}

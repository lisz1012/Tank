package com.lisz.tank;

public interface GameObjectFactory {
	Tank createTank(int x, int y, Dir dir, TankFrame tf, Group group, Cannon cannon);
	//有这个方法是因为想用策略模式做Cannon，可能跟抽象工厂方法略有冲突
	Tank createTank(int x, int y, Dir dir, TankFrame tf, Group group);
	Bullet createBullet(Dir dir, int x, int y, TankFrame tf, Group group);
	Explosion createExlposion(int x, int y);
}

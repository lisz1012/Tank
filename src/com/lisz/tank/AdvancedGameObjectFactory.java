package com.lisz.tank;

public class AdvancedGameObjectFactory implements GameObjectFactory {

	@Override
	public Tank createTank(int x, int y, Dir dir, TankFrame tf, Group group, Cannon cannon) {
		System.out.println(cannon instanceof EightDirectionCannon);
		return new AdvancedTank(x, y, dir, tf, group, cannon);
	}
	
	//有这个方法是因为想用策略模式做Cannon，可能跟抽象工厂方法略有冲突
	@Override
	public Tank createTank(int x, int y, Dir dir, TankFrame tf, Group group) {
		return new AdvancedTank(x, y, dir, tf, group);
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

package com.lisz.tank;

public class EightDirectionCannon implements Cannon {
	private static final Cannon INSTANCE = new EightDirectionCannon();
	
	private EightDirectionCannon() {}

	public static final Cannon getInstance() {
		return INSTANCE;
	}
	
	@Override
	public void fire(Tank tank) {
		Dir dirs[] = Dir.values();
		for (Dir dir : dirs) {
			tank.getFacade().gameObjects.add(new Bullet(dir, tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2, tank.getFacade(), tank.group));
		}
	}

}

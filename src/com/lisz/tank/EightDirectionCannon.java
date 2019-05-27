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
			tank.tf.gameObjects.add(TankFrame.GAME_OBJECT_FACTORY.createBullet(dir, tank.getX() + Tank.WIDTH / 2 - AdvancedBullet.WIDTH / 2, tank.getY() + Tank.HEIGHT / 2 - AdvancedBullet.HEIGHT / 2, tank.tf, tank.group));
		}
	}

}

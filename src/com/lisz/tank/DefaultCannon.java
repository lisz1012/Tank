package com.lisz.tank;

public class DefaultCannon implements Cannon {
	private static final Cannon INSTANCE = new DefaultCannon();
	
	private DefaultCannon() {}
	
	public static Cannon getInstance() {
		return INSTANCE;
	}

	@Override
	public void fire(Tank tank) {
		/*if (tank.getDir() == Dir.RIGHT_UP || tank.getDir() == Dir.LEFT_DOWN) {
			tank.tf.gameObjects.add(new Bullet(tank.getDir(), tank.getX() + Tank.WIDTH / 2 + 15, tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2, tank.tf, tank.group));
		} else {
			tank.tf.gameObjects.add(new Bullet(tank.getDir(), tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2, tank.tf, tank.group));
		}*/
		tank.tf.gameObjects.add(TankFrame.GAME_OBJECT_FACTORY.createBullet(tank.getDir(), tank.getX() + Tank.WIDTH / 2 - AdvancedBullet.WIDTH / 2, tank.getY() + Tank.HEIGHT / 2 - AdvancedBullet.HEIGHT / 2, tank.tf, tank.group));
	}

}

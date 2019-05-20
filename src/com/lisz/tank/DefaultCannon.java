package com.lisz.tank;

public class DefaultCannon implements Cannon {

	@Override
	public void fire(Tank tank) {
		if (tank.getDir() == Dir.RIGHT_UP || tank.getDir() == Dir.LEFT_DOWN) {
			tank.tf.gameObjects.add(new Bullet(tank.getDir(), tank.getX() + Tank.WIDTH / 2 + 15, tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2, tank.tf, tank.group));
		} else {
			tank.tf.gameObjects.add(new Bullet(tank.getDir(), tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2, tank.tf, tank.group));
		}
	}

}
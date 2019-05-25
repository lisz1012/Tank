package com.lisz.tank;

public class EightDirectionCannon implements Cannon {

	@Override
	public void fire(Tank tank) {
		tank.tf.gameObjects.add(new Bullet(Dir.LEFT, tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2, tank.tf, tank.group));
		tank.tf.gameObjects.add(new Bullet(Dir.LEFT_UP, tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2, tank.tf, tank.group));
		tank.tf.gameObjects.add(new Bullet(Dir.UP, tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2, tank.tf, tank.group));
		tank.tf.gameObjects.add(new Bullet(Dir.RIGHT_UP, tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2, tank.tf, tank.group));
		tank.tf.gameObjects.add(new Bullet(Dir.RIGHT, tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2, tank.tf, tank.group));
		tank.tf.gameObjects.add(new Bullet(Dir.RIGHT_DOWN, tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2, tank.tf, tank.group));
		tank.tf.gameObjects.add(new Bullet(Dir.DOWN, tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2, tank.tf, tank.group));
		tank.tf.gameObjects.add(new Bullet(Dir.LEFT_DOWN, tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2, tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2, tank.tf, tank.group));
	}

}

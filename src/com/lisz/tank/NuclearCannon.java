package com.lisz.tank;

public class NuclearCannon implements Cannon {

	@Override
	public void fire(Tank tank) {
		for (int i = 0; i < tank.tf.gameObjects.size(); i++) {
			GameObject object = tank.tf.gameObjects.get(i);
			if (object instanceof Tank && object != tank) {
				Tank t = (Tank)object;
				t.die();
			}
		}
	}

}

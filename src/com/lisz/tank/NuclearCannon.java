package com.lisz.tank;

public class NuclearCannon implements Cannon {
	private static final Cannon INSTANCE = new NuclearCannon();
	
	private NuclearCannon() {}
	
	public static Cannon getInstance() {
		return INSTANCE;
	}

	@Override
	public void fire(Tank tank) {
		for (int i = 0; i < tank.facade.gameObjects.size(); i++) {
			GameObject object = tank.facade.gameObjects.get(i);
			if (object instanceof Tank && object != tank) {
				Tank t = (Tank)object;
				t.die();
			}
		}
	}

}

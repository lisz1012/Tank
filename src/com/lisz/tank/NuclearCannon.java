package com.lisz.tank;

public class NuclearCannon implements Cannon {
	private static final Cannon INSTANCE = new NuclearCannon();
	
	private NuclearCannon() {}
	
	public static Cannon getInstance() {
		return INSTANCE;
	}

	@Override
	public void fire(Tank tank) {
		for (int i = 0; i < GameFacade.getInstance().gameObjects.size(); i++) {
			GameObject object = GameFacade.getInstance().gameObjects.get(i);
			if (object instanceof Tank && object != tank) {
				Tank t = (Tank)object;
				t.die();
			}
		}
	}

}

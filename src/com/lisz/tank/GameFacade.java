package com.lisz.tank;

import java.util.ArrayList;
import java.util.List;

public class GameFacade {
	public static final List<GameObject> GAME_OBJECTS = new ArrayList<>();
	public static long rounds = 0;
	public TankFrame tf;
	
	public GameFacade(TankFrame tf) {
		super();
		this.tf = tf;
	}

	public Tank createGoodTank(int x, int y) {
		return new Tank(x, y, Dir.UP, this, Group.GOOD, PropertyMgr.getCannon("goodCannon"));
	}
	
	public void initGameObjects(Tank tank, int enemyCount) {
		GAME_OBJECTS.add(tank);
		generateEnemies(enemyCount);
	}

	public void generateEnemies(int enemyCount) {
		for (int i = 0; i < enemyCount; i++) {
			Tank enemy = new Tank(50 + 65 * i, 100, Dir.DOWN, this, Group.BAD);
			enemy.setMoving(true);
			GAME_OBJECTS.add(enemy);
		}
	}
	
	public void calculateHit() {
		for (int i = 0; i < GAME_OBJECTS.size(); i++) {
			GameObject gameObject = GAME_OBJECTS.get(i);
			for (int j = i + 1; j < GAME_OBJECTS.size(); j++) {
				GameObject other = GAME_OBJECTS.get(j);
				gameObject.hit(other);
			}
		}
	}
	
	public void removeDeadGameObjects() {
		for (int i = GAME_OBJECTS.size() - 1; i >= 0; i--) {
			if (!GAME_OBJECTS.get(i).isLive()) {
				GAME_OBJECTS.remove(i);
			}
		}
	}
}

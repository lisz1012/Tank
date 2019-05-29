package com.lisz.tank;

import java.util.ArrayList;
import java.util.List;

public class GameFacade {
	public List<GameObject> gameObjects = new ArrayList<>();
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
		gameObjects.add(tank);
		generateEnemies(enemyCount);
	}

	public void generateEnemies(int enemyCount) {
		for (int i = 0; i < enemyCount; i++) {
			Tank enemy = new Tank(50 + 65 * i, 100, Dir.DOWN, this, Group.BAD);
			enemy.setMoving(true);
			gameObjects.add(enemy);
		}
	}
	
	public void calculateHit() {
		for (int i = 0; i < gameObjects.size(); i++) {
			GameObject gameObject = gameObjects.get(i);
			for (int j = i + 1; j < gameObjects.size(); j++) {
				GameObject other = gameObjects.get(j);
				gameObject.hit(other);
			}
		}
	}
	
	public void removeDeadGameObjects() {
		for (int i = gameObjects.size() - 1; i >= 0; i--) {
			if (!gameObjects.get(i).isLive()) {
				gameObjects.remove(i);
			}
		}
	}
}

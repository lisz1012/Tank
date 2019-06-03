package com.lisz.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.lisz.tank.cor.BulletTankCollider;
import com.lisz.tank.cor.Collider;
import com.lisz.tank.cor.TankTankCollider;

public class GameFacade {
	private static final GameFacade INSTANCE;
	private static final int INIT_X = PropertyMgr.getInt("initX");
	private static final int INIT_Y = PropertyMgr.getInt("initY");
	private Tank tank = new Tank(INIT_X, INIT_Y, Dir.UP, this, Group.GOOD, PropertyMgr.getCannon("goodCannon"));
	public List<GameObject> gameObjects = new ArrayList<>();//new HashSet<>();
	public static long rounds = 0;
	private int gameWidth;
	private int gameHeight;
	private List<Collider> colliders = new ArrayList<>();

	static {
		INSTANCE = new GameFacade();
	}
	private GameFacade() {
		colliders.add(new TankTankCollider());
		colliders.add(new BulletTankCollider());
	}
	
	public static GameFacade getInstance(int gameWidth, int gameHeight) {
		if (INSTANCE.gameWidth != 0 && INSTANCE.gameHeight != 0) {
			return INSTANCE;
		}
		INSTANCE.gameWidth = gameWidth;
		INSTANCE.gameHeight = gameHeight;
		return INSTANCE;
	}

	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("方向键移动，A键开炮!", 10, 40);
		g.drawString("Object的数量" + gameObjects.size(), 10, 60);
		g.setColor(c);
		
		for (int i = 0; i < gameObjects.size(); i++) {
			GameObject gameObject = gameObjects.get(i);
			for (int j = i + 1; j < gameObjects.size(); j++) {
				GameObject other = gameObjects.get(j);
				for (Collider collider : colliders) {
					collider.collide(gameObject, other);
				}
			}
		}
		
		for (int i = gameObjects.size() - 1; i >= 0; i--) {
			if (!gameObjects.get(i).isLive()) {
				gameObjects.remove(i);
			}
		}
		
		for (int i = 0; i < gameObjects.size(); i++) {
			gameObjects.get(i).paint(g);
		}
	}
	
	public void generateEnemies(int enemyCount) {
		for (int i = 0; i < enemyCount; i++) {
			Tank enemy = new Tank(50 + 65 * i, 100, Dir.DOWN, this, Group.BAD);
			enemy.setMoving(true);
			gameObjects.add(enemy);
		}
	}

	public Tank getMyTank() {
		return tank;
	}
	
	public int getGameWidth() {
		return gameWidth;
	}

	public int getGameHeight() {
		return gameHeight;
	}
}

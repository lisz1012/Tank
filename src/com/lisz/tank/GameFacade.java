package com.lisz.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.lisz.tank.cor.ColliderChain;

public class GameFacade {
	private static final GameFacade INSTANCE;
	private static final int INIT_X = PropertyMgr.getInt("initX");
	private static final int INIT_Y = PropertyMgr.getInt("initY");
	private static final List<Wall> WALLS = PropertyMgr.getWalls();
	private Tank tank = new Tank(INIT_X, INIT_Y, Dir.UP, this, Group.GOOD, PropertyMgr.getCannon("goodCannon"));
	public List<GameObject> gameObjects = new ArrayList<>();//new HashSet<>();
	public static long rounds = 0;
	private int gameWidth;
	private int gameHeight;
	private ColliderChain chain = new ColliderChain();

	static {
		INSTANCE = new GameFacade(TankFrame.GAME_WIDTH, TankFrame.GAME_HEIGHT);
	}
	
	private GameFacade(int gameWidth, int gameHeight) {
		this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;
	}
	
	public static GameFacade getInstance() {
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
				chain.collide(gameObject, other);
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
			Tank enemy = new Tank(50 + 65 * i, 100, Dir.DOWN, Group.BAD);
			enemy.setMoving(true);
			gameObjects.add(enemy);
		}
	}
	
	public void buildWalls() {
		gameObjects.addAll(WALLS);
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

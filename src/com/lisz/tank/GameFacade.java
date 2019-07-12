package com.lisz.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.lisz.tank.cor.ColliderChain;

public class GameFacade {
	private static final GameFacade INSTANCE;
	//private static final int INIT_X = PropertyMgr.getInt("initX");
	//private static final int INIT_Y = PropertyMgr.getInt("initY");
	private static final List<Wall> WALLS = PropertyMgr.getWalls();
	//private Tank tank = new Tank(INIT_X, INIT_Y, Dir.UP, this, Group.GOOD, PropertyMgr.getCannon("goodCannon"));
	private Tank tank = createTank();
	public List<GameObject> gameObjects = new ArrayList<>();//new HashSet<>();
	public static long rounds = 0;
	private int gameWidth;
	private int gameHeight;
	private ColliderChain chain = new ColliderChain();
	private static final Random RANDOM = new Random();

	static {
		INSTANCE = new GameFacade(TankFrame.GAME_WIDTH, TankFrame.GAME_HEIGHT);
	}
	
	private GameFacade(int gameWidth, int gameHeight) {
		this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;
	}
	
	private Tank createTank() {
		int x = 430 + RANDOM.nextInt(TankFrame.GAME_WIDTH - 430 - Tank.WIDTH);
		int y = 500 + RANDOM.nextInt(TankFrame.GAME_HEIGHT - 550 - Tank.HEIGHT);
		Group group = RANDOM.nextInt(100) % 2 == 0 ? Group.GOOD : Group.BAD;
		return new Tank(x, y, Dir.UP, group);
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
	
	public void save() {
		String pathname = this.getClass().getResource("/").getPath() + "game.data";
		File f = new File(pathname);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
			oos.writeObject(gameObjects);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load() {
		String pathname = this.getClass().getResource("/").getPath() + "game.data";
		File f = new File(pathname);
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
			gameObjects = (List<GameObject>)ois.readObject();
			// Load之后其他的物体都好说，自己的坦克一定要更新，否则tank不在gameObject中，按键不听使唤
			// TankFrame中还要用下面这里的tank更新它里面的我方坦克
			// 先写进去的先被读出来，TankFrame中最开始的时候是最先把自己的坦克加进gameObjects中的
			tank = (Tank)gameObjects.get(0);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

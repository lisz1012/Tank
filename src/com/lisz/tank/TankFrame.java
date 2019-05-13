package com.lisz.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


public class TankFrame extends Frame {
	private static final long serialVersionUID = 1L;
	private static final int GAME_WIDTH = 800;
	private static final int GAME_HEIGHT = 600;
	private static final int ENEMY_COUNT = 5;
	
	private GameObject tank = new Tank(200, 200, Dir.UP, this, true);
	public List<GameObject> gameObjects = new ArrayList<>();//new HashSet<>();
	private Image offScreenImage = null;
	
	
	public TankFrame() {
		setSize(GAME_WIDTH, GAME_HEIGHT);
		setResizable(false);
		setTitle("Tank War");
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		addKeyListener(new MyKeyListener());
		initGameObjects();
	}
	
	private void initGameObjects() {
		gameObjects.add(tank);
		generateEnemies(ENEMY_COUNT);
	}

	private void generateEnemies(int enemyCount) {
		for (int i = 0; i < enemyCount; i++) {
			gameObjects.add(new Tank(50 + 65 * i, 100, Dir.DOWN, this, false));
		}
	}

	//双缓冲，解决屏幕刷新速率太快，计算跟不上而出现的“闪烁”问题，先画在一个image上，然后再把整个image画到屏幕上
	//就是把内存的内容复制到显存
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("Object的数量" + gameObjects.size(), 10, 60);
		g.setColor(c);
		for (int i = gameObjects.size() - 1; i >= 0; i--) {
			if (!gameObjects.get(i).isLive()) {
				gameObjects.remove(i);
			}
		}
		gameObjects.forEach(o -> o.paint(g));
	}
	
	private class MyKeyListener extends KeyAdapter {
		private boolean bL = false;
		private boolean bU = false;
		private boolean bR = false;
		private boolean bD = false;
		
		@Override
		public void keyPressed(KeyEvent e) {
			setDirKeyPressedStatus(e, true);
			Dir dir = calculateDir();
			tank.setDir(dir);
			//tank.move();
		}

		private void setTankFire(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_A) {
				tank.fire();
			}
		}

		private Dir calculateDir() {
			Dir dir = tank.getDir();
			if (bD && !bU && !bR && !bL) {
				dir = Dir.DOWN;
			} else if (!bD && bU && !bR && !bL) {
				dir = Dir.UP;
			} else if (!bD && !bU && bR && !bL) {
				dir = Dir.RIGHT;
			} else if (!bD && !bU && !bR && bL) {
				dir = Dir.LEFT;
			} else if (!bD && bU && !bR && bL) {
				dir = Dir.LEFT_UP;
			} else if (!bD && bU && bR && !bL) {
				dir = Dir.RIGHT_UP;
			} else if (bD && !bU && bR && !bL) {
				dir = Dir.RIGHT_DOWN;
			} else if (bD && !bU && !bR && bL) {
				dir = Dir.LEFT_DOWN;
			} 
			return dir;
		}

		@Override
		public void keyReleased(KeyEvent e) {
			setDirKeyPressedStatus(e, false);
			Dir dir = calculateDir();
			tank.setDir(dir);
			setTankFire(e);
		}
		
		private void setDirKeyPressedStatus(KeyEvent e, boolean keyPressed) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP: bU = keyPressed; break;
			case KeyEvent.VK_DOWN: bD = keyPressed; break;
			case KeyEvent.VK_LEFT: bL = keyPressed; break;
			case KeyEvent.VK_RIGHT: bR = keyPressed; break;
			//default:return;
			}
			boolean dirKeyPressed = bU || bL || bR || bD;
			System.out.println("Tank moving: " + dirKeyPressed);
			tank.setMoving(dirKeyPressed);
		}
	}
}

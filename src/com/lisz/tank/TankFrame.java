package com.lisz.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class TankFrame extends Frame {
	private static final long serialVersionUID = 1L;
	public static final int GAME_WIDTH = PropertyMgr.getInt("gameWidth");
	public static final int GAME_HEIGHT = PropertyMgr.getInt("gameHeight");
	private GameFacade facade = GameFacade.getInstance();
	private Tank tank = facade.getMyTank();
	private static final int ENEMY_COUNT = PropertyMgr.getInt("initEnemyTankCount");
	private static final Audio BACK_GROUD_MUSIC = new BackGroundMusic("audio/war1.wav");
	private Image offScreenImage = null;
	private static final Color BACK_GROUND_COLOR = new Color(PropertyMgr.getInt("backGroundRedComponent"), 
			PropertyMgr.getInt("backGroundGreenComponent"), PropertyMgr.getInt("backGroundBlueComponent"));
	
	
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
		new Thread(BACK_GROUD_MUSIC).start();
	}
	
	private void initGameObjects() {
		facade.gameObjects.add(tank);
		facade.generateEnemies(ENEMY_COUNT);
		facade.buildWalls();
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
		gOffScreen.setColor(BACK_GROUND_COLOR);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
		GameFacade.rounds ++;
	}
	
	@Override
	public void paint(Graphics g) {
		facade.paint(g);
	}
	
	public Tank getTank() {
		return tank;
	}

	public void setTank(Tank tank) {
		this.tank = tank;
	}
	
	private class MyKeyListener extends KeyAdapter {
		private boolean bL = false;
		private boolean bU = false;
		private boolean bR = false;
		private boolean bD = false;
		
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_S: facade.save(); break;
			// Load之后其他的物体都好说，自己的坦克一定要更新，否则tank不在gameObject中，按键不听使唤
			case KeyEvent.VK_L: facade.load(); tank = facade.getMyTank(); break;
			case KeyEvent.VK_UP:	// 这里利用一下case穿透
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_RIGHT:
				if (!tank.isLive()) return;
				setDirKeyPressedStatus(e, true);
				Dir dir = calculateDir();
				tank.setDir(dir);
				if (tank.isMoving()) {
					new Thread(()->new Audio("audio/tank_move.wav").play()).start();
				}
				break;
			default:
				break;
			}
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
			switch (e.getKeyCode()) {
			case KeyEvent.VK_G:
				facade.generateEnemies(ENEMY_COUNT);
				break;
			default:
				break;
			}
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
			tank.setMoving(dirKeyPressed);
		}
	}
}

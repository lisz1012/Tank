package com.lisz.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Tank extends GameObject {
	public static final int WIDTH = ResourceMgr.ADVANCED_BAD_TANK_D_1.getWidth();
	public static final int HEIGHT = ResourceMgr.ADVANCED_BAD_TANK_D_1.getHeight();
	protected static final int SPEED = PropertyMgr.getInt("tankSpeed");
	protected static final Random RANDOM = new Random();
	protected static final int RANDOM_BASE_NUMBER = PropertyMgr.getInt("randomBaseNumber");
	protected static final int RESET_DIR_POSSIBILITY = PropertyMgr.getInt("resetDirPossibility");
	protected static final int FIRE_POSSIBILITY = PropertyMgr.getInt("firePossibility");
	protected Cannon cannon = PropertyMgr.getCannon("badCannon");
	
	protected Tank() {}
	
	public Tank (int x, int y, Dir dir, TankFrame tf, Group group) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		live = true;
		this.group = group;
		width = WIDTH;
		height = HEIGHT;
	}
	
	// 构造己方坦克发射厉害的子弹专用
	public Tank (int x, int y, Dir dir, TankFrame tf, Group group, Cannon cannon) {
		this(x, y, dir, tf, group);
		this.cannon = cannon;
	}
	
	@Override
	public void move() {
		if (!moving) return;
		origX = x;
		origY = y;
		switch (dir) {
		case DOWN: y += SPEED; break;
		case UP: y -= SPEED; break;
		case LEFT: x -= SPEED; break;
		case RIGHT: x += SPEED; break;
		case LEFT_UP: x -= SPEED; y -= SPEED; break;
		case RIGHT_UP: x += SPEED; y -= SPEED; break;
		case RIGHT_DOWN: x += SPEED; y += SPEED; break;
		case LEFT_DOWN: x -= SPEED; y += SPEED; break;
		default:break;
		}
		if (outOfBound(tf)) {
			x = origX;
			y = origY;
		}
		if (group == Group.BAD) {
			resetDir();
			fireRandomly();
		}
	}
	
	private void resetDir() {
		int r = RANDOM.nextInt(RANDOM_BASE_NUMBER);
		if (r > RESET_DIR_POSSIBILITY) {
			switch (r % 8) {
			case 0: dir = Dir.DOWN; break;
			case 1: dir = Dir.UP; break;
			case 2: dir = Dir.LEFT; break;
			case 3: dir = Dir.RIGHT; break;
			case 4: dir = Dir.LEFT_UP; break;
			case 5: dir = Dir.RIGHT_UP; break;
			case 6: dir = Dir.RIGHT_DOWN; break;
			case 7: dir = Dir.LEFT_DOWN; break;
			default:
				break;
			}
		}
	}
	
	private void fireRandomly() {
		if (!live) return;
		int r = RANDOM.nextInt(RANDOM_BASE_NUMBER);
		if (r > FIRE_POSSIBILITY) {
			fire();
		}
	}

	@Override
	public void setDir(Dir dir) {
		if (!live) return;
		this.dir = dir;
	}
	
	@Override
	public Dir getDir() {
		return dir;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	@Override
	public boolean isMoving() {
		return moving;
	}

	@Override
	public void setMoving(boolean moving) {
		if (!live) return;
		this.moving = moving;
	}

	@Override
	public void paint(Graphics g) {
		switch (dir) {
		case LEFT: 		 g.drawImage(ResourceMgr.TANK_L, x, y, null);	break;
		case RIGHT: 	 g.drawImage(ResourceMgr.TANK_R, x, y, null);	break;
		case UP: 		 g.drawImage(ResourceMgr.TANK_U, x, y, null);	break;
		case DOWN:  	 g.drawImage(ResourceMgr.TANK_D, x, y, null);	break;
		case LEFT_UP: 	 g.drawImage(ResourceMgr.TANK_LU, x, y, null);  break;
		case RIGHT_UP: 	 g.drawImage(ResourceMgr.TANK_RU, x, y, null);	break;
		case LEFT_DOWN:  g.drawImage(ResourceMgr.TANK_LD, x, y, null);	break;
		case RIGHT_DOWN: g.drawImage(ResourceMgr.TANK_RD, x, y, null);	break;
		default:
			break;
		}
		if (group == Group.GOOD) {
			Color c = g.getColor();
			g.setColor(Color.RED);
			g.drawString("My Tank", x, y);
			g.setColor(c);
		}
		move();
	}

	@Override
	public void fire() {
		if (!live) return;
		cannon.fire(this);
		 // TODO change it when using image
		if (group == Group.GOOD) {
			new Thread(new Audio("audio/tank_fire.wav")).start();
		}
	}
	
	public Cannon getCannon() {
		return cannon;
	}

	public void setCannon(Cannon cannon) {
		this.cannon = cannon;
	}
	
	@Override
	public void die() {
		super.die();
		tf.gameObjects.add(TankFrame.GAME_OBJECT_FACTORY.createExlposion(x, y));
	}
}

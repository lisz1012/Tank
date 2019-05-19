package com.lisz.tank;

import java.awt.Graphics;
import java.util.Random;

public class Tank extends GameObject {
	public static final int WIDTH = ResourceMgr.TANK_D.getWidth();
	public static final int HEIGHT = ResourceMgr.TANK_D.getHeight();
	private static final int SPEED = 10;
	private static final Random RANDOM = new Random();
	private static final int RANDOM_BASE_NUMBER = 1000;
	private static final int RESET_DIR_POSSIBILITY = 850;
	private static final int FIRE_POSSIBILITY = 970;
	
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
		if (!moving) {
			System.out.println("Set moving to false!");
		}
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
		move();
	}

	@Override
	public void fire() {
		if (!live) return;
		if (dir == Dir.RIGHT_UP || dir == Dir.LEFT_DOWN) {
			tf.gameObjects.add(new Bullet(dir, x + WIDTH / 2 + 15, y + HEIGHT / 2 - Bullet.HEIGHT / 2, tf, group));
		} else {
			tf.gameObjects.add(new Bullet(dir, x + WIDTH / 2 - Bullet.WIDTH / 2, y + HEIGHT / 2 - Bullet.HEIGHT / 2, tf, group));
		}
		 // TODO change it when using image
	}

}

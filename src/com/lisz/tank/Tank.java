package com.lisz.tank;

import java.awt.Graphics;
import java.util.Random;

public class Tank extends GameObject {
	public static final int WIDTH = ResourceMgr.TANK_D.getWidth();
	public static final int HEIGHT = ResourceMgr.TANK_D.getHeight();
	private static final int SPEED = 10;
	private static final Random RANDOM = new Random();
	
	public Tank (int x, int y, Dir dir, TankFrame tf, boolean good) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		live = true;
		this.good = good;
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
		if (!good) {
			resetDir();
		}
	}
	
	private void resetDir() {
		int r = RANDOM.nextInt(1000);
		if (r > 850) {
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

	@Override
	public void setDir(Dir dir) {
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
		if (dir == Dir.RIGHT_UP || dir == Dir.LEFT_DOWN) {
			tf.gameObjects.add(new Bullet(dir, x + WIDTH / 2 + 15, y + HEIGHT / 2 - Bullet.HEIGHT / 2, tf, good));
		} else {
			tf.gameObjects.add(new Bullet(dir, x + WIDTH / 2 - Bullet.WIDTH / 2, y + HEIGHT / 2 - Bullet.HEIGHT / 2, tf, good));
		}
		 // TODO change it when using image
	}

}

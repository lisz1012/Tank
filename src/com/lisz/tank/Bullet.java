package com.lisz.tank;

import java.awt.Graphics;

public class Bullet extends GameObject {
	private static final int SPEED = 15;
	public static final int WIDTH = ResourceMgr.BULLET_D.getWidth();
	public static final int HEIGHT = ResourceMgr.BULLET_D.getHeight();
	
	public Bullet(Dir dir, int x, int y, GameFacade facade, Group group) {
		super();
		this.dir = dir;
		this.x = x;
		this.y = y;
		this.facade = facade;
		this.group = group;
		live = true;
		moving = true;
		width = WIDTH;
		height = HEIGHT;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void move() {
		if (!moving) return;
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
		if (outOfBound(facade)) {
			die();
		}
	}

	@Override
	public void paint(Graphics g) {
		switch (dir) {
		case LEFT: 		 g.drawImage(ResourceMgr.BULLET_L, x, y, null);	break;
		case RIGHT: 	 g.drawImage(ResourceMgr.BULLET_R, x, y, null);	break;
		case UP: 		 g.drawImage(ResourceMgr.BULLET_U, x, y, null);	break;
		case DOWN:  	 g.drawImage(ResourceMgr.BULLET_D, x, y, null);	break;
		case LEFT_UP: 	 g.drawImage(ResourceMgr.BULLET_LU, x, y, null);  break;
		case RIGHT_UP: 	 g.drawImage(ResourceMgr.BULLET_RU, x, y, null);	break;
		case LEFT_DOWN:  g.drawImage(ResourceMgr.BULLET_LD, x, y, null);	break;
		case RIGHT_DOWN: g.drawImage(ResourceMgr.BULLET_RD, x, y, null);	break;
		default:
			break;
		}
		move();
	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub
		
	}

	public void dieWithExplosion() {
		die();
		Explosion explosion = new Explosion(x, y);
		explosion.setX(x + width / 2 - explosion.getWidth() - 35);
		explosion.setY(y + height / 2 - explosion.getHeight() - 50);
		facade.gameObjects.add(explosion);
	}
}

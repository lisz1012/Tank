package com.lisz.tank;

import java.awt.Graphics;

public class AdvancedBullet extends Bullet {
	public AdvancedBullet(Dir dir, int x, int y, TankFrame tf, Group group) {
		super(dir, x, y, tf, group);
	}

	@Override
	public void paint(Graphics g) {
		switch (dir) {
		case LEFT: 		 g.drawImage(ResourceMgr.ADVANCED_BULLET_L, x, y, null);	break;
		case RIGHT: 	 g.drawImage(ResourceMgr.ADVANCED_BULLET_R, x, y, null);	break;
		case UP: 		 g.drawImage(ResourceMgr.ADVANCED_BULLET_U, x, y, null);	break;
		case DOWN:  	 g.drawImage(ResourceMgr.ADVANCED_BULLET_D, x, y, null);	break;
		case LEFT_UP: 	 g.drawImage(ResourceMgr.ADVANCED_BULLET_LU, x, y, null);   break;
		case RIGHT_UP: 	 g.drawImage(ResourceMgr.ADVANCED_BULLET_RU, x, y, null);	break;
		case LEFT_DOWN:  g.drawImage(ResourceMgr.ADVANCED_BULLET_LD, x, y, null);	break;
		case RIGHT_DOWN: g.drawImage(ResourceMgr.ADVANCED_BULLET_RD, x, y, null);	break;
		default:
			break;
		}
		move();
	}

	@Override
	public void fire() {}

}

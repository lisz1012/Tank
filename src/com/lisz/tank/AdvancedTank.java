package com.lisz.tank;

import java.awt.Color;
import java.awt.Graphics;

public class AdvancedTank extends Tank {
	public AdvancedTank (int x, int y, Dir dir, TankFrame tf, Group group) {
		super(x, y, dir, tf, group);
	}
	
	// 构造己方坦克发射厉害的子弹专用
	public AdvancedTank (int x, int y, Dir dir, TankFrame tf, Group group, Cannon cannon) {
		super(x, y, dir, tf, group, cannon);
	}
	
	@Override
	public void paint(Graphics g) {
		if (TankFrame.rounds % 20 < 10) {
			paintTanks1(g);
		} else {
			paintTanks2(g);
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

	private void paintTanks1(Graphics g) {
		switch (dir) {
		case LEFT: 		 g.drawImage(group == Group.GOOD ? ResourceMgr.ADVANCED_GOOD_TANK_L_1 : ResourceMgr.ADVANCED_BAD_TANK_L_1, x, y, null);	break;
		case RIGHT: 	 g.drawImage(group == Group.GOOD ? ResourceMgr.ADVANCED_GOOD_TANK_R_1 : ResourceMgr.ADVANCED_BAD_TANK_R_1, x, y, null);	break;
		case UP: 		 g.drawImage(group == Group.GOOD ? ResourceMgr.ADVANCED_GOOD_TANK_U_1 : ResourceMgr.ADVANCED_BAD_TANK_U_1, x, y, null);	break;
		case DOWN:  	 g.drawImage(group == Group.GOOD ? ResourceMgr.ADVANCED_GOOD_TANK_D_1 : ResourceMgr.ADVANCED_BAD_TANK_D_1, x, y, null);	break;
		case LEFT_UP: 	 g.drawImage(group == Group.GOOD ? ResourceMgr.ADVANCED_GOOD_TANK_LU_1 : ResourceMgr.ADVANCED_BAD_TANK_LU_1, x, y, null);	break;
		case RIGHT_UP: 	 g.drawImage(group == Group.GOOD ? ResourceMgr.ADVANCED_GOOD_TANK_RU_1 : ResourceMgr.ADVANCED_BAD_TANK_RU_1, x, y, null);	break;
		case LEFT_DOWN:  g.drawImage(group == Group.GOOD ? ResourceMgr.ADVANCED_GOOD_TANK_LD_1 : ResourceMgr.ADVANCED_BAD_TANK_LD_1, x, y, null);	break;
		case RIGHT_DOWN: g.drawImage(group == Group.GOOD ? ResourceMgr.ADVANCED_GOOD_TANK_RD_1 : ResourceMgr.ADVANCED_BAD_TANK_RD_1, x, y, null);	break;
		default:
			break;
		}
	}
	
	private void paintTanks2(Graphics g) {
		switch (dir) {
		case LEFT: 		 g.drawImage(group == Group.GOOD ? ResourceMgr.ADVANCED_GOOD_TANK_L_2 : ResourceMgr.ADVANCED_BAD_TANK_L_2, x, y, null);	break;
		case RIGHT: 	 g.drawImage(group == Group.GOOD ? ResourceMgr.ADVANCED_GOOD_TANK_R_2 : ResourceMgr.ADVANCED_BAD_TANK_R_2, x, y, null);	break;
		case UP: 		 g.drawImage(group == Group.GOOD ? ResourceMgr.ADVANCED_GOOD_TANK_U_2 : ResourceMgr.ADVANCED_BAD_TANK_U_2, x, y, null);	break;
		case DOWN:  	 g.drawImage(group == Group.GOOD ? ResourceMgr.ADVANCED_GOOD_TANK_D_2 : ResourceMgr.ADVANCED_BAD_TANK_D_2, x, y, null);	break;
		case LEFT_UP: 	 g.drawImage(group == Group.GOOD ? ResourceMgr.ADVANCED_GOOD_TANK_LU_2 : ResourceMgr.ADVANCED_BAD_TANK_LU_2, x, y, null);	break;
		case RIGHT_UP: 	 g.drawImage(group == Group.GOOD ? ResourceMgr.ADVANCED_GOOD_TANK_RU_2 : ResourceMgr.ADVANCED_BAD_TANK_RU_2, x, y, null);	break;
		case LEFT_DOWN:  g.drawImage(group == Group.GOOD ? ResourceMgr.ADVANCED_GOOD_TANK_LD_2 : ResourceMgr.ADVANCED_BAD_TANK_LD_2, x, y, null);	break;
		case RIGHT_DOWN: g.drawImage(group == Group.GOOD ? ResourceMgr.ADVANCED_GOOD_TANK_RD_2 : ResourceMgr.ADVANCED_BAD_TANK_RD_2, x, y, null);	break;
		default:
			break;
		}
	}
}

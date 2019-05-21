package com.lisz.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ResourceMgr {
	public static BufferedImage BAD_TANK_L;
	public static BufferedImage BAD_TANK_U;
	public static BufferedImage BAD_TANK_R;
	public static BufferedImage BAD_TANK_D;
	public static BufferedImage BAD_TANK_LU;
	public static BufferedImage BAD_TANK_RU;
	public static BufferedImage BAD_TANK_RD;
	public static BufferedImage BAD_TANK_LD;
	
	public static BufferedImage GOOD_TANK_L;
	public static BufferedImage GOOD_TANK_U;
	public static BufferedImage GOOD_TANK_R;
	public static BufferedImage GOOD_TANK_D;
	public static BufferedImage GOOD_TANK_LU;
	public static BufferedImage GOOD_TANK_RU;
	public static BufferedImage GOOD_TANK_RD;
	public static BufferedImage GOOD_TANK_LD;
	
	public static BufferedImage BULLET_L;
	public static BufferedImage BULLET_U;
	public static BufferedImage BULLET_R;
	public static BufferedImage BULLET_D;
	public static BufferedImage BULLET_LU;
	public static BufferedImage BULLET_RU;
	public static BufferedImage BULLET_RD;
	public static BufferedImage BULLET_LD;
	
	public static BufferedImage EXPLOSION_IMGS[] = new BufferedImage[16];
	
	public static Audio EXPLOSION_AUDIO = new Audio("audio/explode.wav");
	
	static {
		try {
			BAD_TANK_U = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			BAD_TANK_R = ImageUtil.rotateImage(BAD_TANK_U, 90);
			BAD_TANK_L = ImageUtil.rotateImage(BAD_TANK_U, -90);
			BAD_TANK_D = ImageUtil.rotateImage(BAD_TANK_U, 180);
			BAD_TANK_LU = ImageUtil.rotateImage(BAD_TANK_U, -45);
			BAD_TANK_RU = ImageUtil.rotateImage(BAD_TANK_U, 45);
			BAD_TANK_RD = ImageUtil.rotateImage(BAD_TANK_U, 135);
			BAD_TANK_LD = ImageUtil.rotateImage(BAD_TANK_U, -135);
			
			GOOD_TANK_U = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
			GOOD_TANK_R = ImageUtil.rotateImage(GOOD_TANK_U, 90);
			GOOD_TANK_L = ImageUtil.rotateImage(GOOD_TANK_U, -90);
			GOOD_TANK_D = ImageUtil.rotateImage(GOOD_TANK_U, 180);
			GOOD_TANK_LU = ImageUtil.rotateImage(GOOD_TANK_U, -45);
			GOOD_TANK_RU = ImageUtil.rotateImage(GOOD_TANK_U, 45);
			GOOD_TANK_RD = ImageUtil.rotateImage(GOOD_TANK_U, 135);
			GOOD_TANK_LD = ImageUtil.rotateImage(GOOD_TANK_U, -135);
			
			BULLET_U = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
			BULLET_R = ImageUtil.rotateImage(BULLET_U, 90);
			BULLET_L = ImageUtil.rotateImage(BULLET_U, -90);
			BULLET_D = ImageUtil.rotateImage(BULLET_U, 180);
			BULLET_LU = ImageUtil.rotateImage(BULLET_U, -45);
			BULLET_RU = ImageUtil.rotateImage(BULLET_U, 45);
			BULLET_RD = ImageUtil.rotateImage(BULLET_U, 135);
			BULLET_LD = ImageUtil.rotateImage(BULLET_U, -135);
			
			for (int i = 0; i < EXPLOSION_IMGS.length; i++) {
				EXPLOSION_IMGS[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

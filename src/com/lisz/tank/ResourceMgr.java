package com.lisz.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ResourceMgr {
	public static BufferedImage TANK_L;
	public static BufferedImage TANK_U;
	public static BufferedImage TANK_R;
	public static BufferedImage TANK_D;
	public static BufferedImage TANK_LU;
	public static BufferedImage TANK_RU;
	public static BufferedImage TANK_RD;
	public static BufferedImage TANK_LD;
	
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
			TANK_U = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			TANK_R = ImageUtil.rotateImage(TANK_U, 90);
			TANK_L = ImageUtil.rotateImage(TANK_U, -90);
			TANK_D = ImageUtil.rotateImage(TANK_U, 180);
			TANK_LU = ImageUtil.rotateImage(TANK_U, -45);
			TANK_RU = ImageUtil.rotateImage(TANK_U, 45);
			TANK_RD = ImageUtil.rotateImage(TANK_U, 135);
			TANK_LD = ImageUtil.rotateImage(TANK_U, -135);
			
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

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
			TANK_L = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
			TANK_U = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
			TANK_R = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
			TANK_D = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
			TANK_LU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankLU.gif"));
			TANK_RU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankRU.gif"));
			TANK_RD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankRD.gif"));
			TANK_LD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankLD.gif"));
			
			BULLET_L = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
			BULLET_U = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
			BULLET_R = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
			BULLET_D = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			BULLET_LU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletLU.gif"));
			BULLET_RU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletRU.gif"));
			BULLET_RD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletRD.gif"));
			BULLET_LD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletLD.gif"));
			
			for (int i = 0; i < EXPLOSION_IMGS.length; i++) {
				EXPLOSION_IMGS[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

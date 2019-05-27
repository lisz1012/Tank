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
	
	public static BufferedImage ADVANCED_BAD_TANK_L_1;
	public static BufferedImage ADVANCED_BAD_TANK_U_1;
	public static BufferedImage ADVANCED_BAD_TANK_R_1;
	public static BufferedImage ADVANCED_BAD_TANK_D_1;
	public static BufferedImage ADVANCED_BAD_TANK_LU_1;
	public static BufferedImage ADVANCED_BAD_TANK_RU_1;
	public static BufferedImage ADVANCED_BAD_TANK_RD_1;
	public static BufferedImage ADVANCED_BAD_TANK_LD_1;
	
	public static BufferedImage ADVANCED_GOOD_TANK_L_1;
	public static BufferedImage ADVANCED_GOOD_TANK_U_1;
	public static BufferedImage ADVANCED_GOOD_TANK_R_1;
	public static BufferedImage ADVANCED_GOOD_TANK_D_1;
	public static BufferedImage ADVANCED_GOOD_TANK_LU_1;
	public static BufferedImage ADVANCED_GOOD_TANK_RU_1;
	public static BufferedImage ADVANCED_GOOD_TANK_RD_1;
	public static BufferedImage ADVANCED_GOOD_TANK_LD_1;
	
	public static BufferedImage ADVANCED_BAD_TANK_L_2;
	public static BufferedImage ADVANCED_BAD_TANK_U_2;
	public static BufferedImage ADVANCED_BAD_TANK_R_2;
	public static BufferedImage ADVANCED_BAD_TANK_D_2;
	public static BufferedImage ADVANCED_BAD_TANK_LU_2;
	public static BufferedImage ADVANCED_BAD_TANK_RU_2;
	public static BufferedImage ADVANCED_BAD_TANK_RD_2;
	public static BufferedImage ADVANCED_BAD_TANK_LD_2;
	
	public static BufferedImage ADVANCED_GOOD_TANK_L_2;
	public static BufferedImage ADVANCED_GOOD_TANK_U_2;
	public static BufferedImage ADVANCED_GOOD_TANK_R_2;
	public static BufferedImage ADVANCED_GOOD_TANK_D_2;
	public static BufferedImage ADVANCED_GOOD_TANK_LU_2;
	public static BufferedImage ADVANCED_GOOD_TANK_RU_2;
	public static BufferedImage ADVANCED_GOOD_TANK_RD_2;
	public static BufferedImage ADVANCED_GOOD_TANK_LD_2;
	
	public static BufferedImage ADVANCED_BULLET_L;
	public static BufferedImage ADVANCED_BULLET_U;
	public static BufferedImage ADVANCED_BULLET_R;
	public static BufferedImage ADVANCED_BULLET_D;
	public static BufferedImage ADVANCED_BULLET_LU;
	public static BufferedImage ADVANCED_BULLET_RU;
	public static BufferedImage ADVANCED_BULLET_RD;
	public static BufferedImage ADVANCED_BULLET_LD;
	
	public static BufferedImage ADVANCED_EXPLOSION_IMGS[] = new BufferedImage[16];
	
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
			
			ADVANCED_BAD_TANK_U_1 = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			ADVANCED_BAD_TANK_R_1 = ImageUtil.rotateImage(ADVANCED_BAD_TANK_U_1, 90);
			ADVANCED_BAD_TANK_L_1 = ImageUtil.rotateImage(ADVANCED_BAD_TANK_U_1, -90);
			ADVANCED_BAD_TANK_D_1 = ImageUtil.rotateImage(ADVANCED_BAD_TANK_U_1, 180);
			ADVANCED_BAD_TANK_LU_1 = ImageUtil.rotateImage(ADVANCED_BAD_TANK_U_1, -45);
			ADVANCED_BAD_TANK_RU_1 = ImageUtil.rotateImage(ADVANCED_BAD_TANK_U_1, 45);
			ADVANCED_BAD_TANK_RD_1 = ImageUtil.rotateImage(ADVANCED_BAD_TANK_U_1, 135);
			ADVANCED_BAD_TANK_LD_1 = ImageUtil.rotateImage(ADVANCED_BAD_TANK_U_1, -135);
			
			ADVANCED_GOOD_TANK_U_1 = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
			ADVANCED_GOOD_TANK_R_1 = ImageUtil.rotateImage(ADVANCED_GOOD_TANK_U_1, 90);
			ADVANCED_GOOD_TANK_L_1 = ImageUtil.rotateImage(ADVANCED_GOOD_TANK_U_1, -90);
			ADVANCED_GOOD_TANK_D_1 = ImageUtil.rotateImage(ADVANCED_GOOD_TANK_U_1, 180);
			ADVANCED_GOOD_TANK_LU_1 = ImageUtil.rotateImage(ADVANCED_GOOD_TANK_U_1, -45);
			ADVANCED_GOOD_TANK_RU_1 = ImageUtil.rotateImage(ADVANCED_GOOD_TANK_U_1, 45);
			ADVANCED_GOOD_TANK_RD_1 = ImageUtil.rotateImage(ADVANCED_GOOD_TANK_U_1, 135);
			ADVANCED_GOOD_TANK_LD_1 = ImageUtil.rotateImage(ADVANCED_GOOD_TANK_U_1, -135);
			
			ADVANCED_BAD_TANK_U_2 = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank2.png"));
			ADVANCED_BAD_TANK_R_2 = ImageUtil.rotateImage(ADVANCED_BAD_TANK_U_2, 90);
			ADVANCED_BAD_TANK_L_2 = ImageUtil.rotateImage(ADVANCED_BAD_TANK_U_2, -90);
			ADVANCED_BAD_TANK_D_2 = ImageUtil.rotateImage(ADVANCED_BAD_TANK_U_2, 180);
			ADVANCED_BAD_TANK_LU_2 = ImageUtil.rotateImage(ADVANCED_BAD_TANK_U_2, -45);
			ADVANCED_BAD_TANK_RU_2 = ImageUtil.rotateImage(ADVANCED_BAD_TANK_U_2, 45);
			ADVANCED_BAD_TANK_RD_2 = ImageUtil.rotateImage(ADVANCED_BAD_TANK_U_2, 135);
			ADVANCED_BAD_TANK_LD_2 = ImageUtil.rotateImage(ADVANCED_BAD_TANK_U_2, -135);
			
			ADVANCED_GOOD_TANK_U_2 = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank2.png"));
			ADVANCED_GOOD_TANK_R_2 = ImageUtil.rotateImage(ADVANCED_GOOD_TANK_U_2, 90);
			ADVANCED_GOOD_TANK_L_2 = ImageUtil.rotateImage(ADVANCED_GOOD_TANK_U_2, -90);
			ADVANCED_GOOD_TANK_D_2 = ImageUtil.rotateImage(ADVANCED_GOOD_TANK_U_2, 180);
			ADVANCED_GOOD_TANK_LU_2 = ImageUtil.rotateImage(ADVANCED_GOOD_TANK_U_2, -45);
			ADVANCED_GOOD_TANK_RU_2 = ImageUtil.rotateImage(ADVANCED_GOOD_TANK_U_2, 45);
			ADVANCED_GOOD_TANK_RD_2 = ImageUtil.rotateImage(ADVANCED_GOOD_TANK_U_2, 135);
			ADVANCED_GOOD_TANK_LD_2 = ImageUtil.rotateImage(ADVANCED_GOOD_TANK_U_2, -135);
			
			ADVANCED_BULLET_U = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
			ADVANCED_BULLET_R = ImageUtil.rotateImage(ADVANCED_BULLET_U, 90);
			ADVANCED_BULLET_L = ImageUtil.rotateImage(ADVANCED_BULLET_U, -90);
			ADVANCED_BULLET_D = ImageUtil.rotateImage(ADVANCED_BULLET_U, 180);
			ADVANCED_BULLET_LU = ImageUtil.rotateImage(ADVANCED_BULLET_U, -45);
			ADVANCED_BULLET_RU = ImageUtil.rotateImage(ADVANCED_BULLET_U, 45);
			ADVANCED_BULLET_RD = ImageUtil.rotateImage(ADVANCED_BULLET_U, 135);
			ADVANCED_BULLET_LD = ImageUtil.rotateImage(ADVANCED_BULLET_U, -135);
			
			for (int i = 0; i < ADVANCED_EXPLOSION_IMGS.length; i++) {
				ADVANCED_EXPLOSION_IMGS[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

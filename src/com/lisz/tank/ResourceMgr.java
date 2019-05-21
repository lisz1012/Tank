package com.lisz.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ResourceMgr {
	public static BufferedImage BAD_TANK_L_1;
	public static BufferedImage BAD_TANK_U_1;
	public static BufferedImage BAD_TANK_R_1;
	public static BufferedImage BAD_TANK_D_1;
	public static BufferedImage BAD_TANK_LU_1;
	public static BufferedImage BAD_TANK_RU_1;
	public static BufferedImage BAD_TANK_RD_1;
	public static BufferedImage BAD_TANK_LD_1;
	
	public static BufferedImage GOOD_TANK_L_1;
	public static BufferedImage GOOD_TANK_U_1;
	public static BufferedImage GOOD_TANK_R_1;
	public static BufferedImage GOOD_TANK_D_1;
	public static BufferedImage GOOD_TANK_LU_1;
	public static BufferedImage GOOD_TANK_RU_1;
	public static BufferedImage GOOD_TANK_RD_1;
	public static BufferedImage GOOD_TANK_LD_1;
	
	public static BufferedImage BAD_TANK_L_2;
	public static BufferedImage BAD_TANK_U_2;
	public static BufferedImage BAD_TANK_R_2;
	public static BufferedImage BAD_TANK_D_2;
	public static BufferedImage BAD_TANK_LU_2;
	public static BufferedImage BAD_TANK_RU_2;
	public static BufferedImage BAD_TANK_RD_2;
	public static BufferedImage BAD_TANK_LD_2;
	
	public static BufferedImage GOOD_TANK_L_2;
	public static BufferedImage GOOD_TANK_U_2;
	public static BufferedImage GOOD_TANK_R_2;
	public static BufferedImage GOOD_TANK_D_2;
	public static BufferedImage GOOD_TANK_LU_2;
	public static BufferedImage GOOD_TANK_RU_2;
	public static BufferedImage GOOD_TANK_RD_2;
	public static BufferedImage GOOD_TANK_LD_2;
	
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
			BAD_TANK_U_1 = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			BAD_TANK_R_1 = ImageUtil.rotateImage(BAD_TANK_U_1, 90);
			BAD_TANK_L_1 = ImageUtil.rotateImage(BAD_TANK_U_1, -90);
			BAD_TANK_D_1 = ImageUtil.rotateImage(BAD_TANK_U_1, 180);
			BAD_TANK_LU_1 = ImageUtil.rotateImage(BAD_TANK_U_1, -45);
			BAD_TANK_RU_1 = ImageUtil.rotateImage(BAD_TANK_U_1, 45);
			BAD_TANK_RD_1 = ImageUtil.rotateImage(BAD_TANK_U_1, 135);
			BAD_TANK_LD_1 = ImageUtil.rotateImage(BAD_TANK_U_1, -135);
			
			GOOD_TANK_U_1 = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
			GOOD_TANK_R_1 = ImageUtil.rotateImage(GOOD_TANK_U_1, 90);
			GOOD_TANK_L_1 = ImageUtil.rotateImage(GOOD_TANK_U_1, -90);
			GOOD_TANK_D_1 = ImageUtil.rotateImage(GOOD_TANK_U_1, 180);
			GOOD_TANK_LU_1 = ImageUtil.rotateImage(GOOD_TANK_U_1, -45);
			GOOD_TANK_RU_1 = ImageUtil.rotateImage(GOOD_TANK_U_1, 45);
			GOOD_TANK_RD_1 = ImageUtil.rotateImage(GOOD_TANK_U_1, 135);
			GOOD_TANK_LD_1 = ImageUtil.rotateImage(GOOD_TANK_U_1, -135);
			
			BAD_TANK_U_2 = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank2.png"));
			BAD_TANK_R_2 = ImageUtil.rotateImage(BAD_TANK_U_2, 90);
			BAD_TANK_L_2 = ImageUtil.rotateImage(BAD_TANK_U_2, -90);
			BAD_TANK_D_2 = ImageUtil.rotateImage(BAD_TANK_U_2, 180);
			BAD_TANK_LU_2 = ImageUtil.rotateImage(BAD_TANK_U_2, -45);
			BAD_TANK_RU_2 = ImageUtil.rotateImage(BAD_TANK_U_2, 45);
			BAD_TANK_RD_2 = ImageUtil.rotateImage(BAD_TANK_U_2, 135);
			BAD_TANK_LD_2 = ImageUtil.rotateImage(BAD_TANK_U_2, -135);
			
			GOOD_TANK_U_2 = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank2.png"));
			GOOD_TANK_R_2 = ImageUtil.rotateImage(GOOD_TANK_U_2, 90);
			GOOD_TANK_L_2 = ImageUtil.rotateImage(GOOD_TANK_U_2, -90);
			GOOD_TANK_D_2 = ImageUtil.rotateImage(GOOD_TANK_U_2, 180);
			GOOD_TANK_LU_2 = ImageUtil.rotateImage(GOOD_TANK_U_2, -45);
			GOOD_TANK_RU_2 = ImageUtil.rotateImage(GOOD_TANK_U_2, 45);
			GOOD_TANK_RD_2 = ImageUtil.rotateImage(GOOD_TANK_U_2, 135);
			GOOD_TANK_LD_2 = ImageUtil.rotateImage(GOOD_TANK_U_2, -135);
			
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

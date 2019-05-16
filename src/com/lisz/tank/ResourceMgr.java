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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

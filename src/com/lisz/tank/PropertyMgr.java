package com.lisz.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr <T>{
	static Properties props = new Properties();
	static {
		try {
			props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int getInt(String key) {
		return Integer.parseInt(props.get(key).toString());
	}
	
	public static void main(String[] args) {
		System.out.println(PropertyMgr.getInt("initEnemyTankCount"));
	}
}

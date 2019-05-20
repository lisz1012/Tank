package com.lisz.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
	static Properties props = new Properties();
	static {
		try {
			props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String get(String key) {
		if (props == null) {
			return null;
		}
		return props.get(key).toString();
	}
	
	public static void main(String[] args) {
		System.out.println(PropertyMgr.get("initEnemyTankCount"));
	}
}

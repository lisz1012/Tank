package com.lisz.tank;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
	
	public static Cannon getCannon(String key) {
		String cannonName = props.get(key).toString();
		Cannon cannon = null;
		try {
			cannon = (Cannon)Class.forName(cannonName).getMethod("getInstance").invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cannon;
	}
	
	public static GameObjectFactory getGameObjectFactory(String key) {
		String gameObjectFactoryName = props.get(key).toString();
		GameObjectFactory gameObjectFactory = null;
		try {
			gameObjectFactory = (GameObjectFactory)Class.forName(gameObjectFactoryName).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return gameObjectFactory;
	}
	
	public static void main(String[] args) {
		System.out.println(PropertyMgr.getInt("initEnemyTankCount"));
	}
}

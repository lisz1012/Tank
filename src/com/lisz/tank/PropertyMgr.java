package com.lisz.tank;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.lisz.tank.cor.Collider;

public class PropertyMgr <T>{
	private static Properties props = new Properties();
	private static final String WALLS_KEY = "walls";
	private static final String OBJECT_SEPARATOR = "-";
	private static final String PROPERTY_SEPARATOR = ",";
	
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
	
	public static List<Collider> getColliders(String key) {
		String collidersStr = props.get(key).toString();
		String collidersStrs[] = collidersStr.split(",");
		List<Collider> colliders = new LinkedList<>();
		for (String colliderStr : collidersStrs) {
			try {
				Collider collider = (Collider)Class.forName(colliderStr).getConstructor().newInstance();
				colliders.add(collider);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return colliders;
	}
	
	public static void main(String[] args) {
		System.out.println(PropertyMgr.getInt("initEnemyTankCount"));
	}

	public static List<Wall> getWalls() {
		String allWallsStr = props.getProperty(WALLS_KEY);
		String walls[] = allWallsStr.split(OBJECT_SEPARATOR);
		List<Wall> wallList = new ArrayList<>();
		for (String wall : walls) {
			String strs[] = wall.split(PROPERTY_SEPARATOR);
			wallList.add(new Wall(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), 
					Integer.parseInt(strs[2]), Integer.parseInt(strs[3])));
		}
		return wallList;
	}
}

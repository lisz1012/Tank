package com.lisz.tank.net;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.UUID;

import com.lisz.tank.Dir;
import com.lisz.tank.Group;
import com.lisz.tank.Tank;

public class TankJoinMessage {
	public static final int SIZE = 33;
	private int x, y;
	private Dir dir;
	private boolean moving;
	private Group group;
	private UUID id;

	public TankJoinMessage(Tank t) {
		x = t.getX();
		y = t.getY();
		dir = t.getDir();
		moving = t.isMoving();
		group = t.getGroup();
		id = t.getId();
	}
	
	public TankJoinMessage(int x, int y, Dir dir, boolean moving, Group group, UUID id) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.moving = moving;
		this.group = group;
		this.id = id;
	}
	
	public TankJoinMessage() {}
	
	// 整个消息转化成字节数组，方便后面的调用.用ByteBuf的各种write方法也可以
	// 但是这样的话就绑定在Netty上了。这里那天不想再用Netty了，方法还可以重用
	// 2008年写的《大富翁》内部的存盘逻辑也是用的下面这两个流
	public byte[] toBytes() {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
			 DataOutputStream dos = new DataOutputStream(baos)){
			dos.writeInt(x);
			dos.writeInt(y);
			dos.writeInt(dir.ordinal()); // 写下标值很方便，在网络传输方便
			dos.writeBoolean(moving); // Boolean类型在网络传输只有一个字节
			dos.writeInt(group.ordinal());
			dos.writeLong(id.getMostSignificantBits());
			dos.writeLong(id.getLeastSignificantBits());
			dos.flush();
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Tank message: " + x + ", " + y;
	}
}

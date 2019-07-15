package com.lisz.tank.net;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;

import com.lisz.tank.Bullet;
import com.lisz.tank.Dir;
import com.lisz.tank.GameFacade;
import com.lisz.tank.Group;

import io.netty.channel.ChannelHandlerContext;

public class BulletCreationMessage extends Message {
	public static final int SIZE = 33;
	public static final MessageType TYPE = MessageType.BULLET_CREATION;

	public BulletCreationMessage(Bullet b){
		x = b.getX();
		y = b.getY();
		dir = b.getDir();
		moving = b.isMoving();
		group = b.getGroup();
		id = b.getId();
	}
	
	public BulletCreationMessage (int x, int y, Dir dir, boolean moving, Group group, UUID id) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.moving = moving;
		this.group = group;
		this.id = id;
	}
	
	public BulletCreationMessage() {}

	@Override
	public MessageType getType() {
		return TYPE;
	}

	@Override
	public int getSize() {
		return SIZE;
	}
	
	@Override
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void handle(ChannelHandlerContext ctx) {
		Bullet bullet = new Bullet(dir, x, y, group);
		GameFacade.getInstance().gameObjects.put(bullet.getId(), bullet);
	}
}

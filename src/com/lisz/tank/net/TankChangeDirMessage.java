package com.lisz.tank.net;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;

import com.lisz.tank.Dir;
import com.lisz.tank.GameFacade;
import com.lisz.tank.Tank;

import io.netty.channel.ChannelHandlerContext;

public class TankChangeDirMessage extends Message {
	public static final MessageType TYPE = MessageType.TANK_CHANGE_DIR;
	
	private UUID id;
	private Dir dir;
	
	public TankChangeDirMessage(UUID id, Dir dir) {
		this.id = id;
		this.dir = dir;
	}
	
	@Override
	public byte[] toBytes() {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
		     DataOutputStream dos = new DataOutputStream(baos)){
			dos.writeLong(id.getMostSignificantBits());
			dos.writeLong(id.getLeastSignificantBits());
			dos.writeInt(dir.ordinal());
			dos.flush();
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MessageType getType() {
		return TYPE;
	}

	// 此时已经在客户端decode了
	@Override
	public void handle(ChannelHandlerContext ctx) {
		Tank t = (Tank)GameFacade.getInstance().gameObjects.get(id);
		t.setDir(dir);
	}

}

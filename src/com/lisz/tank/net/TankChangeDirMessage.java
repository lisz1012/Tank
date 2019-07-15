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
	public static final int SIZE = 20;
	public static final byte TYPE = 4;
	
	private UUID id;
	private Dir dir;
	
	public TankChangeDirMessage(UUID id, Dir dir) {
		this.id = id;
		this.dir = dir;
	}
	
	@Override
	protected byte[] toBytesImpl(ByteArrayOutputStream baos, DataOutputStream dos) throws IOException {
		dos.writeLong(id.getMostSignificantBits());
		dos.writeLong(id.getLeastSignificantBits());
		dos.writeInt(dir.ordinal());
		dos.flush();
		return baos.toByteArray();
	}

	@Override
	public byte getType() {
		return TYPE;
	}

	@Override
	public int getSize() {
		return SIZE;
	}

	// 此时已经在客户端decode了
	@Override
	public void handle(ChannelHandlerContext ctx) {
		Tank t = (Tank)GameFacade.getInstance().gameObjects.get(id);
		t.setDir(dir);
	}

}

package com.lisz.tank.net;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;

import com.lisz.tank.GameFacade;
import com.lisz.tank.Tank;

import io.netty.channel.ChannelHandlerContext;

public class TankMovingMessage extends Message {
	public static final int SIZE = 17;
	public static final MessageType TYPE = MessageType.TANK_MOVING;
	
	private UUID id;
	private boolean moving;
	
	public TankMovingMessage(UUID id, boolean moving) {
		this.id = id;
		this.moving = moving;
	}
	
	@Override
	protected byte[] toBytesImpl(ByteArrayOutputStream baos, DataOutputStream dos) throws IOException {
		dos.writeLong(id.getMostSignificantBits());
		dos.writeLong(id.getLeastSignificantBits());
		dos.writeBoolean(moving);
		dos.flush();
		return baos.toByteArray();
	}

	@Override
	public MessageType getType() {
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
		t.setMoving(moving);
	}

}

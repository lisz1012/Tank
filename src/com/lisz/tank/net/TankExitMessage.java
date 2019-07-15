package com.lisz.tank.net;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;

import com.lisz.tank.GameFacade;

import io.netty.channel.ChannelHandlerContext;

public class TankExitMessage extends Message {
	public static final int SIZE = 16;
	public static final MessageType TYPE = MessageType.TANK_EXIT;
	
	public TankExitMessage(UUID id){
		this.id = id;
	}
	
	@Override
	protected byte[] toBytesImpl(ByteArrayOutputStream baos, DataOutputStream dos) throws IOException {
		dos.writeLong(id.getMostSignificantBits());
		dos.writeLong(id.getLeastSignificantBits());
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

	@Override
	public void handle(ChannelHandlerContext ctx) {
		GameFacade.getInstance().gameObjects.remove(id);
	}

}

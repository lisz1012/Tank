package com.lisz.tank.net;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;

import com.lisz.tank.GameFacade;

import io.netty.channel.ChannelHandlerContext;

public class TankExitMessage extends Message {
	public static final MessageType TYPE = MessageType.TANK_EXIT;
	
	public TankExitMessage(UUID id){
		this.id = id;
	}
	
	@Override
	public byte[] toBytes() {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
			 DataOutputStream dos = new DataOutputStream(baos)){
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
	public MessageType getType() {
		return TYPE;
	}

	@Override
	public void handle(ChannelHandlerContext ctx) {
		GameFacade.getInstance().gameObjects.remove(id);
	}

}

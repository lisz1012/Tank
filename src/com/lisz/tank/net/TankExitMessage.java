package com.lisz.tank.net;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;

public class TankExitMessage extends Message {
	public static final int SIZE = 16;
	public static final byte TYPE = 2;
	
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
	public byte getType() {
		return TYPE;
	}

	@Override
	public int getSize() {
		return SIZE;
	}

}

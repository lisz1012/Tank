package com.lisz.tank.net;

import java.util.List;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class MessageDecoder extends ByteToMessageDecoder {
	private TankJoinMessageDecoder tankJoinMessageDecoder = new TankJoinMessageDecoder();
	private BulletCreationMessageDecoder bulletCreationMessageDecoder = new BulletCreationMessageDecoder();

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		int type = in.readByte();
		switch (type) {
		case TankJoinMessage.TYPE: tankJoinMessageDecoder.decode(ctx, in, out); break;
		case BulletCreationMessage.TYPE: bulletCreationMessageDecoder.decode(ctx, in, out); break;
		default: break;
		}
	}

}

package com.lisz.tank.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MessageEncoder extends MessageToByteEncoder<Message> {
	private MessageEncoder() {}
	
	private static final class Inner {
		private static final MessageEncoder INSTANCE = new MessageEncoder();
	}
	
	public static final MessageEncoder getInstance() {
		return Inner.INSTANCE;
	}

	@Override
	protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
		out.writeBytes(msg.toBytes());
	}

}

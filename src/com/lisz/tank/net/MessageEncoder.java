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
		// 依次写入Type和size，后面client接收到的时候根据type作出反应；而且在size不定的情况下这种写法比Message里面的SIZE常量更灵活
		out.writeInt(msg.getType().ordinal());
		byte[] bytes = msg.toBytes();
		int length = bytes.length;
		out.writeInt(length);
		out.writeBytes(bytes);
	}

}

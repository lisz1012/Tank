package com.lisz.tank.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MessageEncoder extends MessageToByteEncoder<Message> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
		System.out.println("Encoding...");
		System.out.println(out.readableBytes());
		out.writeBytes(msg.toBytes());
		System.out.println(out.readableBytes());
	}

}

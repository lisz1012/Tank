package com.lisz.tank.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class ClientCloseHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf)msg;
		String str = buf.toString(CharsetUtil.UTF_8);
		if (ProtocolMessage.CLOSE.getMessage().equals(str)) {
			System.out.println("A client disconnected");
			ctx.close();
		}
	}
}

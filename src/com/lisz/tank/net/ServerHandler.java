package com.lisz.tank.net;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelMatchers;
import io.netty.util.CharsetUtil;

public class ServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		String str = "This is server, a client just connected to server. Assigning it the ID: " + Server.CLIENTS.size();
		ServerFrame.INSTANCE.updateServerMessage(str);
		//ByteBuf buf = Unpooled.copiedBuffer((Server.CLIENTS.size() + "").getBytes());//有这两句的话会写出去一个49，50.。。因为'1'的ascii码是49
		//ctx.writeAndFlush(buf);
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		/*ByteBuf buf = (ByteBuf)msg;
		String message = buf.toString(CharsetUtil.UTF_8);
		if (ProtocolMessage.CLOSE.getMessage().equals(message)) {
			ServerFrame.INSTANCE.updateServerMessage("A client is disconnecting...");
			cleanUpChannel(ctx);
			return;
		}
		String str = "Server received: " + message;
		ServerFrame.INSTANCE.updateClientMessage(str);*/
		Server.CLIENTS.writeAndFlush(msg, ChannelMatchers.isNot(ctx.channel()));//不要回发给发消息过来的那个client
		//Server.CLIENTS.writeAndFlush(msg);
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		cleanUpChannel(ctx);
	}

	private void cleanUpChannel(ChannelHandlerContext ctx) {
		Server.CLIENTS.remove(ctx.channel());
		ctx.close(); //ctx关闭，里面的Channel也就关闭了
	}
}

package com.lisz.tank.net;

import com.lisz.tank.TankFrame;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class ClientHandler extends ChannelInboundHandlerAdapter {
	private static final ClientHandler INSTANCE = new ClientHandler();
	
	private ClientHandler() {}
	
	public static ClientHandler getInstance() {
		return INSTANCE;
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("Connected...");
		TankJoinMessage message = new TankJoinMessage(TankFrame.tank);
		System.out.println("Sending UUID: " + message.getId());
		ctx.writeAndFlush(message);
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {//ctx代表Channel目前运行的网络环境
		try {
			((Message)msg).handle(ctx);
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
		cause.printStackTrace();
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("Server offline or disconnected.");
		ctx.close();
	}
}

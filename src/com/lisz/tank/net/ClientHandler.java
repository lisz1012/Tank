package com.lisz.tank.net;

import com.lisz.tank.GameFacade;
import com.lisz.tank.Tank;
import com.lisz.tank.TankFrame;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class ClientHandler extends ChannelInboundHandlerAdapter {
	//private ClientFrame cf = ClientFrame.INSTANCE;

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("Connected...");
		TankJoinMessage message = new TankJoinMessage(TankFrame.tank);
		System.out.println("Sending UUID: " + message.getId());
		ctx.writeAndFlush(message);
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {//ctx代表Channel目前运行的网络环境
		if (msg instanceof TankJoinMessage) {
			try {																		
				TankJoinMessage message = (TankJoinMessage)msg;
				Tank tank = new Tank(message.getX(), message.getY(), message.getDir(), message.getGroup());
				tank.setId(message.getId());
				if (!GameFacade.getInstance().gameObjects.contains(tank)) {
					tank.setMoving(message.isMoving());
					GameFacade.getInstance().gameObjects.add(tank);
					System.out.println("New tank: " + tank);
					ctx.writeAndFlush(new TankJoinMessage(TankFrame.tank));
				}
			} finally {
				ReferenceCountUtil.release(msg);
			}
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

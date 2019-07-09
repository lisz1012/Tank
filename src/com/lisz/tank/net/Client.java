package com.lisz.tank.net;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {
	private EventLoopGroup workers = new NioEventLoopGroup(1);
	private ChannelFuture f;// 老马代码里是个Channel,只要跟server的连着，Channel就不会断。如果意外出现断了的话
							// server会收到异常，如果server断了客户端会调用channelInactive Channel和ChannelHandlerContext
							// 都是调用了ChannelInboundInvoker接口下的writeAndFlush方法发送消息
	public void connect() {
		Bootstrap b = new Bootstrap();
		ChannelInitializer<SocketChannel> channelInitializer = new ClientChannelInitializer();
		
		b.group(workers)
		 .channel(NioSocketChannel.class)
		 .handler(channelInitializer);
		try {
			f = b.connect("127.0.0.1", 8888).sync();
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			workers.shutdownGracefully();
		}
	}
	
	public void closeConnection() {
		send("_bye_");
	}
	
	public void send(String msg) {
		if (f == null) {
			return;
		}
		ByteBuf buf = Unpooled.copiedBuffer(msg.getBytes());
		f.channel().writeAndFlush(buf);
	}
	
	public static Client getInstance() {
		return Inner.CLIENT;
	}
	
	private static final class Inner {
		private static final Client CLIENT = new Client();
	}
}

/**
 * Read的时候才会经过ClientHandler，write的时候才会经过TankMessageEncoder
 * TankMessageEncoder是一个ChannelOutboundHandlerAdapter
 */
package com.lisz.tank.net;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {// 如果只有一个Encoder，其他都是decoder则顺序无所谓
		ch.pipeline().addLast(new MessageEncoder()) // Encoder加入客户端的处理链, 把TankMessage转换成ByteBuf。一般来讲编解码器加前面，业务逻辑的处理在最后
					 .addLast(new MessageDecoder())
					 .addLast(new ClientHandler()); // Channel是通道，pipeline是各种Handler的一个责任链，和Channel相关的. Channel相当于Socket必须用它来发消息
	}
}

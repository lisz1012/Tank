/**
 * 自定义协议，消息头里面上来指明类型，int类型的一个数，告诉后面的长度
 * 消息头包括类型和长度，然后是消息体，最后有个校验码。TCP的协议，从不
 * 用字符串传输，http传递的字符串是TCP的封装
 */
package com.lisz.tank.net;

import java.util.List;
import java.util.UUID;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class TankMovingMessageDecoder extends ByteToMessageDecoder {
	private TankMovingMessageDecoder() {}
	
	private static final class Inner {
		private static final TankMovingMessageDecoder INSTANCE = new TankMovingMessageDecoder();
	}

	public static final TankMovingMessageDecoder getInstance() {
		return Inner.INSTANCE;
	}
	
	@Override
	public void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {//decode每个字节过来的时候触发一次
		int size = in.readInt();
		if (in.readableBytes() < size) {
			return;
		}
		UUID id = new UUID(in.readLong(), in.readLong());
		int x = in.readInt();
		int y = in.readInt();
		boolean moving = in.readBoolean();
		TankMovingMessage message = new TankMovingMessage(id, x, y, moving);
		out.add(message);
	}

}

/**
 * 自定义协议，消息头里面上来指明类型，int类型的一个数，告诉后面的长度
 * 消息头包括类型和长度，然后是消息体，最后有个校验码。TCP的协议，从不
 * 用字符串传输，http传递的字符串是TCP的封装
 */
package com.lisz.tank.net;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.List;
import java.util.UUID;

import com.lisz.tank.Dir;
import com.lisz.tank.Group;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class TankJoinMessageDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {//decode每个字节过来的时候触发一次
		if (in.readableBytes() < 33) {
			return;
		}
		//in.markReaderIndex();
		int x = in.readInt();
		int y = in.readInt();
		int ordinal = in.readInt();
		boolean moving = in.readBoolean();
		int groupOrdinal = in.readInt();
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(y));
		System.out.println(Integer.toBinaryString(ordinal));
		System.out.println(Integer.toBinaryString(groupOrdinal));
		Dir dir = Dir.values()[ordinal];
		Group group = Group.values()[groupOrdinal];
		UUID id = new UUID(in.readLong(), in.readLong());
		TankJoinMessage message = new TankJoinMessage(x, y, dir, moving, group, id);
		out.add(message);
	}

}

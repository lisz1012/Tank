/**
 * 对象信息转换成ByteBuf
 */
package com.lisz.tank.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class TankJoinMessageEncoder extends MessageToByteEncoder<TankJoinMessage> {
	// 通过ByteBuf的writeInt，writeLong等方法把msg中的int属性写进ByteBuf
	@Override
	protected void encode(ChannelHandlerContext ctx, TankJoinMessage msg, ByteBuf out) throws Exception {
		
	}

}

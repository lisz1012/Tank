package com.lisz.tank.net;

import java.util.List;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class MessageDecoder extends ByteToMessageDecoder {
	private static final TankJoinMessageDecoder TANK_JOIN_MESSAGE_DECODER = TankJoinMessageDecoder.getInstance();
	private static final BulletCreationMessageDecoder BULLET_CREATION_MESSAGE_DECODER = BulletCreationMessageDecoder.getInstance();
	private static final TankExitMessageDecoder TANK_EXIT_MESSAGE_DECODER = TankExitMessageDecoder.getInstance();
	private static final TankMovingMessageDecoder TANK_MOVING_MESSAGE_DECODER = TankMovingMessageDecoder.getInstance();
	private static final TankChangeDirMessageDecoder TANK_CHANGE_DIR_MESSAGE_DECODER = TankChangeDirMessageDecoder.getInstance();
	
	private MessageDecoder() {}
	
	private static final class Inner {
		private static final MessageDecoder INSTANCE = new MessageDecoder();
	}
	
	public static final MessageDecoder getInstance() {
		return Inner.INSTANCE;
	}
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		int type = in.readByte();
		switch (type) {
		case TankJoinMessage.TYPE: TANK_JOIN_MESSAGE_DECODER.decode(ctx, in, out); break;
		case BulletCreationMessage.TYPE: BULLET_CREATION_MESSAGE_DECODER.decode(ctx, in, out); break;
		case TankExitMessage.TYPE: TANK_EXIT_MESSAGE_DECODER.decode(ctx, in, out); break;
		case TankMovingMessage.TYPE: TANK_MOVING_MESSAGE_DECODER.decode(ctx, in, out); break;
		case TankChangeDirMessage.TYPE: TANK_CHANGE_DIR_MESSAGE_DECODER.decode(ctx, in, out); break;
		default: break;
		}
	}

}

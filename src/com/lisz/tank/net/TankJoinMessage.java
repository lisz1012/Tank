package com.lisz.tank.net;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;

import com.lisz.tank.Dir;
import com.lisz.tank.GameFacade;
import com.lisz.tank.Group;
import com.lisz.tank.Tank;
import com.lisz.tank.TankFrame;

import io.netty.channel.ChannelHandlerContext;

// Also used to report tank status, including position and direction
public class TankJoinMessage extends Message {
	public static final MessageType TYPE = MessageType.TANK_JOIN;
	public static final int SIZE = 33;
	
	public TankJoinMessage(Tank t){
		x = t.getX();
		y = t.getY();
		dir = t.getDir();
		moving = t.isMoving();
		group = t.getGroup();
		id = t.getId();
	}
	
	public TankJoinMessage (int x, int y, Dir dir, boolean moving, Group group, UUID id) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.moving = moving;
		this.group = group;
		this.id = id;
	}
	
	public TankJoinMessage() {}
	
	@Override
	public MessageType getType() {
		return TYPE;
	}
	@Override
	public int getSize() {
		return SIZE;
	}

	@Override
	protected byte[] toBytesImpl(ByteArrayOutputStream baos, DataOutputStream dos) throws IOException{
		dos.writeInt(x);
		dos.writeInt(y);
		dos.writeInt(dir.ordinal()); // 写下标值很方便，在网络传输方便
		dos.writeBoolean(moving); // Boolean类型在网络传输只有一个字节
		dos.writeInt(group.ordinal());
		dos.writeLong(id.getMostSignificantBits());
		dos.writeLong(id.getLeastSignificantBits());
		dos.flush();
		return baos.toByteArray();
	}

	// ClientHandler策略模式移过来的
	@Override
	public void handle(ChannelHandlerContext ctx) {
		Tank tank = new Tank(x, y, dir, group, moving);
		tank.setId(id);
		// 新坦克还没加进自己的gameObjects就加进来并且广播自己的状态，以便新坦克也能知道自己的存在
		if (!GameFacade.getInstance().gameObjects.containsKey(tank.getId())) {
			GameFacade.getInstance().gameObjects.put(tank.getId(), tank);
			System.out.println("New tank: " + tank);
			ctx.writeAndFlush(new TankJoinMessage(TankFrame.tank));
		} else {
			// 已经有了，那就说明这时有可能是有坦克更新状态导致发过来的这条消息，此时存入新的tank，更新
			GameFacade.getInstance().gameObjects.put(tank.getId(), tank);
		}
	}
	
}

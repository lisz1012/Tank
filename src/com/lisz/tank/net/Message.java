package com.lisz.tank.net;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;

import com.lisz.tank.Dir;
import com.lisz.tank.Group;

public abstract class Message {
	protected int x, y;
	protected Dir dir;
	protected boolean moving;
	protected Group group;
	protected UUID id;

	public Message() {}
	
	// 整个消息转化成字节数组，方便后面的调用.用ByteBuf的各种write方法也可以
	// 但是这样的话就绑定在Netty上了。这里那天不想再用Netty了，方法还可以重用
	// 2008年写的《大富翁》内部的存盘逻辑也是用的下面这两个流
	public byte[] toBytes() {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
			 DataOutputStream dos = new DataOutputStream(baos)){
			// 写消息头：类型和之后内容的字节数
			dos.writeByte(getType());
			return toBytesImpl(baos, dos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected abstract byte[] toBytesImpl(ByteArrayOutputStream baos, DataOutputStream dos)  throws IOException;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public abstract byte getType();
	
	public abstract int getSize();
	
	@Override
	public String toString() {
		return "Tank message: " + x + ", " + y;
	}
}

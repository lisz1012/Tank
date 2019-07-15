package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.lisz.tank.Dir;
import com.lisz.tank.Group;
import com.lisz.tank.net.TankJoinMessage;
import com.lisz.tank.net.TankJoinMessageDecoder;
import com.lisz.tank.net.TankJoinMessageEncoder;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;

class TankJoinMessageTest {

	@Test
	void testEncode() {
		EmbeddedChannel ch = new EmbeddedChannel();
		UUID id = UUID.randomUUID();
		TankJoinMessage msg = new TankJoinMessage(5, 10, Dir.UP, true, Group.GOOD, id);
		ch.pipeline().addLast(new TankJoinMessageEncoder());
		ch.writeOutbound(msg);
		ByteBuf buf = ch.readOutbound();
		assertEquals(5, buf.readInt());
		assertEquals(10, buf.readInt());
		assertEquals(1, buf.readInt());
		assertTrue(buf.readBoolean());
		assertEquals(0, buf.readInt());
		UUID uuid = new UUID(buf.readLong(), buf.readLong());
		assertEquals(id, uuid);
	}

	@Test
	void testDecode() {
		/*EmbeddedChannel ch = new EmbeddedChannel();
		UUID id = UUID.randomUUID();
		TankJoinMessage msg = new TankJoinMessage(5, 10, Dir.UP, true, Group.GOOD, id);
		ch.pipeline().addLast(new TankJoinMessageEncoder()).addLast(new TankJoinMessageDecoder());
		ch.writeInbound(msg);
		TankJoinMessage msg2 = ch.readInbound();
		assertEquals(5, msg2.getX());
		assertEquals(10, msg2.getY());
		assertEquals(Dir.UP, msg2.getDir());
		assertTrue(msg2.isMoving());
		assertEquals(Group.GOOD, msg2.getGroup());
		assertEquals(id, msg2.getId());*/
		
		EmbeddedChannel ch = new EmbeddedChannel();
		UUID id = UUID.randomUUID();
		TankJoinMessage msg = new TankJoinMessage(5, 10, Dir.UP, true, Group.GOOD, id);
		ch.pipeline().addLast(TankJoinMessageDecoder.getInstance());
		ByteBuf buf = Unpooled.buffer();
		buf.writeBytes(msg.toBytes());
		ch.writeInbound(buf.duplicate());
		TankJoinMessage msg2 = ch.readInbound();
		assertEquals(5, msg2.getX());
		assertEquals(10, msg2.getY());
		assertEquals(Dir.UP, msg2.getDir());
		assertTrue(msg2.isMoving());
		assertEquals(Group.GOOD, msg2.getGroup());
		assertEquals(id, msg2.getId());
		buf.release();
	}
}

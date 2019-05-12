package com.lisz.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	private static final long serialVersionUID = 1L;
	private GameObject tank = new Tank(200, 200, Dir.UP, this);
	
	
	public TankFrame() {
		setSize(800, 600);
		setResizable(false);
		setTitle("Tank War");
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		addKeyListener(new MyKeyListener());
	}
	
	@Override
	public void paint(Graphics g) {
		tank.paint(g);
	}
	
	private class MyKeyListener extends KeyAdapter {
		private boolean bL = false;
		private boolean bU = false;
		private boolean bR = false;
		private boolean bD = false;
		
		@Override
		public void keyPressed(KeyEvent e) {
			setDirKeyPressedStatus(e, true);
			Dir dir = calculateDir();
			tank.setDir(dir);
			tank.move();
		}

		private Dir calculateDir() {
			Dir dir = tank.getDir();
			if (bD && !bU && !bR && !bL) {
				dir = Dir.DOWN;
			} else if (!bD && bU && !bR && !bL) {
				dir = Dir.UP;
			} else if (!bD && !bU && bR && !bL) {
				dir = Dir.RIGHT;
			} else if (!bD && !bU && !bR && bL) {
				dir = Dir.LEFT;
			} else if (!bD && bU && !bR && bL) {
				dir = Dir.LEFT_UP;
			} else if (!bD && bU && bR && !bL) {
				dir = Dir.RIGHT_UP;
			} else if (bD && !bU && bR && !bL) {
				dir = Dir.RIGHT_DOWN;
			} else if (bD && !bU && !bR && bL) {
				dir = Dir.LEFT_DOWN;
			} 
			return dir;
		}

		@Override
		public void keyReleased(KeyEvent e) {
			setDirKeyPressedStatus(e, false);
			Dir dir = calculateDir();
			tank.setDir(dir);
		}
		
		private void setDirKeyPressedStatus(KeyEvent e, boolean keyPressed) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP: bU = keyPressed; break;
			case KeyEvent.VK_DOWN: bD = keyPressed; break;
			case KeyEvent.VK_LEFT: bL = keyPressed; break;
			case KeyEvent.VK_RIGHT: bR = keyPressed; break;
			}
			boolean dirKeyPressed = bU || bL || bR || bD;
			tank.setMoving(dirKeyPressed);
		}
	}
}

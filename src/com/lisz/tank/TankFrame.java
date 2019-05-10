package com.lisz.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	
	int x = 200;
	int y = 200;

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
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(new Color(0, 0, 0));
		g.fillRect(x, y, 50, 50);
	}
	
	private class MyKeyListener extends KeyAdapter {
		
		private boolean bL = false;
		private boolean bU = false;
		private boolean bR = false;
		private boolean bD = false;
		
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP: bU = true; break;
			case KeyEvent.VK_DOWN: bD = true; break;
			case KeyEvent.VK_LEFT: bL = true; break;
			case KeyEvent.VK_RIGHT: bR = true; break;
			default:
				break;
			}
			if (bD && !bU && !bR && !bL) {
				y += 10;
			} else if (!bD && bU && !bR && !bL) {
				y -= 10;
			} else if (!bD && !bU && bR && !bL) {
				x += 10;
			} else if (!bD && !bU && !bR && bL) {
				x -= 10;
			} else if (!bD && bU && !bR && bL) {
				x -= 10;
				y -= 10;
			} else if (!bD && bU && bR && !bL) {
				x += 10;
				y -= 10;
			} else if (bD && !bU && bR && !bL) {
				x += 10;
				y += 10;
			} else if (bD && !bU && !bR && bL) {
				x -= 10;
				y += 10;
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP: bU = false; break;
			case KeyEvent.VK_DOWN: bD = false; break;
			case KeyEvent.VK_LEFT: bL = false; break;
			case KeyEvent.VK_RIGHT: bR = false; break;
			default:
				break;
			}
		}
	}
}

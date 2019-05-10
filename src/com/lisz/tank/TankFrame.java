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
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP: y -= 10; break;
			case KeyEvent.VK_DOWN: y += 10; break;
			case KeyEvent.VK_LEFT: x -= 10; break;
			case KeyEvent.VK_RIGHT: x += 10; break;
			default:
				break;
			}
			paint(getGraphics());
		}
	}
}

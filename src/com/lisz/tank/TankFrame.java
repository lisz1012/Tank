package com.lisz.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	private static final long serialVersionUID = 1L;
	private GameObject tank = new Tank();
	
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
		g.fillRect(tank.getX(), tank.getY(), 50, 50);
	}
	
	private class MyKeyListener extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP: tank.setbU(true); break;
			case KeyEvent.VK_DOWN: tank.setbD(true); break;
			case KeyEvent.VK_LEFT: tank.setbL(true); break;
			case KeyEvent.VK_RIGHT: tank.setbR(true); break;
			}
			
			tank.setMainTankDir();
			tank.move();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP: tank.setbU(false); break;
			case KeyEvent.VK_DOWN: tank.setbD(false); break;
			case KeyEvent.VK_LEFT: tank.setbL(false); break;
			case KeyEvent.VK_RIGHT: tank.setbR(false); break;
			}
			
			tank.setMainTankDir();
		}
	}
}

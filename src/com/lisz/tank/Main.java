package com.lisz.tank;

public class Main {
	public static void main(String[] args) {
		TankFrame tf = new TankFrame();
		while (true) {
			tf.repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

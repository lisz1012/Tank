package com.lisz.tank;

public interface GameObject {
	void move();
	void setMainTankDir();
	public int getX();
	public int getY();
	public void setbL(boolean bL);
	public void setbU(boolean bU);
	public void setbR(boolean bR);
	public void setbD(boolean bD);
}

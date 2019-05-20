package com.lisz.tank;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class ImageUtil {
	public static BufferedImage rotateImage(final BufferedImage bufferedImage, int degrees) {
		int w = bufferedImage.getWidth();
		int h = bufferedImage.getHeight();
		int type = bufferedImage.getColorModel().getTransparency();
		BufferedImage img;
		Graphics2D graphics2d;
		(graphics2d = (img = new BufferedImage(w, h, type)).createGraphics()).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics2d.rotate(Math.toRadians(degrees), w / 2, h / 2);
		graphics2d.drawImage(bufferedImage, 0, 0, null);
		graphics2d.dispose();
		return img;
	}
}

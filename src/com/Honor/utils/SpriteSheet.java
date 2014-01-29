/**
 * 
 */
package com.Honor.utils;

import java.awt.image.BufferedImage;

/**
 * @author Valentine
 *
 */
public class SpriteSheet 
{
	
	private BufferedImage image; 														// this is the entire spritesheet image
	private int width; 																	// its entire size
	private int height;
	
	public SpriteSheet(BufferedImage image, int width)
	{
		this.image = image;
		this.width = width;
		this.height = width; 															// just for the spritesheet blocks are squared
	}
	
	public SpriteSheet(BufferedImage image, int width, int height)
	{
		this.image = image;
		this.width = width;
		this.height = height; 															// for any other size of images
	}
	
	// get the single image from the spritesheet as a subimage
	public BufferedImage getSprite(int col, int row)
	{
		return image.getSubimage((col * width) - width, (row * height) - height, width, height);
	}

}

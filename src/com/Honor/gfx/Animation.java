
package com.Honor.gfx;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


/**
 * @author Valentine
 *
 */

public class Animation 
{
	private int count = 0;
	private int index = 0;
	private int speed;
	private int frames;
	
	private BufferedImage currentImage;
	private BufferedImage anime[];
	
	public Animation(int speed, BufferedImage anime[])
	{
		this.speed = speed;
		this.anime = anime;
		frames = anime.length;
	}
	
	public void runAnimation()
	{
		index++;
		if(index > speed)
		{
			index = 0;
			nextFrame();
		}
	}
	
	public void nextFrame()
	{
		for(int i = 0; i < frames; i++)
		{
			if(count == i)
			{
				currentImage = anime[i];
			}
		}
		
		count++;
		
		if(count > frames)
		{
			count = 0;
		}
		
	}
	
	public void drawAnimation(Graphics g, float x, float y)
	{
		g.drawImage(currentImage, (int)x, (int)y, null);
	}

}








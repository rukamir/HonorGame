/**
 * 
 */
package com.Honor.utils;

import java.io.IOException;

import com.Honor.libs.Audio;
import com.Honor.libs.Fonts;
import com.Honor.libs.Images;
//import com.Honor.libs.Reference;

/**
 * @author Valentine
 *
 */
public class ResourceLoader {

	private static BufferedImageLoader imageLoader = new BufferedImageLoader();
	
	public static void loadImages()
	{
		try
		{
			Images.mainBackground = imageLoader.loadImage("main.png");
			Images.secondBackground = imageLoader.loadImage("second.png");
			Images.star = imageLoader.loadImage("star.png");
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void loadFonts()
	{
		Fonts.addFont(new Fonts("Angelina.TTF"));
	}
	
	public static void loadSounds()
	{
		AudioPlayer.addSound(Audio.BUTTON, "button.wav");
		AudioPlayer.addSound(Audio.BACKGROUND,  "background.wav");
	}

}

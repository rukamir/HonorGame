/**
 * 
 */
package com.Honor.utils;

import java.util.HashMap;
import java.util.Map;

//import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import com.Honor.libs.Reference;

/**
 * @author Valentine
 *
 */
public class AudioPlayer {
	
	// sound for effects
	private static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	
	public static void addSound(String key, String path)
	{
		try
		{
			soundMap.put(key, new Sound(Reference.SOUND_LOCATION + path));
		}
		catch(SlickException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Sound getSound(String key)
	{
		return soundMap.get(key);
	}

	public static void playSound(String key)
	{
		soundMap.get(key).play();
	}

}

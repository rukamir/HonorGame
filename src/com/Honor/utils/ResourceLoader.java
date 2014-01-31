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
 * updated by Nick
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
			
			// the entire spritesheet 
			Images.spriteSheet_1 = imageLoader.loadImage("ground.png");  // populate decorations
			Images.spriteSheet_2 = imageLoader.loadImage("Wilster.png");   // player
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
		AudioPlayer.addSound(Audio.COIN, "coin.wav");
		AudioPlayer.addSound(Audio.FIREBALL,  "fireball.wav");
		AudioPlayer.addSound(Audio.JUMP, "jump.wav");
		AudioPlayer.addSound(Audio.KICK,  "kick.wav");
		AudioPlayer.addSound(Audio.NEWLIFE, "newlife.wav");
		AudioPlayer.addSound(Audio.POWERDOWN,  "powerdown.wav");
		AudioPlayer.addSound(Audio.POWERUP, "powerup.wav");
		AudioPlayer.addSound(Audio.CHECKPOINT,  "SFX_Checkpoint.wav");
		AudioPlayer.addSound(Audio.THUD, "SFX_THUD.wav");
		AudioPlayer.addSound(Audio.WIND,  "AMB_HeavyWind.wav");
		AudioPlayer.addSound(Audio.SWIMUP, "SFX_SwimUp.wav");
		AudioPlayer.addSound(Audio.SWIMDOWN,  "SFX_SwimDown.wav");
		AudioPlayer.addSound(Audio.ENEMY_DIE, "SFX_EnemyDie.wav");
		AudioPlayer.addSound(Audio.LEVER,  "SFX_Lever.wav");
		AudioPlayer.addSound(Audio.MARIO_DIE, "SFX_MarioDie.wav");
		AudioPlayer.addSound(Audio.END_LEVEL,  "SFX_EndLevel.wav");

		
	}

}

/**
 * @author Valentine
 *
 */

package com.Honor.Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.Honor.Game;
import com.Honor.input.MouseInput;
import com.Honor.libs.Audio;
import com.Honor.libs.Images;
//import com.Honor.libs.Reference;
import com.Honor.utils.AudioPlayer;


public class Menu 
{
	public Rectangle play, options, credits, info, quit;
	public Menu() 
	{
		int fillerY = Game.HEIGHT - 100;
		play    = new Rectangle(100, fillerY, 125, 50);
		options = new Rectangle(300, fillerY, 200, 50);
		credits = new Rectangle(595, fillerY, 200, 50);
		info    = new Rectangle(900, fillerY, 125, 50);
		quit    = new Rectangle(1200, fillerY, 125, 50);
		
	}
	
	public void drawButton(Graphics g, Rectangle rect, String text, int offsetX)
	{
		Font Angelina = new Font("Angelina", Font.BOLD, 56);
		Font Angelina68 = new Font("Angelina", Font.BOLD, 74);
		g.setFont(Angelina);
		
		if(MouseInput.MOUSE.intersects(rect) && MouseInput.MOUSE != null)
		{
			g.setColor(Color.WHITE);
			g.setFont(Angelina68);
			AudioPlayer.getSound(Audio.BUTTON).play();
		}
		else
		{
			g.setColor(new Color(112, 0, 0));
		}
		
		//g.drawRect(rect.x, rect.y, rect.width, rect.height);
		g.drawString(text, rect.x + offsetX, rect.y + 40);
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.PINK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(Images.mainBackground, 0, 0, null);
		g.drawImage(Images.star, 1000, 500, null);
		
		drawButton(g, play, "PLAY", 0);
		drawButton(g, options, "OPTIONS", 0);
		drawButton(g, credits, "CREDITS", 0);
		drawButton(g, info, "INFO", 0);
		drawButton(g, quit, "QUIT", 0);
	}

}


package com.Honor.Screens;

/**
 * @author Valentine
 *
 */

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


public class Options 
{ 
	public Rectangle back;
	public Options() 
	{
		int fillerY = Game.HEIGHT - 100;
		back    = new Rectangle((Game.WIDTH - 500) / 2, fillerY, 500, 50);
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
		
		g.drawString(text, rect.x + offsetX, rect.y + 40);
	}

	public void render(Graphics g)
	{
		g.drawImage(Images.secondBackground, 0, 0, null);
		drawButton(g, back, "BACK TO MAIN MENU", 0);
		
		Font Angelina = new Font("Angelina", Font.BOLD, 50);
		g.setFont(Angelina);
		g.setColor(new Color(112, 0, 0));
		g.drawString("Left Arrow  /  Move left", 500, 350);
		g.drawString("Right Arrow /  Move right", 500, 450);
		g.drawString("Space Bar   /   Jump", 500, 550);
		g.drawString("Escape       /   Quit game", 500, 650);
	}
}






















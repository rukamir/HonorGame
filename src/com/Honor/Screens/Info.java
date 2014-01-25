/**
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
import com.Honor.utils.AudioPlayer;

/**
 * @author Valentine
 *
 */
public class Info 
{
	public Rectangle back;
	public Info() 
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
		g.drawString("Are you ready to start your adventure? Just move around,", 300, 350);
		g.drawString("jump on the heights, manage the platforms well and have",300, 390);
		g.drawString("fun!",300, 430);
		g.drawString("Go get some points! In our game the player will be",300, 470);
		g.drawString("traversing threw a world filled with puzzles and enemies.", 300, 510);
		g.drawString("Both puzzles and the enemies should be solvable/beatable ", 300, 550);
		g.drawString("by even the casual gamer.", 300, 590);
		g.drawString("Even though the game is causal it will also be enjoyable to ", 300, 630);
		g.drawString("the veteran player.", 300, 670);
	}
}



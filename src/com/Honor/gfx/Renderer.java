/**
 * @author Valentine
 *
 */

package com.Honor.gfx;
import java.awt.Color;
import java.awt.Graphics;

import com.Honor.Game;



public class Renderer 
{
	public void renderBackground(Graphics g)
	{
		switch(Game.state)
		{
		case MENU:
			Game.getInstance().menu.render(g);
			break;
		case GAME:
			break;
		case OPTIONS:
			Game.getInstance().options.render(g);
			break;
		case CREDITS:
			Game.getInstance().credits.render(g);
			break;
		case INFO:
			Game.getInstance().info.render(g);
			break;
		case QUIT:
			Game.getInstance().quit.render(g);
			break;
		default:
			g.setColor(Color.RED);
			g.drawString("if is empty!", 150, 150);
			break;
		}
	}
	public void renderForeground(Graphics g)
	{
		switch(Game.state)
		{
		case MENU:
			break;
		case GAME:
			Game.getInstance().getController().render(g); // render all the objects added to the controller
			break;
		case OPTIONS:
			break;
		case CREDITS:
			break;
		case INFO:
			break;
		case QUIT:
			break;
		default:
			break;
		}
	}
}

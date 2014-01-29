
package com.Honor.input;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.Honor.Game;
import com.Honor.enums.GameState;
import com.Honor.libs.Audio;
import com.Honor.utils.AudioPlayer;

/**
 * @author Valentine
 *
 */


public class MouseInput extends MouseAdapter
{
	public static int MOUSE_X, MOUSE_Y;
	public static Rectangle MOUSE = new Rectangle(1, 1, 1, 1);
		
	public void mouseClicked(MouseEvent e)
	{
		int mouse = e.getButton();
		Rectangle rect = new Rectangle(e.getX(), e.getY(), 1, 1);
		
		if (mouse == MouseEvent.BUTTON1)
		{
			switch(Game.state)
			{
			case MENU:
				if(rect.intersects(Game.getInstance().menu.play))
				{
					AudioPlayer.getSound(Audio.BACKGROUND).stop();			// muta asta in o noua clasa rungame.java
					Game.state = GameState.GAME; 							// this is where the game actually run
				}
				else if(rect.intersects(Game.getInstance().menu.options))
				{
					Game.state = GameState.OPTIONS;
				}
				else if(rect.intersects(Game.getInstance().menu.credits))
				{
					Game.state = GameState.CREDITS;
				}
				else if(rect.intersects(Game.getInstance().menu.info))
				{
					Game.state = GameState.INFO;
				}
				else if(rect.intersects(Game.getInstance().menu.quit))
				{
					Game.exit();
				}
				break;
			case GAME:
				break;
			case OPTIONS:
				if(rect.intersects(Game.getInstance().options.back))
				{
					Game.state = GameState.MENU;
				}
				break;
			case CREDITS:
				if(rect.intersects(Game.getInstance().credits.back))
				{
					Game.state = GameState.MENU;
				}
				break;
			case INFO:
				if(rect.intersects(Game.getInstance().info.back))
				{
					Game.state = GameState.MENU;
				}
				break;
			case QUIT:
				if(rect.intersects(Game.getInstance().quit.back))
				{
					AudioPlayer.getSound(Audio.BACKGROUND).play();
					Game.state = GameState.MENU;
				}
				else if(rect.intersects(Game.getInstance().quit.quit))
				{
					Game.exit(); 
				}
				break;
			default:
				break;
			}
		}
	}

	public void mouseMoved(MouseEvent e)
	{
		MOUSE_X = e.getX();
		MOUSE_Y = e.getY();
		MOUSE = new Rectangle(MOUSE_X, MOUSE_Y, 1, 1);
	}
}

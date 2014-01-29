/**
 * 
 */
package com.Honor.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.Honor.Controller;
import com.Honor.Game;
import com.Honor.entity.Player;
import com.Honor.enums.GameState;
import com.Honor.libs.Identities;

/**
 * @author Valentine
 *
 */

public class KeyInput extends KeyAdapter
{
	private static int speed = 5;
	private static int Vspeed = -23;
	
	private Player player;
	
	private boolean[] keyDown = new boolean[2];
	
	public KeyInput()
	{
		for(int k = 0; k < Controller.getObjects().size(); k++)
		{
			if(Controller.getObjects().get(k).getId() == Identities.PLAYER)
				player = (Player) Controller.getObjects().get(k);
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		switch(Game.state)
		{
		case GAME:
			if(key == KeyEvent.VK_LEFT)
			{
				player.setVelX(-speed);
				player.setMovingLeft(true);
				keyDown[0] = true;
			}
			if(key == KeyEvent.VK_RIGHT)
			{
				player.setVelX(speed);
				player.setMovingRight(true);
				keyDown[1] = true;
			}
			if(key == KeyEvent.VK_UP)
			{
				player.setVelY(-speed);
			}
			if(key == KeyEvent.VK_SPACE && !player.isJumping())
			{
				player.setVelY(Vspeed);
				player.setJumping(true);
			}
			if(key == KeyEvent.VK_ESCAPE)
			{
				Game.state = GameState.QUIT;
			}
			break;
		default:
			break;
		}
	}
	
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		switch(Game.state)
		{
		case GAME:
			if(key == KeyEvent.VK_LEFT)
			{
				keyDown[0] = false;
				player.setMovingLeft(false);
			}
			if(key == KeyEvent.VK_RIGHT)
			{
				keyDown[1] = false;
				player.setMovingRight(false);
			}
			if(key == KeyEvent.VK_UP)
			{
				player.setVelY(0);
			}
			if(keyDown[0] && !keyDown[1])
				player.setVelX(-speed);
			if(!keyDown[0] && keyDown[1])
				player.setVelX(speed);
			if(!keyDown[0] && !keyDown[1])
				player.setVelX(0);
			break;
		default:
			break;
		}
	}
}
	
	
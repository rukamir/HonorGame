
package com.Honor.entity;

import java.awt.Graphics;
import java.util.ArrayList;

import com.Honor.Controller;
import com.Honor.Objects.Block;
import com.Honor.core.CoreObject;
import com.Honor.gfx.Animation;
import com.Honor.gfx.Textures;

/**
 * @author Valentine
 *
 */

public class Player extends CoreObject 
{	
	private static ArrayList<CoreObject> blocks = Controller.getObjects();
	private int gravity = 1;
	private boolean falling = true;
	private boolean jumping = false;
	private boolean movingRight = false;
	private boolean movingLeft = false;
	private Animation animeRight;
	private Animation animeLeft;
	
	public Player(int x, int y, int id, Textures tex)
	{
		super(x, y, id, tex);
		this.setSize(64, 104);  // the player size
		animeRight = new Animation(3, tex.playerRight);
		animeLeft = new Animation(3, tex.playerLeft);
	}

	@Override
	public void tick() 
	{
		x += velX;
		y += velY;
		
		fall();
		checkCollision();
		if(movingRight)
			animeRight.runAnimation();
		if(movingLeft)
			animeLeft.runAnimation();
		
	}

	@Override
	public void render(Graphics g) 
	{
		if(movingRight)
			animeRight.drawAnimation(g, x, y);
		else if(movingLeft)
			animeLeft.drawAnimation(g, x, y);
		else
			g.drawImage(tex.playerSR, (int)x, (int)y, null);		
	}
	
	// this is for checking collisions
	private void checkCollision()
	{
		for(CoreObject obj : blocks)
		{
			if(obj instanceof Block)
			{
				if(getBottomBounds().intersects(obj.getTopBounds()))
				{
					velY = 0;
					y = obj.getY() - height;
					jumping = false;
				}
				if(getTopBounds().intersects(obj.getBottomBounds()))
				{
					fall(); // buggy ???
					y = obj.getY() + obj.getHeight();
				}
				if(getRightBounds().intersects(obj.getLeftBounds()))
				{
					velX = 0;
					x = obj.getX() - width;
				}
				if(getLeftBounds().intersects(obj.getRightBounds()))
				{
					velX = 0;
					x = obj.getX() + obj.getWidth();
				}
			}
		}
	}
	
	public void fall()
	{
		if(falling)
			velY += gravity;
	}

	/**
	 * @return true if the player is jumping
	 */
	
	public boolean isJumping() 
	{
		return jumping;
	}

	/**
	 * @param jumping the jumping to set
	 */
	
	public void setJumping(boolean jumping) 
	{
		this.jumping = jumping;
	}

	/**
	 * @param moving the moving to set
	 */
	
	public void setMovingRight(boolean movingRight) 
	{
		this.movingRight = movingRight;
	}
	
	public void setMovingLeft(boolean movingLeft) 
	{
		this.movingLeft = movingLeft;
	}
}






package com.Honor.core;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.Honor.gfx.Textures;

/**
 * @author Valentine
 *
 */
// make extended from here

public abstract class CoreObject 
{
	
	protected int x, y, velX, velY;								// position and velocity of the object on screen
	protected int id;											// object id used to obtain the object in an array
	protected int width;
	protected int height; // this is by default unless specified (overwritted)
	protected Textures tex;
	
	public CoreObject(int x, int y, int id, Textures tex)		// create a new object
	{
		this.x = x;
		this.y = y;
		this.id = id;
		this.tex = tex;
	}
	
	public abstract void tick();								// update the object position 
	public abstract void render(Graphics g); // render the object on screen
	
	// upper bounds of the object
	public Rectangle getTopBounds()
	{
		return new Rectangle(x, y, width, 12); // buggy ??
	}
	
	// lower bounds of the object
	public Rectangle getBottomBounds()
	{
		return new Rectangle(x, y + (height - 6), width, 12); // buggy ?? < 12
	}
	
	public Rectangle getRightBounds()
	{
		return new Rectangle(x + (width - 6), y, 6, height);
	}

	public Rectangle getLeftBounds()
	{
		return new Rectangle(x, y, 6, height);
	}
	
	public int getX() 
	{
		return x;
	}

	public void setX(int x) 
	{
		this.x = x;
	}

	public int getY() 
	{
		return y;
	}

	public void setY(int y) 
	{
		this.y = y;
	}

	public long getId() 
	{
		return id;
	}

	public void setVelX(int velX) 
	{
		this.velX = velX;
	}

	public void setVelY(int velY) 
	{
		this.velY = velY;
	}

	/**
	 * @return the width
	 */
	
	public int getWidth() 
	{
		return width;
	}

	/**
	 * @param width the width to set
	 */
	
	public void setWidth(int width) 
	{
		this.width = width;
	}

	/**
	 * @return the height
	 */
	
	public int getHeight() 
	{
		return height;
	}

	/**
	 * @param height the height to set
	 */
	
	public void setHeight(int height) 
	{
		this.height = height;
	}
	
	public void setSize(int width, int height) 
	{
		this.width = width;
		this.height = height;
	}
	

}

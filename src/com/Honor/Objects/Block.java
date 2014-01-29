
package com.Honor.Objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.Honor.core.CoreObject;
import com.Honor.gfx.Textures;

/**
 * @author Valentine
 *
 */

public class Block extends CoreObject
{
	private BufferedImage image;
	
	public Block(int x, int y, int id, Textures tex, BufferedImage image) 
	{
		super(x, y, id, tex);
		this.image = image;
		this.setSize(52, 52);
	}

	@Override
	public void tick() 
	{
		
	}

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(image, x, y, null);
	}
	

}

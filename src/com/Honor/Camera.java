
package com.Honor;

import com.Honor.core.CoreObject;
import com.Honor.entity.Player;
import com.Honor.libs.Identities;

/**
 * @author Valentine
 *
 */

public class Camera 
{
	private float x, y;
	private Player player;
	
	public Camera(float x, float y)
	{
		this.x = x;
		this.y = y;
		
		for(CoreObject obj : Game.getInstance().getController().getObjects())
		{
			if(obj.getId() == Identities.PLAYER)
			{
				player = (Player) obj;
			}
		}
	}
	
	public void tick()
	{
		x = -player.getX() + Game.WIDTH / 2; // player set in center of the screen
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}

}












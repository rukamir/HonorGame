/**
 * 
 */
package com.Honor.gfx;

import java.awt.image.BufferedImage;

import com.Honor.libs.Images;
import com.Honor.utils.SpriteSheet;

/**
 * @author Valentine
 *
 */

public class Textures 
{
	
	private SpriteSheet spriteSheet_1;
	private SpriteSheet spriteSheet_2;
	
	// game objects as a subimages from the spritesheet
	public BufferedImage ground; // stone one 
	public BufferedImage brick; // brown one 
	
	// player 
	public BufferedImage playerSR; // standing
	public BufferedImage playerSL; // standing
	public BufferedImage playerRight[] = new BufferedImage[24];
	public BufferedImage playerLeft[] = new BufferedImage[24];
	
	
	// load spritesheet first into constructor
	public Textures()
	{
		spriteSheet_1 = new SpriteSheet(Images.spriteSheet_1, 52); // 52 is the size of subimage cell
		spriteSheet_2 = new SpriteSheet(Images.spriteSheet_2, 64, 104); // player sheet
		initTextures();
	}
	
	private void initTextures()
	{
		ground = spriteSheet_1.getSprite(1, 4); // initialize the subimage from ground.png as a ground
		brick = spriteSheet_1.getSprite(2, 2); // initialize the subimage from ground.png as a brick
		
		playerSR = spriteSheet_2.getSprite(5, 1); // standing 
		playerSL = spriteSheet_2.getSprite(9, 3); // standing
		
		playerRight[0] = spriteSheet_2.getSprite(6, 1); // animation right
		playerRight[1] = spriteSheet_2.getSprite(7, 1);
		playerRight[2] = spriteSheet_2.getSprite(8, 1);
		playerRight[3] = spriteSheet_2.getSprite(9, 1);
		playerRight[4] = spriteSheet_2.getSprite(10, 1);
		playerRight[5] = spriteSheet_2.getSprite(11, 1);
		playerRight[6] = spriteSheet_2.getSprite(12, 1);
		playerRight[7] = spriteSheet_2.getSprite(1, 2);
		playerRight[8] = spriteSheet_2.getSprite(2, 2);
		playerRight[9] = spriteSheet_2.getSprite(3, 2);
		playerRight[10] = spriteSheet_2.getSprite(4, 2);
		playerRight[11] = spriteSheet_2.getSprite(5, 2);
		playerRight[12] = spriteSheet_2.getSprite(6, 2);
		playerRight[13] = spriteSheet_2.getSprite(7, 2);
		playerRight[14] = spriteSheet_2.getSprite(8, 2);
		playerRight[15] = spriteSheet_2.getSprite(9, 2);
		playerRight[16] = spriteSheet_2.getSprite(10, 2);
		playerRight[17] = spriteSheet_2.getSprite(11, 2);
		playerRight[18] = spriteSheet_2.getSprite(12, 2);
		playerRight[19] = spriteSheet_2.getSprite(1, 1);
		playerRight[20] = spriteSheet_2.getSprite(2, 1);
		playerRight[21] = spriteSheet_2.getSprite(3, 1);
		playerRight[22] = spriteSheet_2.getSprite(4, 1);
		playerRight[23] = spriteSheet_2.getSprite(5, 1);
		
		playerLeft[0] = spriteSheet_2.getSprite(8, 3); // animation left
		playerLeft[1] = spriteSheet_2.getSprite(7, 3);
		playerLeft[2] = spriteSheet_2.getSprite(6, 3);
		playerLeft[3] = spriteSheet_2.getSprite(5, 3);
		playerLeft[4] = spriteSheet_2.getSprite(4, 3);
		playerLeft[5] = spriteSheet_2.getSprite(3, 3);
		playerLeft[6] = spriteSheet_2.getSprite(2, 3);
		playerLeft[7] = spriteSheet_2.getSprite(1, 3);
		playerLeft[8] = spriteSheet_2.getSprite(12, 4);
		playerLeft[9] = spriteSheet_2.getSprite(11, 4);
		playerLeft[10] = spriteSheet_2.getSprite(10, 4);
		playerLeft[11] = spriteSheet_2.getSprite(9, 4);
		playerLeft[12] = spriteSheet_2.getSprite(8, 4);
		playerLeft[13] = spriteSheet_2.getSprite(7, 4);
		playerLeft[14] = spriteSheet_2.getSprite(6, 4);
		playerLeft[15] = spriteSheet_2.getSprite(5, 4);
		playerLeft[16] = spriteSheet_2.getSprite(4, 4);
		playerLeft[17] = spriteSheet_2.getSprite(3, 4);
		playerLeft[18] = spriteSheet_2.getSprite(2, 4);
		playerLeft[19] = spriteSheet_2.getSprite(1, 4);
		playerLeft[20] = spriteSheet_2.getSprite(12, 3);
		playerLeft[21] = spriteSheet_2.getSprite(11, 3);
		playerLeft[22] = spriteSheet_2.getSprite(10, 3);
		playerLeft[23] = spriteSheet_2.getSprite(9, 3);
	}

}

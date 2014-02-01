/**
 * @author Valentine
 *
 */

package com.Honor;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import org.lwjgl.openal.AL;

import com.Honor.Objects.Block;
import com.Honor.Screens.Credits;
import com.Honor.Screens.Info;
import com.Honor.Screens.Menu;
import com.Honor.Screens.Options;
import com.Honor.Screens.Quit;
import com.Honor.entity.Player;
import com.Honor.enums.GameState;
import com.Honor.gfx.Renderer;
import com.Honor.gfx.Textures;
import com.Honor.input.KeyInput;
import com.Honor.input.MouseInput;
import com.Honor.libs.Audio;
import com.Honor.libs.Identities;
import com.Honor.libs.Reference;
import com.Honor.utils.AudioPlayer;
import com.Honor.utils.ResourceLoader;

public class Game extends Canvas implements Runnable 
{
	private static final long serialVersionUID = 1L;
	private static JFrame frame = new JFrame(); // the window object
	public static final String TITLE = "HONOR";
	public static final int WIDTH = 1440;
	public static final int HEIGHT = 900;
	
	public static Game game = new Game();
	public static GameState state = GameState.MENU;  // change this if you want to work on spec level skipping menu system
	
	private boolean running = false;
	private Thread thread;
	private Renderer gfx;
	private Camera camera;
	public Menu menu; // menu object
	public Options options;
	public Credits credits;
	public Info info;
	public Quit quit;
	
	private Controller controller = new Controller(); // control all of our objects
	
	private Textures tex;
	
	
	public static Game getInstance() 
	{
		return game;
	}
	
	public Controller getController()
	{
		return controller;
	}
	public void init() 
	{
		ResourceLoader.loadImages(); // load images and sprites
		ResourceLoader.loadFonts(); // load fonts
		ResourceLoader.loadSounds(); // load sounds
		tex = new Textures();
		AudioPlayer.getSound(Audio.BACKGROUND).loop(1, 1);
		
		menu = new Menu();
		options = new Options();
		credits = new Credits();
		info = new Info();
		quit = new Quit();
		gfx = new Renderer(); // initialize our renderer
		
		MouseInput mouse = new MouseInput();
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		
		//*********************************
		//          level notes
		//*********************************
		// -Square sprites are 50pxl big
		// -HEIGHT is the top of the screen
		//*********************************
		
		// this is the tiles population on the level
		for(int i = 0; i < 1440; i++)
		{
			// using the Controller
			// addObject using
			// 		X val
			//		height/y val
			//		object type
			//		pass tex
			//		get the texture you want to use from tex
			Controller.addObject(new Block(i, HEIGHT - 76, Identities.BLOCK_GROUND, tex, tex.ground)); //  draw the bottom ground
			// move forward 49pxl so textures are not overlapping
			i += 49;
		}
		for(int i = 100; i < 600; i++)
		{
			Controller.addObject(new Block(i, HEIGHT - 600, Identities.BLOCK_BRICK, tex, tex.brick));  // populate teh level with items
			i += 49;
		}
		for(int i = 600; i < 1200; i++)
		{
			Controller.addObject(new Block(i, HEIGHT - 400, Identities.BLOCK_BRICK, tex, tex.brick));
			i += 49;
		}
		for(int i = 0; i < 300; i++)
		{
			Controller.addObject(new Block(i, HEIGHT - 200, Identities.BLOCK_BRICK, tex, tex.brick));
			i += 49;
		}
		for(int i = 1300; i < 1440; i++)
		{
			Controller.addObject(new Block(i, HEIGHT - 200, Identities.BLOCK_BRICK, tex, tex.brick));
			i += 49;
		}
		// 1440 is the end of this part of the scene
		
		
		//*************
		// new section
		//*************
		for(int i = 1440; i < 2440; i++)
		{
			Controller.addObject(new Block(i, HEIGHT - 200, Identities.BLOCK_GROUND, tex, tex.ground));
			i += 49;
		}
		
		// spaced out blocks
		int skip = 0;
		for(int i = 2440; i < 3300; i++)
		{
			// make separated bricks
			if(skip == 3) {
				Controller.addObject(new Block(i, HEIGHT - 400, Identities.BLOCK_BRICK, tex, tex.brick));
				skip = 0;
			}
			++skip;
			i += 49;
		}
	
		// upwards staircase
		int vert = 650;
		for(int i = 3400; i < 3600; i+=50)
		{
			Controller.addObject(new Block(i, HEIGHT - vert, Identities.BLOCK_BRICK, tex, tex.brick));
			vert += 50;
		}
		
		// lower downwards stairs
		vert = 450;
		for(int i = 3750; i < 3900; i+=50)
		{
			Controller.addObject(new Block(i, HEIGHT - vert, Identities.BLOCK_BRICK, tex, tex.brick));
			vert -= 50;
		}
		
		// floor continued
		vert = 76;
		for(int i = 4100; i < 4800; i+=50)
		{	
			Controller.addObject(new Block(i, HEIGHT - vert, Identities.BLOCK_GROUND, tex, tex.ground)); //  draw the bottom ground
		}
		
		// this is the player
		
		Controller.addObject(new Player(400, HEIGHT - 600, Identities.PLAYER, tex)); //  draw the player
		
		// this is the cmera view
		camera = new Camera(0, 0);
		this.addKeyListener(new KeyInput());
		
		
	}
	
	public void tick()
	{
		if(state == GameState.GAME)
		{
			controller.tick();
			camera.tick();
		}
	}

	public void render() 
	{
		BufferStrategy b = this.getBufferStrategy();
		
		if(b == null)
		{
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = b.getDrawGraphics();
		Graphics2D g2D = (Graphics2D) g;
		g.setColor(Color.BLUE);		
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// this red block is just for testing
		g.setColor(new Color(255, 0, 0)); //it setting the new custom RGB color for fill the new RECT
		g.fillRect(10, 10, 100, 100);
		// end testing
		
		gfx.renderBackground(g);
		g2D.translate(camera.getX(), camera.getY());
		gfx.renderForeground(g);
		g2D.translate(-camera.getX(), -camera.getY());
		g.dispose();
		b.show();
	}

	@Override
	public void run() 
	{
		init(); // Initialize the game
		
		long lastTime = System.nanoTime();
		final double numTicks = 60.0;
		double n = 1000000000 / numTicks;
		double delta = 0;
		int frames  = 0;
		int ticks = 0;
		long timer = System.currentTimeMillis();
		
		while(running)
		{
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / n;
			lastTime = currentTime;
	
			if(delta >= 1)
			{
				tick();
				ticks++;
				delta--;
			}
			
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				System.out.println(ticks + " Ticks, FPS: " + frames);
				frame.setTitle(TITLE + "      FPS: " + frames);
				ticks = 0;
				frames = 0;
			}
		}
		
		stop();
	}
	
	public static void main(String args[]) 
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image cursor = toolkit.getImage( Reference.RESOURCE_LOCATION + "images/" + "mouse.png");
		
		frame.setTitle(TITLE);
		frame.add(game);
		frame.setCursor(toolkit.createCustomCursor(cursor, new Point(frame.getX(), frame.getY()), "mouse"));
		frame.setSize(WIDTH, HEIGHT);
		
		frame.addWindowListener(
				new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						Game.exit();
					}
				});
		
		frame.setFocusable(true);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);  
		frame.pack();
		
		game.start();
	}
	
	private synchronized void start()
	{
		if(running)
			return;
		else
			running = true;
		
		thread = new Thread(this);
		thread.start();
	}
	private synchronized void stop()
	{
		if(!running)
			return;
		else
			running = false;
		
		cleanUp();
		System.exit(1);
	}
	
	private void cleanUp()
	{
		AL.destroy();
	}
	
	public static void exit()
	{
		game.stop();
	}
}









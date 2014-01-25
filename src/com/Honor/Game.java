/**
 * @author Valentine
 *
 */
package com.Honor;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.Honor.Screens.Credits;
import com.Honor.Screens.Info;
import com.Honor.Screens.Menu;
import com.Honor.Screens.Options;
import com.Honor.Screens.Quit;
import com.Honor.enums.GameState;
import com.Honor.gfx.Renderer;
import com.Honor.input.MouseInput;
import com.Honor.libs.Audio;
import com.Honor.libs.Reference;
import com.Honor.utils.AudioPlayer;
import com.Honor.utils.ResourceLoader;

public class Game extends Canvas implements Runnable 
{
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 1440;
	public static final int HEIGHT = 900;
	public static final String TITLE = "The Honor";
	
	public static Game game = new Game();
	public static GameState state = GameState.MENU;
	
	private boolean running = false;
	private Thread thread;
	private Renderer gfx;
	public Menu menu;
	public Options options;
	public Credits credits;
	public Info info;
	public Quit quit;
	
	public static Game getInstance() 
	{
		return game;
	}
	
	public void init() 
	{
		ResourceLoader.loadImages();
		ResourceLoader.loadFonts();
		ResourceLoader.loadSounds();
		AudioPlayer.getSound(Audio.BACKGROUND).loop(1, 1);
		
		menu = new Menu();
		options = new Options();
		credits = new Credits();
		info = new Info();
		quit = new Quit();
		gfx = new Renderer();
		
		MouseInput mouse = new MouseInput();
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
	}
	
	public void tick()
	{
		
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
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		gfx.renderBackground(g);
		gfx.renderForeground(g);
		g.dispose();
		b.show();
	}

	@Override
	public void run() 
	{
		init();
		
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
				ticks++;
				delta--;
			}
			
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				System.out.println(ticks + " Ticks, FPS: " + frames);
				ticks = 0;
				frames = 0;
			}
		}
		
		stop();
	}
	
	public static void main(String args[]) 
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		JFrame frame = new JFrame(TITLE);
		Image cursor = toolkit.getImage( Reference.RESOURCE_LOCATION + "images/" + "mouse.png");
		frame.add(game);
		frame.setCursor(toolkit.createCustomCursor(cursor, new Point(frame.getX(), frame.getY()), "mouse"));
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		try {
			thread.join();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.exit(1);
	}
}

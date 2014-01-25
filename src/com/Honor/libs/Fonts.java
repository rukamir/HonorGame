/**
 * 
 */
package com.Honor.libs;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.io.File;
/**
 * @author Valentine
 *
 */
public class Fonts 
{

	private static ArrayList<Fonts> fontList = new ArrayList<Fonts>();
	
	private static String fontPath;
	
	// constructor
	public Fonts(String filePath)
	{
		Fonts.fontPath = Reference.FONT_LOCATION + filePath;
		registerFont();
	}
	
	private void registerFont()
	{
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		try
		{
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)));
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	
	public static void addFont(Fonts font)
	{
		fontList.add(font);
	}
}

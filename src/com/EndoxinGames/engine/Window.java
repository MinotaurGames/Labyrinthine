package com.EndoxinGames.engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.EndoxinGames.engine.exceptions.LocalizationNotPresentException;
import com.EndoxinGames.engine.exceptions.LocalizionNotInitializedException;
import com.EndoxinGames.engine.localization.Localization;

public class Window {
	
	public static void createWindow(int width, int height, String title){
		Display.setTitle(title);
		try {
			Display.setTitle(Localization.localize("gameTitle", 0));
		} catch (LocalizionNotInitializedException e1) {
			e1.printStackTrace();
		} catch (LocalizationNotPresentException e) {
			e.printStackTrace();
		}
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void render(){
		Display.update();
	}
	
	public static boolean isCloseRequested(){
		return Display.isCloseRequested();
	}
	
	public static int getWidth(){
		return Display.getDisplayMode().getWidth();
	}
	
	public static int getHeight(){
		return Display.getDisplayMode().getHeight();
	}
	
	public static String getTitle(){
		return Display.getTitle();
	}

	public static void dispose() {
		Display.destroy();
	}
	
}

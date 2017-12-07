package com.SHGroup.JunmoGame;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class EntryMain{
	public static final Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static void main(String[] args) {

		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new GameMain("JunmoGame"));
			
			appgc.setDisplayMode(d.width, d.height, true);
			
			appgc.start();
		} catch (SlickException e) {
		}
	}

}

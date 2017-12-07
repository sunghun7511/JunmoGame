package com.SHGroup.JunmoGame;

import org.newdawn.slick.Image;

public class ResourceManager {
	private final static ResourceManager instance = new ResourceManager();
	public final Image mainCharacter;
	public final Image mainCharacter_walk;
	public final Image mainCharacter_nyam;
	public final Image background;
	
	private ResourceManager() {
		mainCharacter = loadImage("Character-resize.png");
		mainCharacter_walk = loadImage("걷는몬스터-resize.png");
		mainCharacter_nyam = loadImage("입벌리는몬스터-resize.png");
		background = loadImage("temp.png");
	}
	
	public static ResourceManager getInstance() {
		return instance;
	}
	
	private final Image loadImage(String assetName) {
		try {
			return new Image("/assets/" + assetName);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}

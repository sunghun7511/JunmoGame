package com.SHGroup.JunmoGame.Models;

import org.newdawn.slick.SlickException;

public abstract class ObjectModel {
	
	private float x, y;
	
	public ObjectModel(float x, float y) throws SlickException{
		this.x = x;
		this.y = y;
		
		init();
	}
	
	public abstract void init() throws SlickException;
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
}

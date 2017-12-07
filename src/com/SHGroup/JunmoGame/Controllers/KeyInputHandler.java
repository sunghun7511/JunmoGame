package com.SHGroup.JunmoGame.Controllers;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.command.KeyControl;

public class KeyInputHandler implements InputProviderListener{
	
	private final InputProvider input;
	
	public KeyInputHandler(GameContainer container) {
		input = new InputProvider(container.getInput());
		input.addListener(this);
		
		for(KeyType kt : KeyType.values()) {
			input.bindCommand(new KeyControl(kt.getType()), kt.getCommand());
		}
	}
	
	private long lastPressedTime = -1l;
	
	private final ArrayList<KeyType> pressed = new ArrayList<>();
	
	@Override
	public void controlPressed(Command cmd) {
		KeyType press = KeyType.getTypeFromCommand(cmd);
		if(press == null) {
			return;
		}
		if(pressed.contains(press)) {
			return;
		}
		lastPressedTime = System.currentTimeMillis();
		pressed.add(press);
	}

	@Override
	public void controlReleased(Command cmd) {
		KeyType press = KeyType.getTypeFromCommand(cmd);
		if(!pressed.contains(press)) {
			return;
		}
		pressed.remove(press);
	}
	
	public boolean isPressing(KeyType type) {
		return pressed.contains(type);
	}
	
	public ArrayList<KeyType> getPressingList(){
		return pressed;
	}
	
	public long getLastPressTime() {
		return lastPressedTime;
	}
}

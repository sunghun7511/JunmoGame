package com.SHGroup.JunmoGame.Controllers;

import org.newdawn.slick.Input;
import org.newdawn.slick.command.BasicCommand;
import org.newdawn.slick.command.Command;

public enum KeyType {
	UP(Input.KEY_UP, "up"), DOWN(Input.KEY_DOWN, "down"), LEFT(Input.KEY_LEFT, "left"), RIGHT(Input.KEY_RIGHT, "right" ),
	W(Input.KEY_W, "w"), A(Input.KEY_A, "a"), S(Input.KEY_S, "s"), D(Input.KEY_D, "d"),
	LSHIFT(Input.KEY_LSHIFT, "lshift");

	private int type;
	private String name;
	private Command command;

	private KeyType(int type, String name) {
		this.type = type;
		this.name = name;
		this.command = new BasicCommand(name);
	}
	
	public int getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
	
	public Command getCommand() {
		return command;
	}
	
	public static KeyType getTypeFromCommand(Command c) {
		for(KeyType kt : values()) {
			if(kt.command.equals(c)) {
				return kt;
			}
		}
		return null;
	}
}

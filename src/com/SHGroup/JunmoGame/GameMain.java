package com.SHGroup.JunmoGame;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.SHGroup.JunmoGame.Controllers.KeyInputHandler;
import com.SHGroup.JunmoGame.Models.MyCharacter;

public class GameMain extends BasicGame {
	public GameMain(String title) {
		super(title);
	}

	private KeyInputHandler keyInput;
	private MyCharacter cMain;

	@Override
	public void init(GameContainer gContainer) throws SlickException {
		keyInput = new KeyInputHandler(gContainer);
		cMain = new MyCharacter(50.0f, 50.0f);
	}

	@Override
	public void render(GameContainer gContainer, Graphics g) throws SlickException {
		cMain.getCurrentAnimation().draw(cMain.getX(), cMain.getY());
	}

	@Override
	public void update(GameContainer gContainer, int delta) throws SlickException {
		cMain.move(keyInput.getPressingList());
	}
}

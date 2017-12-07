package com.SHGroup.JunmoGame.Models;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import com.SHGroup.JunmoGame.EntryMain;
import com.SHGroup.JunmoGame.ResourceManager;
import com.SHGroup.JunmoGame.Controllers.KeyType;

public class MyCharacter extends CharacterObject {

	private int state = 0;
	private boolean walkFlag = false;
	private long lastWalk = 0l;

	private SpriteSheet character, character_flip, character_walk, character_walk_flip;
	private Animation main, right, left, right_walk, left_walk;

	public MyCharacter(float x, float y) throws SlickException {
		super(x, y);
	}

	@Override
	public void init() throws SlickException {
		character = new SpriteSheet(ResourceManager.getInstance().mainCharacter, 100, 100);
		character_flip = new SpriteSheet(character.getFlippedCopy(true, false), 100, 100);

		character_walk = new SpriteSheet(ResourceManager.getInstance().mainCharacter_walk, 100, 100);
		character_walk_flip = new SpriteSheet(character_walk.getFlippedCopy(true, false), 100, 100);

		main = new Animation(character, 100);

		right = new Animation(character_flip, 100);
		left = new Animation(character, 100);

		right_walk = new Animation(character_walk_flip, 100);
		left_walk = new Animation(character_walk, 100);
	}

	public void move(ArrayList<KeyType> keyTypes) {
		if (keyTypes == null || keyTypes.size() == 0) {
			return;
		}

		outOfRange();

		float plusX = 0.0f;
		float plusY = 0.0f;

		boolean up = false;
		boolean down = false;
		boolean right = false;
		boolean left = false;
		boolean isShift = keyTypes.contains(KeyType.LSHIFT);

		for (KeyType keyType : keyTypes) {
			switch (keyType) {
			case S:
			case DOWN:
				down = true;
				break;
			case A:
			case LEFT:
				left = true;
				break;
			case D:
			case RIGHT:
				right = true;
				break;
			case W:
			case UP:
				up = true;
				break;
			default:
				break;
			}
		}

		float value = 0.4f;

		if (isShift) {
			value *= 2;
		}

		if (up) {
			plusY -= value;
		}
		if (down) {
			plusY += value;
		}
		if (left) {
			plusX -= value;
			state = 0;
		}
		if (right) {
			plusX += value;
			state = 1;
		}

		setX(getX() + plusX);
		setY(getY() + plusY);

		if (plusX != 0.0f || plusY != 0.0f) {
			if ((System.currentTimeMillis() - lastWalk) > (isShift ? 100l : 200l)) {
				walkFlag = !walkFlag;
				lastWalk = System.currentTimeMillis();
			}
		}

		outOfRange();
	}

	public Animation getCurrentAnimation() {
		if (state == 1) {
			return walkFlag ? right : right_walk;
		} else {
			return walkFlag ? left : left_walk;
		}
	}

	public void outOfRange() {
		if (getX() < 0.0f) {
			setX(0.0f);
		}

		if (getX() + main.getWidth() > EntryMain.d.width) {
			setX(EntryMain.d.width - main.getWidth());
		}

		if (getY() < 0.0f) {
			setY(0.0f);
		}

		if (getY() + main.getHeight() > EntryMain.d.height) {
			setY(EntryMain.d.height - main.getHeight());
		}
	}

	public int getState() {
		return state;
	}
}

package com.babyrocket.game;

import com.badlogic.gdx.math.Vector2;

public class Oil {
	Vector2 oilPosition;
	Vector2 oilVelocity;
	public static final int GRAVITY = 10;
	
	public Oil(int positionX, int positionY) {
		this.oilPosition = oilPosition;
		this.oilVelocity = oilVelocity;
	}
	
	public void update() {
		oilPosition.x += GRAVITY;
	}
}

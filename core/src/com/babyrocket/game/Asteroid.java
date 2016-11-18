package com.babyrocket.game;

import com.badlogic.gdx.math.Vector2;

public class Asteroid {

	
	Vector2 position;
	int x;
	int y;
	
	public Asteroid(float x, float y) {
		//position = new Vector2(300, 350);
		x = 300;
		y = 350;
	}
	
	public void update(float deltaTime) {
		x -= 15;
		y -= 15;
	}
}

package com.babyrocket.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Alien {
	//Vector2 position;
	//Rectangle bounds;
	Vector2 alienVelocity;
	Vector2 alienPosition;
	
	public Alien(Vector2 position, Vector2 velocity) {
		this.alienPosition = alienPosition;
		this.alienVelocity = alienVelocity;
	}
	
	public void update() {
		updateVelocity();
		alienPosition.x += alienVelocity.x;
		alienPosition.y += alienVelocity.y;
	}
	
	public void hit(Stone stone) {
		Vector2 Posstone = stone.getPosition();
		if(alienPosition.x - Posstone.x > 10 && alienPosition.x + Posstone.x < 10 && alienPosition.y - Posstone.y > 10 && alienPosition.y + Posstone.y <10) {
			GameScreen.scorce ++;
		}
	}
	
	public Vector2 getPosition() {
		return alienPosition;
	}
	public void updateVelocity() {
		alienVelocity.x = 0;
		alienVelocity.y = 0;
		alienVelocity.x += 4;
		alienVelocity.y += 3;
		if(alienPosition.x == GameScreen.WIDTH_SCREEN) {
			alienVelocity.x = -alienVelocity.x;
			alienPosition.y = 0;
		}
	}
}

package com.babyrocket.game;

import com.badlogic.gdx.math.Vector2;

public class Stone {
	public Vector2 stonePosition = new Vector2(0, 0);
	private Vector2 stoneVelocity = new Vector2(0, 0);

	public Stone(Vector2 position, Vector2 velocity) {
		stonePosition = new Vector2(position.x, position.y);
		stoneVelocity = new Vector2(velocity.x, velocity.y);
	}
	
	public void update() {
		stonePosition.x += stoneVelocity.x;
		stonePosition.y += stoneVelocity.y;
	}
	
	public Vector2 getPosition() {
		return stonePosition;
	}
}

package com.babyrocket.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class World {
	
	WorldRenderer worldRenderer;
	BabyRocketGame babyRocketGame;
	
	OrthographicCamera camera;
	Vector3 touchPoint;
	SpriteBatch batch;
	
	int score;
	
	public static final int TINY_ROCKET_VELOCITY_X = 30;
	public static final int TINY_ROCKET_VELOCITY_Y = 30;
	
	TinyRocket tinyRocket;
	public final ArrayList<Alien> alienList;
	public final ArrayList<Asteroid> asteroidList;
	ArrayList<Stone> stoneList;
	//public final EngineBar;
	Random random;
	
	int stateTime;
	int gameState;

	public World(BabyRocketGame babyRocketGame) {
		this.alienList = new ArrayList<Alien>();
		this.asteroidList = new ArrayList<Asteroid>();
		this.babyRocketGame = babyRocketGame;
		random = new Random();
		//playGame();
	}

	
	public void update(float deltaTime) {
		//updateTinyRocket(deltaTime);
		//updateAlien(deltaTime);
		//updateOil(deltaTime);
	}
	
	private void checkHit() {
		//checkHitAlien();
		//checkHitOil();
	}
}

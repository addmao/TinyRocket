package com.babyrocket.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	World world;
	BabyRocketGame babyRocketGame;
	GameScreen gameScreen;
	
	Vector2 position;
	OrthographicCamera camera;
	BitmapFont font;
	Texture backgroundMoonImg;
	SpriteBatch batch;
	Texture readyImg;
	Texture gameOverImg;
	Texture tinyRocketImg;
	
	private int x;
	private int y;
	
	public WorldRenderer(BabyRocketGame babyRocketgame) {
		this.gameScreen = gameScreen;
		font = new BitmapFont();
		backgroundMoonImg = new Texture("moon_background.png");
		readyImg = new Texture("bg1.jpg");
		gameOverImg = new Texture("gameOver.png");
		tinyRocketImg = new Texture("TinyRocket.png");
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 600, 400);
		
		
		this.world = world;
		this.babyRocketGame = babyRocketGame;
		this.batch = batch;
		//batch = babyRocketGame.batch;
	
		x = 30;
		y = 30;
	}
	

}

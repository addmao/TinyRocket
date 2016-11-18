package com.babyrocket.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class GameScreen extends ScreenAdapter {

	public static final int GRAVITY = 10;
	public static final float HEIGHT_SCREEN = 300;
	public static final float WIDTH_SCREEN = 300;
	public static double score = 0;
	
	BabyRocketGame babyRocketGame;
	
	World world;
	OrthographicCamera guiCamera;
	Vector3 touchPoint;
	SpriteBatch batch;
	Vector2 positionRocket;
	Vector2 oilPosition;
	Vector2 alienPosition;
	
	WorldRenderer worldRenderer;
	Texture tinyRocketImg;
	Texture backgroundMoonImg;
	Texture asteroidImg;
	Texture stoneImg;
	Texture oilImg;
	Texture alienImg;
	
	TinyRocket tinyRocket;
	BitmapFont font;
	Asteroid asteroid;
	Oil oil;
	Stone stone;
	
	int gameState;
	private int x;
	private int y;
	int time;
	
	double currentTime = System.nanoTime();
	String scoreRender = "SCORE : ";
	
	ArrayList<Alien> alienList;
	ArrayList<Stone> stoneList;
	ArrayList<Oil> oilList;
	
	public GameScreen(BabyRocketGame babyRocketGame) {
		this.babyRocketGame = babyRocketGame;
		this.worldRenderer = worldRenderer;
		
		batch = babyRocketGame.batch;
		backgroundMoonImg = new Texture("moon_background.png");
		tinyRocketImg = new Texture("TinyRocket.png");
		tinyRocket = new TinyRocket(30, 30);
		font = new BitmapFont(Gdx.files.internal("font.fnt"), Gdx.files.internal("font.png"), false);
		
		asteroidImg = new Texture("Asteroid.png");
		asteroid = new Asteroid(300, 350);
		stoneImg = new Texture("stone.png");
		oilImg = new Texture("oil.png");
		alienImg = new Texture("Alien.png");
		
		oilPosition = new Vector2();
		alienPosition = new Vector2();
		
		alienList = new ArrayList();
		stoneList = new ArrayList(); 
		oilList = new ArrayList();
		
		this.stone = stone;
		Alien addAlien = new Alien(positionRocket, new Vector2 (15, 15));
		
		x = 300;
		y = 350;
	}
	
	public void create() {
		batch = new SpriteBatch();
	}

	public void update(float deltaTime) {
		control();
		updateOil();
		updateAlien();
	}
	
	@Override
	public void render(float delta) {
		x -= 1;
		y -= 1;
		
		//oilPosition.x = 300;
		//oilPosition.y = 300;
		
		update(delta);
		//update(delta);
		//asteroid.update(delta);
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		positionRocket = tinyRocket.getPosition();
		batch.begin();
		batch.draw(backgroundMoonImg, 0, 0);
		font.draw(babyRocketGame.batch, scoreRender +(int)score, 100, 500);
		batch.draw(tinyRocketImg, positionRocket.x, positionRocket.y);
		batch.draw(asteroidImg, x, y);
		batch.draw(alienImg, alienPosition.x, alienPosition.y);
		batch.draw(alienImg, alienPosition.x + 100, alienPosition.y + 67);
		batch.draw(alienImg, alienPosition.x + 300, 388);
		batch.draw(alienImg, alienPosition.x + 345, 532);
		batch.draw(alienImg, alienPosition.x - 95, 69);
		batch.draw(alienImg, alienPosition.x + 478, 12);
		batch.draw(alienImg, alienPosition.x + 543, 56);
		batch.draw(alienImg, alienPosition.x - 223, 33);
		batch.draw(alienImg, alienPosition.x + 224, 213);
		batch.draw(alienImg, alienPosition.x - 211, 221);
		batch.draw(alienImg, alienPosition.x + 312, 89);
		batch.draw(alienImg, alienPosition.x + 456, 132);
		batch.draw(alienImg, alienPosition.x - 576, 23);
		batch.draw(oilImg, oilPosition.x, oilPosition.y);
		int count = 0;
		while(count < stoneList.size()) {
			Stone thisStone = stoneList.get(count);
			thisStone.update();
			
			if(thisStone.stonePosition.x > -50 && thisStone.stonePosition.y < 400 + 50 && thisStone.stonePosition.y > -50 && thisStone.stonePosition.y < 600 + 50) {
				hit(thisStone); 
				batch.draw(stoneImg, thisStone.stonePosition.x, thisStone.stonePosition.y);
			}
		
			else {
				stoneList.remove(count);
				if(stoneList.size() > 0) {
					count--;
				}
			}
			count++;
		}
		
		batch.end();
		
	}
	

	public void hit(Stone stone) {
		Vector2 Posstone = stone.getPosition();
		if(alienPosition.x - Posstone.x > 10 && alienPosition.x + Posstone.x < 10 && alienPosition.y - Posstone.y > 10 && alienPosition.y + Posstone.y <10) {
			GameScreen.score += 0.1;
		}
	}
	
	public void control() {
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            positionRocket.x -= 10;
        }
		
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            positionRocket.x += 10;
        }
        
        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            positionRocket.y -= 10;
        }
        
        if(Gdx.input.isKeyPressed(Keys.UP)) {
            positionRocket.y += 10;
        }
        
        if(Gdx.input.isKeyPressed(Keys.SPACE) && Gdx.input.isKeyPressed(Keys.UP)) {
        	Stone shootStone = new Stone(positionRocket, new Vector2(0, 30));
        	stoneList.add(shootStone);
        	GameScreen.score += 0.1;
        }
        
        if(Gdx.input.isKeyPressed(Keys.SPACE) && Gdx.input.isKeyPressed(Keys.DOWN)) {
        	Stone shootStone = new Stone(positionRocket, new Vector2(0, -30));
        	stoneList.add(shootStone);
        	GameScreen.score += 0.1;
        }
        
        if(Gdx.input.isKeyPressed(Keys.SPACE) && Gdx.input.isKeyPressed(Keys.RIGHT)) {
        	Stone shootStone = new Stone(positionRocket, new Vector2(30, 0));
        	stoneList.add(shootStone);
        	GameScreen.score += 0.1;
        }
        
        if(Gdx.input.isKeyPressed(Keys.SPACE) && Gdx.input.isKeyPressed(Keys.LEFT)) {
        	Stone shootStone = new Stone(positionRocket, new Vector2(-30, 0));
        	stoneList.add(shootStone);
        	GameScreen.score += 0.1;
        }
        
	}
	
	public void updateOil() {
		oilPosition.x = 0;
		oilPosition.y -= 5;
	}
	
	
	public void updateAlien() {
		time = 0;
		alienPosition.x += 3;
		alienPosition.y += 3;
		if(alienPosition.y >= HEIGHT_SCREEN || alienPosition.x >= WIDTH_SCREEN) {
			alienPosition.y = 40;
			alienPosition.x = 100;
		}
	}
	
}

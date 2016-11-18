package com.babyrocket.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.babyrocket.game.BabyRocketGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Baby Rocket";
		config.height = 600;
		config.width = 600;
		new LwjglApplication(new BabyRocketGame(), config);
	}
}

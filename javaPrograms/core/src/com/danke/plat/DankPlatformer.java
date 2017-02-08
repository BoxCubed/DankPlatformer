package com.danke.plat;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.danke.plat.States.GameScreen;

public class DankPlatformer extends Game {
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 600;
	public static final float PPM = 100;

	public static final String TITLE = "Dank Platformer";

	public SpriteBatch batch;

	float delta;

	public void create () {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
}

package com.gmail.tomattman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gmail.tomattman.game.managers.GameManager;
import com.gmail.tomattman.game.managers.InputManager;
import com.gmail.tomattman.game.managers.TextManager;

public class StrudyGame extends ApplicationAdapter {
	private OrthographicCamera camera;
	private SpriteBatch batch;

	private float width, height;

	private int fps = 5;
	private long delta = 1000 / fps;
	private long stateChangeTime;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(width, height);
		camera.setToOrtho(false);

		GameManager.init(width, height);
		TextManager.init(width, height);
		stateChangeTime = System.currentTimeMillis();
	}

	@Override
	public void render () {
		if(stateChangeTime + delta < System.currentTimeMillis()){
			GameManager.changeState();
			stateChangeTime = System.currentTimeMillis();
		}
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		InputManager.handleInput(camera);

		batch.begin();
		GameManager.renderGame(batch);
		TextManager.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		GameManager.dispose();
	}
}

package com.gmail.tomattman.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class InputManager {
    public static void handleInput(OrthographicCamera camera) {
        if (Gdx.input.justTouched()) {
            Vector3 point = new Vector3();
            point.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(point);
            System.out.println();
            TextManager.changeState("Touched " + point.x + " " + point.y);
        }
    }
}

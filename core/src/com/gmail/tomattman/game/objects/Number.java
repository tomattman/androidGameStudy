package com.gmail.tomattman.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private List<Sprite> sprites;
    private int counter = 0;

    private Vector2 position;

    private float width;
    private float height;

    private int spriteNum = 0;

    public void render(SpriteBatch batch){
        sprites.get(spriteNum).draw(batch);
    }

    public void changeState(){
        spriteNum ++;
        if(spriteNum >= sprites.size()){
            spriteNum = 0;
        }
    }

    public void dispose(){
        for(Sprite sprite: sprites){
            sprite.getTexture().dispose();
        }
    }

    public Number() {
        sprites = new ArrayList<Sprite>();
        position = new Vector2();
    }

    public List<Sprite> getSprites() {
        return sprites;
    }

    public void setSprites(List<Sprite> sprites) {
        this.sprites = sprites;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}

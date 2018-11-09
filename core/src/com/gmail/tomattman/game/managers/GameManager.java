package com.gmail.tomattman.game.managers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gmail.tomattman.game.objects.Number;

public class GameManager {
    static Number num;
    static float width,height;
    private static final float RESIZE_FACTOR = 2500f;
    static long beginTime;


    public static void init(float width, float height){
        GameManager.width = width;
        GameManager.height = height;
        initNumbers();
    }

    public static void initNumbers(){

        num = new Number();
        for (int i = 0; i <= 9; i++){
            Sprite numSprite = new Sprite(new Texture(i +".png"));
            num.setWidth(numSprite.getWidth() * (width / RESIZE_FACTOR));
            num.setHeight(numSprite.getHeight() * (width / RESIZE_FACTOR));
            numSprite.setSize(num.getWidth(), num.getHeight());
            numSprite.setPosition(num.getPosition().x, num.getPosition().y);
            num.getSprites().add(numSprite);
        }
        num.getPosition().set(width / 2 - num.getSprites().get(0).getWidth() / 2, height / 2 - num.getSprites().get(0).getHeight() / 2);


    }

    public static void renderGame(SpriteBatch batch){
        num.render(batch);
    }

    public static void dispose(){
        num.dispose();
    }

    public static void changeState(){
        num.changeState();
    }
}

package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Obstacles {

    class WallPair{
        Vector2 position;
        float speed;

        public WallPair(Vector2 pos){
            position = pos;
            speed = 2;
        }

        public void update(){
            position.x -= speed;
        }
    }

    WallPair[] obs;
    Texture tx;
    int distance;

    public Obstacles(){
        tx = new Texture("wall.png");
        obs = new WallPair[4];
        distance = 250;
        int startPosX = 400;
        for (int i = 0; i < obs.length; i++) {
            obs[i] = new WallPair(new Vector2(startPosX, 0));
            startPosX += 220;
        }
    }

    public void render(SpriteBatch batch){
        for (int i = 0; i < obs.length; i++) {
            batch.draw(tx, obs[i].position.x, obs[i].position.y);
        }
    }

    public void update(){
        for (int i = 0; i < obs.length; i++) {
            obs[i].update();
        }
    }
}

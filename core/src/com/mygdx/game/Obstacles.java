package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;

public class Obstacles {

    class WallPair{
        Vector2 position;
        float speed;
        int offset;
        Rectangle emptySpace;

        public WallPair(Vector2 pos) {
            position = pos;
            speed = 2;
            offset = new Random().nextInt(250);
            emptySpace = new Rectangle(position.x, position.y - offset + tx.getHeight(), 50, distance);
    }

        public void update(){
            position.x -= speed;
            if (position.x < -50) {
                position.x = 800;
                offset = new Random().nextInt(250);
            }
            emptySpace.y = position.y - offset + tx.getHeight();
            emptySpace.x = position.x - ;
        }
    }

    static WallPair[] obs;
    Texture tx;
    int distance;

    public Obstacles() {
        tx = new Texture("wall.png");
        obs = new WallPair[4];
        distance = 250;
        int startPosX = 400;
        for (int i = 0; i < obs.length; i++) {
            obs[i] = new WallPair(new Vector2(startPosX, 0));
            startPosX += 220;
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < obs.length; i++) {
            batch.draw(tx, obs[i].position.x, obs[i].position.y - obs[i].offset);
            batch.draw(tx, obs[i].position.x, obs[i].position.y + distance + tx.getHeight() - obs[i].offset);
        }
    }

    public void update(){
        for (int i = 0; i < obs.length; i++) {
            obs[i].update();
        }
    }
    public void recreate() {
        int startPosX = 400;
        for (int i = 0; i < obs.length; i++) {
            obs[i] = new WallPair(new Vector2(startPosX, 0));
            startPosX += 220;
        }
    }
}

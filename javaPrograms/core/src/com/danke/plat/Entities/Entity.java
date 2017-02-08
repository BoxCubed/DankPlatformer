package com.danke.plat.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by LuhaR on 2/3/2017.
 */
public abstract class Entity {
    public Entity(int x,int y, String id){

    }
    public abstract void render(SpriteBatch sb);
    public abstract void update(float delta);

    public abstract Texture sprite(Texture tex);
    public abstract void dispose(SpriteBatch sb);

}

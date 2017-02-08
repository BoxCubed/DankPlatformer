package com.danke.plat.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;
import com.danke.plat.DankPlatformer;

/**
 * Created by LuhaR on 2/7/2017.
 */
public class Player extends Sprite {
    public World world;
    public Body body;
    Texture texture;

    public Player(World world){
        this.world = world;
        definePlayer();
    }

    public void definePlayer(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(40/ DankPlatformer.PPM,200/DankPlatformer.PPM);
        bdef.type=BodyDef.BodyType.DynamicBody;
        body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        PolygonShape shape1 = new PolygonShape();

        shape1.setAsBox(5/DankPlatformer.PPM,5/DankPlatformer.PPM);

        fdef.shape=shape1;
        body.createFixture(fdef);
    }

    public void render(SpriteBatch sb){
       //sb.draw(texture);
    }
}

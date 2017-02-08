package com.danke.plat.Engine;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.danke.plat.DankPlatformer;

/**
 * Created by LuhaR on 2/7/2017.
 */
public class Collision {
    TiledMap tm;
    World world;
    FixtureDef fdef;

    public Collision(TiledMap tm, World world){
        this.tm=tm;
        this.world=world;
        init();
    }
    public void init(){
        BodyDef bdef = new BodyDef();
        BodyDef bdef1 = new BodyDef();
        PolygonShape shape = new PolygonShape();
        PolygonShape shape1 = new PolygonShape();
        fdef = new FixtureDef();
        FixtureDef fdef1 = new FixtureDef();
        Body body,body1;

        for(MapObject object : tm.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject)object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX()+rect.getWidth()/2) / DankPlatformer.PPM , (rect.getY()+rect.getHeight() / 2) / DankPlatformer.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2 / DankPlatformer.PPM,rect.getHeight() / 2 / DankPlatformer.PPM);

            fdef.shape=shape;

            body.createFixture(fdef);
        }
        for(MapObject object1 : tm.getLayers().get(2).getObjects().getByType(PolygonMapObject.class)){
            Polygon poly = ((PolygonMapObject)object1).getPolygon();
            bdef1.type=BodyDef.BodyType.StaticBody;
            bdef1.position.set((poly.getX()+poly.getBoundingRectangle().getWidth()/2) / DankPlatformer.PPM , (poly.getY()+poly.getBoundingRectangle().getHeight() / 2) / DankPlatformer.PPM);

            body1 = world.createBody(bdef1);


            fdef1.shape=shape;
            body1.createFixture(fdef1);

        }
    }

    public FixtureDef getFdef(){
        return fdef;
    }
}

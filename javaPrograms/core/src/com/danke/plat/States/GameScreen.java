package com.danke.plat.States;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.danke.plat.DankPlatformer;
import com.danke.plat.Engine.Collision;
import com.danke.plat.Sprites.Player;

/**
 * Created by LuhaR on 2/2/2017.
 */
public class GameScreen extends ApplicationAdapter implements Screen {
    private DankPlatformer game;

    FitViewport gameport;

    Collision collision;

    Player player;

    TiledMap tiledMap;
    OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;

    private World world;
    private Box2DDebugRenderer b2dr;

    public GameScreen(DankPlatformer game){
        this.game = game;

        camera = new OrthographicCamera();

        gameport = new FitViewport(500/DankPlatformer.PPM,300/DankPlatformer.PPM, camera);


        tiledMap = new TmxMapLoader().load("map3.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap,1/DankPlatformer.PPM);

       //camera.setToOrtho(false,400,300);
        camera.position.set(gameport.getWorldWidth()/2,gameport.getWorldHeight()/2,0);


        world = new World(new Vector2(0,-10),true);
        b2dr = new Box2DDebugRenderer();

        collision = new Collision(tiledMap,world);

        //creates player
        player = new Player(world);
    }
    @Override
    public void show() {

    }

    public void update(float delta){

        handleInput(delta);

        world.step(1/60f,6,2);

      camera.position.x = player.body.getPosition().x;
      //camera.position.y = player.body.getPosition().y;
        //if(camera.position.x>1330){camera.position.x=1330;}
       // if(camera.position.x<270){camera.position.x=270;}

        camera.update();

        tiledMapRenderer.setView(camera);
        //System.out.println(camera.position);
       // System.out.println(player.getX());
    }
    public void render (float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(camera.combined);

        tiledMapRenderer.render();

        //draws colliders
        b2dr.render(world,camera.combined);


    }


    @Override
    public void resize(int width, int height) {
        gameport.update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
    public void handleInput(float delta){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)&&player.body.getLinearVelocity().x<=2){
           player.body.applyLinearImpulse(new Vector2(0.1f,0),player.body.getWorldCenter(),true);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)&&player.body.getLinearVelocity().x>=-2){
            player.body.applyLinearImpulse(new Vector2(-0.1f,0),player.body.getWorldCenter(),true);
        }
       if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
           player.body.applyLinearImpulse(new Vector2(0,4f),player.body.getWorldCenter(),true);
       }
    }

}

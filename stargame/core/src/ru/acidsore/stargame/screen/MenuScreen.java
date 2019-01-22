package ru.acidsore.stargame.screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.acidsore.stargame.base.BaseScreen;


public class MenuScreen extends BaseScreen {

    private static final float V_LEN = 0.00001f;

    Texture img;
    Texture background;

    Vector2 pos;
    Vector2 speed;
    Vector2 userTouch;
    Vector2 buf;


    @Override
    public void show() {
        super.show();
        background = new Texture("maxresdefault.jpg");
        img = new Texture("badlogic.jpg");
        pos = new Vector2(0, 0);
        pos = new Vector2(-0.5f, -0.5f);
        speed = new Vector2(0.002f, 0.002f);
        userTouch = new Vector2();
        buf = new Vector2();


    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.5f, 0.2f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        buf.set(userTouch);
         //if (Gdx.input.isTouched()) {
                if ((buf.sub(pos).len() > V_LEN)) {
                  pos.add(speed);
                 } else
                pos.set(userTouch);
         //}
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) pos.x -= .1f * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) pos.x += .1f* Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) pos.y += .1f * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) pos.y -= .1f * Gdx.graphics.getDeltaTime();
        if (pos.x < -.5f) pos.x = -0.5f;
        if (pos.y < -.5f) pos.y = -0.5f;
        if (pos.x > .5f) pos.x = 0.f;
        if (pos.y > .5f) pos.y = 0.f;
        batch.begin();
        batch.draw(background, -0.5f, -0.5f, 1f, 1f);
        batch.draw(img, pos.x, pos.y, 0.5f, 0.5f);
        batch.end();

    }
    @Override
    public boolean keyDown(int keycode) {
        System.out.println("keyDown keycode = " + keycode);
        return false;
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void dispose() {
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
       userTouch.set(touch);
       speed.set(userTouch.cpy().sub(pos.setLength(V_LEN)));
        return super.touchDown(touch, pointer);
    }
}

package ru.acidsore.stargame.screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.acidsore.stargame.base.BaseScreen;


public class MenuScreen extends BaseScreen {
    SpriteBatch batch;
    Texture img;
    Texture background;

    Vector2 pos;
    Vector2 touch;
    Vector2 tmp;
    Vector2 tmp2;

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        background = new Texture("maxresdefault.jpg");
        img = new Texture("badlogic.jpg");
        pos = new Vector2(0, 0);
        touch = new Vector2();
        tmp = new Vector2();

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.5f, 0.2f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, -150, -200);
        batch.draw(img, pos.x, pos.y);
        batch.end();
            if (Gdx.input.isTouched()) {
                if(touch.x != Gdx.input.getX() && touch.y != Gdx.input.getY()) {
                    touch.set(Gdx.input.getX(), Gdx.input.getY());

                    while (pos.x != touch.x && pos.y != touch.y) {
                        tmp2 = new Vector2(touch);
                        tmp = (tmp2.sub(pos)).scl(.1f);
                        pos.add(tmp);
                    }
                    //                System.out.println("touch " + " " + touch.x + " " + touch.y);
                    //                System.out.println("pos " + " " + pos.x + " " + pos.y);
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) pos.x -= 100 * Gdx.graphics.getDeltaTime();
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) pos.x += 100 * Gdx.graphics.getDeltaTime();
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) pos.y += 100 * Gdx.graphics.getDeltaTime();
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) pos.y -= 100 * Gdx.graphics.getDeltaTime();
            if (pos.x < 0) pos.x = 0;
            if (pos.y < 0) pos.y = 0;
            if (pos.x > Gdx.graphics.getWidth() - 256) pos.x = Gdx.graphics.getWidth() - 256;
            if (pos.y > Gdx.graphics.getHeight() - 256) pos.y = Gdx.graphics.getHeight() - 256;
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
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    //    System.out.println("touchDown " + screenX + " " + (Gdx.graphics.getHeight() - screenY));
        return super.touchDown(screenX, screenY, pointer, button);
    }
}

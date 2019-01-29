package ru.acidsore.sprite.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.acidsore.base.Sprite;
import ru.acidsore.math.Rect;
import ru.acidsore.pool.BulletPool;

public class MainShip extends Sprite {

    private Rect worldBounds;

    private final Vector2 v0 = new Vector2(0.5f, 0);
    private Vector2 v = new Vector2();

    private boolean isPressedLeft;
    private boolean isPressedRight;
    private boolean isPressed;

    private BulletPool bulletPool;

    private TextureRegion bulletRegion;
    private Sound shot;



    public MainShip(TextureAtlas atlas, BulletPool bulletPool) {
        super(atlas.findRegion("main_ship"), 1, 2, 2);
        this.bulletRegion = atlas.findRegion("bulletMainShip");
        this.bulletPool = bulletPool;
        setHeightProportion(0.15f);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
        setBottom(worldBounds.getBottom() + 0.05f);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        pos.mulAdd(v, delta);
    }

    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
            case Input.Keys.LEFT:
                isPressedLeft = true;
                moveLeft();
                break;
            case Input.Keys.D:
            case Input.Keys.RIGHT:
                isPressedRight = true;
                moveRight();
                break;
            case Input.Keys.UP:
                shoot();
                break;
        }
        return false;
    }

    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
            case Input.Keys.LEFT:
                isPressedLeft = false;
                if (isPressedRight) {
                    moveRight();
                } else {
                    stop();
                }
                break;
            case Input.Keys.D:
            case Input.Keys.RIGHT:
                isPressedRight = false;
                if (isPressedLeft) {
                    moveLeft();
                } else {
                    stop();
                }
                break;
        }
        return false;
    }

    private void moveRight() {
        while (pos.x < worldBounds.getRight() - 0.07f){
            v.set(v0);
            if (pos.x  == worldBounds.getRight() - 0.07f) break;
        }
    }

    private void moveLeft() {
        while (pos.x > worldBounds.getLeft() + 0.07f) {
            v.set(v0).rotate(180);
            if (pos.x == worldBounds.getLeft() + 0.07f) break;
        }
    }

    private void stop() {
        v.setZero();
    }

    private void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, pos, new Vector2(0, 0.5f), 0.01f, worldBounds, 1);
        shot = Gdx.audio.newSound(Gdx.files.internal("music/shot.mp3"));
        shot.play();
    }
      @Override
     public boolean touchDown(Vector2 touch, int pointer){
        isPressed = true;
        if (touch.x > (worldBounds.getHalfWidth()*0.3f))
        {
            moveRight();
            return true;
        }
        if ( touch.x < (-worldBounds.getHalfWidth()*0.03f))
         {
             moveLeft();
             return true;
         }
         isPressed = false;
        return true;
    }

    public boolean touchUp(Vector2 touch, int pointer){
        if (isPressed) {
            if (touch.x > (worldBounds.getHalfWidth() * 0.3f)) {
                moveRight();
                return true;
            }
            if (touch.x < (-worldBounds.getHalfWidth() * 0.03f)) {
                moveLeft();
                return true;
            }
        }
        return false;
    }

}

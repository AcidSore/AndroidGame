package ru.acidsore.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.WindowedMean;

import ru.acidsore.sprite.Background;
import ru.acidsore.sprite.Star;
import ru.acidsore.sprite.game.MainShip;
import ru.acidsore.base.Base2DScreen;
import ru.acidsore.math.Rect;
import ru.acidsore.pool.BulletPool;
import ru.acidsore.pool.ExplosionPool;
import ru.acidsore.sprite.game.Explosion;
import ru.acidsore.pool.EnemyPool;
import ru.acidsore.utils.EnemyEmitterSmall;
import ru.acidsore.utils.EnemyEmitterMedium;
import ru.acidsore.utils.EnemyEmitterBig;

public class GameScreen extends Base2DScreen {

    private TextureAtlas atlas;
    private Texture bg;
    private Background background;
    private Star star[];
    private MainShip mainShip;

    private BulletPool bulletPool;
    private ExplosionPool explosionPool;
    private EnemyPool enemyPool;

    private EnemyEmitterSmall enemyEmitterSmall;
    private EnemyEmitterMedium enemyEmitterMedium;
    private EnemyEmitterBig enemyEmitterBig;
    private Rect WorldBounds;

    private Music musicGame;


    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(new TextureRegion(bg));
        atlas = new TextureAtlas("textures/mainAtlas.tpack");
        star = new Star[64];
        for (int i = 0; i < star.length; i++) {
            star[i] = new Star(atlas);
        }
        bulletPool = new BulletPool();
        mainShip = new MainShip(atlas, bulletPool);
        musicGame =  Gdx.audio.newMusic(Gdx.files.internal("music/musicGame.mp3"));
        musicGame.setLooping(true);
        musicGame.play();

        bulletPool = new BulletPool();
        explosionPool = new ExplosionPool(atlas);
        enemyPool = new EnemyPool(bulletPool, worldBounds);
        mainShip = new MainShip(atlas, bulletPool);

        enemyEmitterSmall = new EnemyEmitterSmall(atlas, enemyPool, worldBounds);
        enemyEmitterMedium= new EnemyEmitterMedium(atlas, enemyPool, worldBounds);
        enemyEmitterBig = new EnemyEmitterBig(atlas, enemyPool, worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        deleteAllDestroyed();
        draw();
    }

    public void update(float delta) {
        for (int i = 0; i < star.length; i++) {
            star[i].update(delta);
        }
        mainShip.update(delta);
        bulletPool.updateActiveSprites(delta);
        explosionPool.updateActiveSprites(delta);
        enemyPool.updateActiveSprites(delta);
        int a = 0;
        int b = 3;
        int random = a + (int) (Math.random() * b);
        switch (random){
            case 1:{
                enemyEmitterSmall.generate(delta);
            }
            case 2: {
                enemyEmitterMedium.generate(delta);
            }
            case 3: {
                enemyEmitterBig.generate(delta);
            }
        }

    }

    public void deleteAllDestroyed() {
        bulletPool.freeAllDestroyedActiveSprites();
        explosionPool.freeAllDestroyedActiveSprites();
        enemyPool.freeAllDestroyedActiveSprites();
    }

    public void draw() {
        Gdx.gl.glClearColor(0.5f, 0.2f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (int i = 0; i < star.length; i++) {
            star[i].draw(batch);
        }
        mainShip.draw(batch);
        bulletPool.drawActiveSprites(batch);
        explosionPool.drawActiveSprites(batch);
        enemyPool.drawActiveSprites(batch);
        batch.end();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (int i = 0; i < star.length; i++) {
            star[i].resize(worldBounds);
        }
        mainShip.resize(worldBounds);
    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        bulletPool.dispose();
        explosionPool.dispose();
        enemyPool.dispose();
        mainShip.dispose();
        musicGame.dispose();
        super.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        mainShip.keyDown(keycode);
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        mainShip.keyUp(keycode);
        return super.keyUp(keycode);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        Explosion explosion = explosionPool.obtain();
        explosion.set(0.15f, touch);
        mainShip.touchDown(touch, pointer);
        return super.touchDown(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        mainShip.touchUp(touch, pointer);
        return super.touchUp(touch, pointer);
    }
}

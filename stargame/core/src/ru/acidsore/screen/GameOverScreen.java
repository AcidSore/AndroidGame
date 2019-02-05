package ru.acidsore.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

import ru.acidsore.base.Base2DScreen;
import ru.acidsore.math.Rect;
import ru.acidsore.sprite.Background;
import ru.acidsore.sprite.menu.ButtonNewGame;

public class GameOverScreen extends Base2DScreen {

    private Game game;

    private TextureAtlas atlas;
    private Texture bg;
    private Background background;
    private Music musicStart;

    private ButtonNewGame buttonNewGame;
    private TextureAtlas.AtlasRegion message;

    public GameOverScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(new TextureRegion(bg));
        atlas = new TextureAtlas("textures/mainAtlas.tpack");
        message = atlas.findRegion("message_game_over");

        buttonNewGame = new ButtonNewGame(atlas, game);

        musicStart =  Gdx.audio.newMusic(Gdx.files.internal("music/musicMenu.mp3"));
        musicStart.play();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        draw();
        musicStart.setLooping(true);
    }

    public void draw() {
        Gdx.gl.glClearColor(0.5f, 0.2f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);

        buttonNewGame.draw(batch);
        batch.end();
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        buttonNewGame.resize(worldBounds);

    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        musicStart.dispose();
        super.dispose();
    }

//    @Override
//    public boolean touchDown(Vector2 touch, int pointer) {
//        buttonExit.touchDown(touch, pointer);
//        buttonPlay.touchDown(touch, pointer);
//        return super.touchDown(touch, pointer);
//    }
//
//    @Override
//    public boolean touchUp(Vector2 touch, int pointer) {
//        buttonExit.touchUp(touch, pointer);
//        buttonPlay.touchUp(touch, pointer);
//        return super.touchUp(touch, pointer);
//    }
}

package com.deeep.spaceglad;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.deeep.spaceglad.screens.GameScreen;

public class Core extends ApplicationAdapter {
    public static final float VIRTUAL_WIDTH = 960;
    public static final float VIRTUAL_HEIGHT = 540;
    public static boolean Pause;
    Screen screen;
//    FPSLogger fpsLogger;

    @Override
    public void create() {
        new Assets();
        Gdx.input.setCatchBackKey(true);
//        dialogs = new Dialogs();
        setScreen(new GameScreen(this));
//        fpsLogger = new FPSLogger();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        screen.render(Gdx.graphics.getDeltaTime());
//        fpsLogger.log();
    }

    @Override
    public void resize(int width, int height) {
        screen.resize(width, height);
    }

    public void setScreen(Screen screen) {
        if (this.screen != null) {
            this.screen.hide();
            this.screen.dispose();
        }
        this.screen = screen;
        if (this.screen != null) {
            this.screen.show();
            this.screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
    }
}
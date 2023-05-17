package com.Test_core;


import com.badlogic.gdx.*;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Clipboard;
import com.badlogic.gdx.utils.I18NBundle;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Fury;
import com.watabou.utils.GameSettings;
import org.junit.jupiter.api.Assertions;
import java.util.Map;

class BuffTest {

    @org.junit.jupiter.api.Test
    void heroMessage() {
        I18NBundle i18nBundle = new I18NBundle();
        Gdx.app = new Application() {
            @Override
            public ApplicationListener getApplicationListener() {
                return null;
            }

            @Override
            public Graphics getGraphics() {
                return null;
            }

            @Override
            public Audio getAudio() {
                return null;
            }

            @Override
            public Input getInput() {
                return null;
            }

            @Override
            public Files getFiles() {
                return null;
            }

            @Override
            public Net getNet() {
                return null;
            }

            @Override
            public void log(String tag, String message) {

            }

            @Override
            public void log(String tag, String message, Throwable exception) {

            }

            @Override
            public void error(String tag, String message) {

            }

            @Override
            public void error(String tag, String message, Throwable exception) {

            }

            @Override
            public void debug(String tag, String message) {

            }

            @Override
            public void debug(String tag, String message, Throwable exception) {

            }

            @Override
            public void setLogLevel(int logLevel) {

            }

            @Override
            public int getLogLevel() {
                return 0;
            }

            @Override
            public void setApplicationLogger(ApplicationLogger applicationLogger) {

            }

            @Override
            public ApplicationLogger getApplicationLogger() {
                return null;
            }

            @Override
            public ApplicationType getType() {
                return null;
            }

            @Override
            public int getVersion() {
                return 0;
            }

            @Override
            public long getJavaHeap() {
                return 0;
            }

            @Override
            public long getNativeHeap() {
                return 0;
            }

            @Override
            public Preferences getPreferences(String name) {
                return null;
            }

            @Override
            public Clipboard getClipboard() {
                return null;
            }

            @Override
            public void postRunnable(Runnable runnable) {

            }

            @Override
            public void exit() {

            }

            @Override
            public void addLifecycleListener(LifecycleListener listener) {

            }

            @Override
            public void removeLifecycleListener(LifecycleListener listener) {

            }
        };
        Gdx.files = new Files() {
            @Override
            public FileHandle getFileHandle(String path, FileType type) {
                return null;
            }

            @Override
            public FileHandle classpath(String path) {
                return null;
            }

            @Override
            public FileHandle internal(String path) {
                return null;
            }

            @Override
            public FileHandle external(String path) {
                return null;
            }

            @Override
            public FileHandle absolute(String path) {
                return null;
            }

            @Override
            public FileHandle local(String path) {
                return null;
            }

            @Override
            public String getExternalStoragePath() {
                return null;
            }

            @Override
            public boolean isExternalStorageAvailable() {
                return false;
            }
            @Override
            public String getLocalStoragePath() {
                return null;
            }

            @Override
            public boolean isLocalStorageAvailable() {
                return false;
            }
        };
        GameSettings settings = new GameSettings();
        settings.set(new Preferences() {
            @Override
            public Preferences putBoolean(String key, boolean val) {
                return null;
            }

            @Override
            public Preferences putInteger(String key, int val) {
                return null;
            }

            @Override
            public Preferences putLong(String key, long val) {
                return null;
            }

            @Override
            public Preferences putFloat(String key, float val) {
                return null;
            }

            @Override
            public Preferences putString(String key, String val) {
                return null;
            }

            @Override
            public Preferences put(Map<String, ?> vals) {
                return null;
            }

            @Override
            public boolean getBoolean(String key) {
                return false;
            }

            @Override
            public int getInteger(String key) {
                return 0;
            }

            @Override
            public long getLong(String key) {
                return 0;
            }

            @Override
            public float getFloat(String key) {
                return 0;
            }

            @Override
            public String getString(String key) {
                return null;
            }

            @Override
            public boolean getBoolean(String key, boolean defValue) {
                return false;
            }

            @Override
            public int getInteger(String key, int defValue) {
                return 0;
            }

            @Override
            public long getLong(String key, long defValue) {
                return 0;
            }

            @Override
            public float getFloat(String key, float defValue) {
                return 0;
            }

            @Override
            public String getString(String key, String defValue) {
                return null;
            }

            @Override
            public Map<String, ?> get() {
                return null;
            }

            @Override
            public boolean contains(String key) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public void remove(String key) {

            }

            @Override
            public void flush() {

            }
        });

        Buff buff = new Fury();

        Assertions.assertEquals(buff.heroMessage(),
                "heroMessage");
    }
}

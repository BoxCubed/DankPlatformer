package com.danke.plat.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.danke.plat.DankPlatformer;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = DankPlatformer.WIDTH;
		config.height = DankPlatformer.HEIGHT;
		config.title = DankPlatformer.TITLE;
		new LwjglApplication(new DankPlatformer(), config);
	}
}

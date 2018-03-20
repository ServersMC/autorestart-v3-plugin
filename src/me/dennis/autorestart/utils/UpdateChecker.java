package me.dennis.autorestart.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import me.dennis.autorestart.core.AutoRestart;

public class UpdateChecker {

	public static String LATEST_VERSION = "";
	public static Boolean UPDATE_FOUND = false;
	
	public static void checkUpdate() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("https://gitlab.com/dennislysenko/AutoRestart-v3/raw/master/plugin.yml").openStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith("version:")) {
					LATEST_VERSION = line.split("version:")[1].trim();
					break;
				}
			}
			reader.close();
			if (!LATEST_VERSION.replace("v", "").equalsIgnoreCase(AutoRestart.VERSION)) {
				UPDATE_FOUND = true;
			}
		} catch (IOException ex) {}
	}
	
}

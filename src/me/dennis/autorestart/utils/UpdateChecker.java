package me.dennis.autorestart.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import me.dennis.autorestart.core.AutoRestart;

public class UpdateChecker {

	public static boolean checkUpdate() {
		String latestVersion = "";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("https://gitlab.com/dennislysenko/AutoRestart-v3/raw/master/plugin.yml").openStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith("version:")) {
					latestVersion = line.split("version:")[1].trim();
					break;
				}
			}
			reader.close();
			if (latestVersion.replace("v", "").equalsIgnoreCase(AutoRestart.VERSION)) {
				return false;
			}
			else {
				return true;
			}
		} catch (IOException ex) {
			return false;
		}
	}
	
}

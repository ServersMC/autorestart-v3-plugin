package me.dennis.autorestart.utils;

import org.bukkit.configuration.file.FileConfiguration;

import me.dennis.autorestart.core.AutoRestart;

public class Config {

	private static FileConfiguration config = AutoRestart.PLUGIN.getConfig();

	private static String getString(String node, String defaultValue) {
		return config.getString(node, defaultValue);
	}
	private static Integer getInteger(String node, Integer defaultValue) {
		return config.getInt(node, defaultValue);
	}
	private static Double getDouble(String node, Double defaultValue) {
		return config.getDouble(node, defaultValue);
	}
	
	public static class MAIN {
		public static String RESTART_MODE() { return getString("main.restart_mode", "interval"); }
		public static class MODES {
			public static Double INTERVAL() { return getDouble("main.modes.interval", 3d); }
			public static String TIMESTAMP() { return getString("main.modes.timestamp", "6:00"); }
		}
	}
	
}

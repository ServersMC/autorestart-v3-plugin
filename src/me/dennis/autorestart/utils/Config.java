package me.dennis.autorestart.utils;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    private static FileConfiguration config = null;
    
    public static Integer VERSION;
    
    private static FileConfiguration getConfig() {
        return config;
    }
    
    public static void setConfig(FileConfiguration config) {
        Config.config = config;
        VERSION = getInteger("version", 0);
    }

	private static String getString(String node, String defaultValue) {
		return getConfig().getString(node, defaultValue);
	}
	private static Integer getInteger(String node, Integer defaultValue) {
		return getConfig().getInt(node, defaultValue);
	}
	private static Double getDouble(String node, Double defaultValue) {
		return getConfig().getDouble(node, defaultValue);
	}
	
	public static class MAIN {
		public static String RESTART_MODE() { return getString("main.restart_mode", "interval"); }
		public static class MODES {
			public static Double INTERVAL() { return getDouble("main.modes.interval", 3d); }
			public static String TIMESTAMP() { return getString("main.modes.timestamp", "6:00"); }
		}
	}
	
}

package me.dennis.autorestart.utils;

import java.util.List;

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
	private static Boolean getBoolean(String node, Boolean defaultValue) {
		return getConfig().getBoolean(node, defaultValue);
	}
	private static List<Integer> getIntegerList(String node) {
		return getConfig().getIntegerList(node);
	}
	
	public static class MAIN {
		public static String RESTART_MODE() { return getString("main.restart_mode", "interval"); }
		public static class MODES {
			public static Double INTERVAL() { return getDouble("main.modes.interval", 3d); }
			public static String TIMESTAMP() { return getString("main.modes.timestamp", "6:00"); }
		}
	}
	
	public static class REMINDER {
		public static class ENABLED {
			public static Boolean MINUTES() { return getBoolean("reminder.enabled.minutes", true); }
			public static Boolean SECONDS() { return getBoolean("reminder.enabled.seconds", true); }
		}
		public static List<Integer> MINUTES() { return getIntegerList("reminder.minutes"); }
		public static Integer SECONDS() { return getInteger("reminder.seconds", 5); }
	}
	
	public static class MAX_PLAYERS {
		public static Boolean ENABLED() { return getBoolean("max_players.enabled", true); }
		public static Integer AMOUNT() { return getInteger("max_players.amount", 10); }
		public static Integer DELAY() { return getInteger("max_players.delay", 10); }
		public static class MESSAGES {
			public static String ALERT() { return getString("max_players.messages.alert", "&bToo many players online for restart. Max &f%a&b amount of players allowed for a restart. Waiting for people to leave!"); }
			public static String PRE_SHUTDOWN() { return getString("max_players.messages.pre_shutdown", "&aServer now restarting in &f%d&a seconds!"); }
		}
	}
	
}

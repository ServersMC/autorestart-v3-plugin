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
	private static List<String> getStringList(String node) {
		return getConfig().getStringList(node);
	}
	
	public static class MAIN {
		public static String RESTART_MODE() { return getString("main.restart_mode", "interval"); }
		public static class MODES {
			public static Double INTERVAL() { return getDouble("main.modes.interval", 3d); }
			public static String TIMESTAMP() { return getString("main.modes.timestamp", "6:00"); }
		}
		public static String PREFIX() { return getString("main.prefix", "&f[&7AutoRestart&f] &e"); }
		public static String RESTART_MESSAGE() { return getString("main.restart_message", "&cServer Restarting! We will be back up any minute!"); }
	}
	
	public static class REMINDER {
		public static class ENABLED {
			public static Boolean MINUTES() { return getBoolean("reminder.enabled.minutes", true); }
			public static Boolean SECONDS() { return getBoolean("reminder.enabled.seconds", true); }
		}
		public static List<Integer> MINUTES() { return getIntegerList("reminder.minutes"); }
		public static Integer SECONDS() { return getInteger("reminder.seconds", 5); }
	}
	
	public static class GLOBAL_BROADCAST {
		public static class ENABLED {
			public static Boolean MINUTES() { return getBoolean("global_broadcast.enabled.minutes", true); }
			public static Boolean SECONDS() { return getBoolean("global_broadcast.enabled.seconds", true); }
			public static class STATUS {
				public static Boolean START() { return getBoolean("global_broadcast.enabled.status.start", true); }
				public static Boolean PAUSE() { return getBoolean("global_broadcast.enabled.status.pause", true); }
			}
			public static Boolean CHANGE() { return getBoolean("global_broadcast.enabled.change", true); }
			public static class MAX_PLAYERS {
				public static Boolean ALERT() { return getBoolean("global_broadcast.enabled.max_players.alert", true); }
				public static Boolean PRE_SHUTDOWN() { return getBoolean("global_broadcast.enabled.max_players.pre_shutdown", true); }
			}
		}
		public static class MESSAGES {
			public static List<String> MINUTES() { return getStringList("global_broadcast.messages.minutes"); }
			public static List<String> SECONDS() { return getStringList("global_broadcast.messages.seconds"); }
			public static class STATUS {
				public static List<String> START() { return getStringList("global_broadcast.messages.status.start"); }
				public static List<String> PAUSE() { return getStringList("global_broadcast.messages.status.pause"); }
			}
			public static List<String> CHANGE() { return getStringList("global_broadcast.messages.change"); }
			public static class MAX_PLAYERS {
				public static List<String> ALERT() { return getStringList("global_broadcast.messages.max_players.alert"); }
				public static List<String> PRE_SHUTDOWN() { return getStringList("global_broadcast.messages.max_players.pre_shutdown"); }
			}
		}
	}
	
	public static class PRIVATE_MESSAGES {
		public static class ENABLED {
			public static Boolean TIME() { return getBoolean("private_messages.enabled.time", true); }
			public static class STATUS {
				public static Boolean START() { return getBoolean("private_messages.enabled.status.start", true); }
				public static Boolean PAUSE() { return getBoolean("private_messages.enabled.status.pause", true); }
			}
			public static Boolean CHANGE() { return getBoolean("private_messages.enabled.change", true); }
		}
		public static class MESSAGES {
			public static List<String> TIME() { return getStringList("private_messages.messages.time"); }
			public static class STATUS {
				public static List<String> START() { return getStringList("private_messages.messages.status.start"); }
				public static List<String> PAUSE() { return getStringList("private_messages.messages.status.pause"); }
			}
			public static List<String> CHANGE() { return getStringList("private_messages.messages.change"); }
		}
	}
	
	public static class MAX_PLAYERS {
		public static Boolean ENABLED() { return getBoolean("max_players.enabled", true); }
		public static Integer AMOUNT() { return getInteger("max_players.amount", 10); }
		public static Integer DELAY() { return getInteger("max_players.delay", 10); }
	}
	
}

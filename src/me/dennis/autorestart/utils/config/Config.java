package me.dennis.autorestart.utils.config;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    private static FileConfiguration config = null;
    
    public static Integer VERSION;
	public static Main MAIN = new Main();
	public static Reminder REMINDER = new Reminder();
	public static GlobalBroadcast GLOBAL_BROADCAST = new GlobalBroadcast();
	public static PrivateMessages PRIVATE_MESSAGES = new PrivateMessages();
	public static GlobalPopups GLOBAL_POPUPS = new GlobalPopups();
	public static PrivatePopups PRIVATE_POPUPS = new PrivatePopups();
	public static Commands COMMANDS = new Commands();
	public static MaxPlayers MAX_PLAYERS = new MaxPlayers();
    
    public static void setConfig(FileConfiguration config) {
        Config.config = config;
        VERSION = getInteger("version", 0);
    }
    
    public static FileConfiguration getConfig() {
        return config;
    }

    public static String getString(String node, String defaultValue) {
		return getConfig().getString(node, defaultValue);
	}
    
    public static Integer getInteger(String node, Integer defaultValue) {
		return getConfig().getInt(node, defaultValue);
	}
    
    public static Double getDouble(String node, Double defaultValue) {
		return getConfig().getDouble(node, defaultValue);
	}
    
    public static Boolean getBoolean(String node, Boolean defaultValue) {
		return getConfig().getBoolean(node, defaultValue);
	}
    
    public static List<Integer> getIntegerList(String node) {
		return getConfig().getIntegerList(node);
	}
    
    public static List<String> getStringList(String node) {
		return getConfig().getStringList(node);
	}
	
}

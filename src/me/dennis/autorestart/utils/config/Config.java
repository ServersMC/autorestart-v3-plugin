package me.dennis.autorestart.utils.config;

public class Config {

	public static Main MAIN = new Main();
	public static Reminder REMINDER = new Reminder();
	public static GlobalBroadcast GLOBAL_BROADCAST = new GlobalBroadcast();
	public static PrivateMessages PRIVATE_MESSAGES = new PrivateMessages();
	public static GlobalPopups GLOBAL_POPUPS = new GlobalPopups();
	public static PrivatePopups PRIVATE_POPUPS = new PrivatePopups();
	public static Commands COMMANDS = new Commands();
	public static MaxPlayers MAX_PLAYERS = new MaxPlayers();
    
	public static String getNode() {
		String directory = Thread.currentThread().getStackTrace()[2].getClassName().toLowerCase().replaceAll("me.dennis.autorestart.utils.config.", "");
		String method = Thread.currentThread().getStackTrace()[2].getMethodName().toLowerCase();
		return directory + "." + method;
	}
	
}

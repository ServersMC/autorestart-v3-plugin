package me.dennis.autorestart.utils.config;

import me.dennis.autorestart.utils.config.main.Modes;

public class Main {

	public String RESTART_MODE() {
		return Config.getString("main.restart_mode", "interval");
	}

	public Modes MODES = new Modes();

	public String PREFIX() {
		return Config.getString("main.prefix", "&f[&7AutoRestart&f] &e");
	}

	public String KICK_MESSAGE() {
		return Config.getString("main.kick_message", "&cServer Restarting! We will be back up any minute!");
	}

}

package me.dennis.autorestart.utils.config;

import me.dennis.autorestart.utils.config.main.Modes;

public class Main {

	public String RESTART_MODE() {
		return Config.getString(Config.getNode(), "interval");
	}

	public Modes MODES = new Modes();

	public String PREFIX() {
		return Config.getString(Config.getNode(), "&f[&7AutoRestart&f] &e");
	}

	public String KICK_MESSAGE() {
		return Config.getString(Config.getNode(), "&cServer Restarting! We will be back up any minute!");
	}

}

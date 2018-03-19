package me.dennis.autorestart.utils.config.main;

import me.dennis.autorestart.utils.config.Config;

public class Modes {
	
	public Double INTERVAL() {
		return Config.getDouble("main.modes.interval", 3d);
	}

	public String TIMESTAMP() {
		return Config.getString("main.modes.timestamp", "6:00");
	}
	
}

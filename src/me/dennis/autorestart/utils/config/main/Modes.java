package me.dennis.autorestart.utils.config.main;

import me.dennis.autorestart.utils.config.Config;

public class Modes {
	
	public Double INTERVAL() {
		return Config.getDouble(Config.getNode(), 3d);
	}

	public String TIMESTAMP() {
		return Config.getString(Config.getNode(), "6:00");
	}
	
}

package me.dennis.autorestart.utils.config.main;

import java.util.List;

import me.dennis.autorestart.utils.config.Config;

public class Modes {
	
	public Double INTERVAL() {
		return Config.MAIN.getDouble(Config.getNode(), 3d);
	}

	public List<String> TIMESTAMP() {
		return Config.MAIN.getStringList(Config.getNode());
	}
	
}

package me.dennis.autorestart.utils.config;

import java.util.List;

public class Commands {

	public Boolean ENABLED() {
		return Config.getBoolean("commands.enabled", false);
	}

	public Integer SECONDS() {
		return Config.getInteger("commands.seconds", 5);
	}

	public List<String> LIST() {
		return Config.getStringList("commands.list");
	}

}

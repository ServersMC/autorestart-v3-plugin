package me.dennis.autorestart.utils.config;

import java.util.List;

public class Commands {

	public Boolean ENABLED() {
		return Config.getBoolean(Config.getNode(), false);
	}

	public Integer SECONDS() {
		return Config.getInteger(Config.getNode(), 5);
	}

	public List<String> LIST() {
		return Config.getStringList(Config.getNode());
	}

}

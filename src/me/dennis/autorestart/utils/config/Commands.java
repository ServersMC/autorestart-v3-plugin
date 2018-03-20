package me.dennis.autorestart.utils.config;

import java.util.List;

import me.dennis.autorestart.objects.ConfigFile;

public class Commands extends ConfigFile {

	public Boolean ENABLED() {
		return Config.COMMANDS.getBoolean(Config.getNode(), false);
	}

	public Integer SECONDS() {
		return Config.COMMANDS.getInteger(Config.getNode(), 5);
	}

	public List<String> LIST() {
		return Config.COMMANDS.getStringList(Config.getNode());
	}

}

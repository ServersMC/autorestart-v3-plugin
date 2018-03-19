package me.dennis.autorestart.utils.config.global_broadcast.messages;

import java.util.List;

import me.dennis.autorestart.utils.config.Config;

public class Status extends Config {

	public List<String> START() {
		return getStringList(Config.getNode());
	}

	public List<String> PAUSE() {
		return getStringList(Config.getNode());
	}
	
}

package me.dennis.autorestart.utils.config.global_broadcast.messages;

import java.util.List;

import me.dennis.autorestart.utils.config.Config;

public class Status {

	public List<String> START() {
		return Config.GLOBAL_BROADCAST.getStringList(Config.getNode());
	}

	public List<String> PAUSE() {
		return Config.GLOBAL_BROADCAST.getStringList(Config.getNode());
	}
	
}

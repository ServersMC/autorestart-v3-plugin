package me.dennis.autorestart.utils.config.global_broadcast.messages;

import java.util.List;

import me.dennis.autorestart.utils.config.Config;

public class MaxPlayers extends Config {

	public List<String> ALERT() {
		return getStringList(Config.getNode());
	}

	public List<String> PRE_SHUTDOWN() {
		return getStringList(Config.getNode());
	}
	
}

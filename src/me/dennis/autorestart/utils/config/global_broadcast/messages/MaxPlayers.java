package me.dennis.autorestart.utils.config.global_broadcast.messages;

import java.util.List;

import me.dennis.autorestart.utils.config.Config;

public class MaxPlayers {

	public List<String> ALERT() {
		return Config.GLOBAL_BROADCAST.getStringList(Config.getNode());
	}

	public List<String> PRE_SHUTDOWN() {
		return Config.GLOBAL_BROADCAST.getStringList(Config.getNode());
	}
	
}

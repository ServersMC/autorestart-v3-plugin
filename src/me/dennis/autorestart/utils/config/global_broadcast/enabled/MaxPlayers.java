package me.dennis.autorestart.utils.config.global_broadcast.enabled;

import me.dennis.autorestart.utils.config.Config;

public class MaxPlayers {

	public Boolean ALERT() {
		return Config.GLOBAL_BROADCAST.getBoolean(Config.getNode(), true);
	}

	public Boolean PRE_SHUTDOWN() {
		return Config.GLOBAL_BROADCAST.getBoolean(Config.getNode(), true);
	}
	
}

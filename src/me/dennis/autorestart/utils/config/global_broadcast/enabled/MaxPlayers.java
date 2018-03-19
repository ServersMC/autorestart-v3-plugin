package me.dennis.autorestart.utils.config.global_broadcast.enabled;

import me.dennis.autorestart.utils.config.Config;

public class MaxPlayers {

	public Boolean ALERT() {
		return Config.getBoolean("global_broadcast.enabled.max_players.alert", true);
	}

	public Boolean PRE_SHUTDOWN() {
		return Config.getBoolean("global_broadcast.enabled.max_players.pre_shutdown", true);
	}
	
}

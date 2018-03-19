package me.dennis.autorestart.utils.config.global_popups.enabled;

import me.dennis.autorestart.utils.config.Config;

public class MaxPlayers {

	public Boolean ALERT() {
		return Config.getBoolean(Config.getNode(), true);
	}

	public Boolean PRE_SHUTDOWN() {
		return Config.getBoolean(Config.getNode(), true);
	}

}

package me.dennis.autorestart.utils.config.private_popups.enabled;

import me.dennis.autorestart.utils.config.Config;

public class Status {

	public Boolean START() {
		return Config.PRIVATE_POPUPS.getBoolean(Config.getNode(), true);
	}

	public Boolean PAUSE() {
		return Config.PRIVATE_POPUPS.getBoolean(Config.getNode(), true);
	}
	
}

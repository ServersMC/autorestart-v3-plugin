package me.dennis.autorestart.utils.config.global_popups.enabled;

import me.dennis.autorestart.utils.config.Config;

public class Status {

	public Boolean START() {
		return Config.GLOBAL_POPUPS.getBoolean(Config.getNode(), true);
	}

	public Boolean PAUSE() {
		return Config.GLOBAL_POPUPS.getBoolean(Config.getNode(), true);
	}

}

package me.dennis.autorestart.utils.config.private_popups.enabled;

import me.dennis.autorestart.utils.config.Config;

public class Status {

	public Boolean START() {
		return Config.getBoolean("private_popups.enabled.status.start", true);
	}

	public Boolean PAUSE() {
		return Config.getBoolean("private_popups.enabled.status.pause", true);
	}
	
}

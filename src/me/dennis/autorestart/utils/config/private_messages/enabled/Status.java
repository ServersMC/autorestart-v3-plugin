package me.dennis.autorestart.utils.config.private_messages.enabled;

import me.dennis.autorestart.utils.config.Config;

public class Status {

	public Boolean START() {
		return Config.getBoolean("private_messages.enabled.status.start", true);
	}

	public Boolean PAUSE() {
		return Config.getBoolean("private_messages.enabled.status.pause", true);
	}
	
}

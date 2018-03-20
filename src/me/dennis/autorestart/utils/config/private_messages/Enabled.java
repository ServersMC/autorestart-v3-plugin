package me.dennis.autorestart.utils.config.private_messages;

import me.dennis.autorestart.utils.config.Config;
import me.dennis.autorestart.utils.config.private_messages.enabled.Status;

public class Enabled {

	public Boolean TIME() {
		return Config.PRIVATE_MESSAGES.getBoolean(Config.getNode(), true);
	}

	public Status STATUS = new Status();
	
	public Boolean CHANGE() {
		return Config.PRIVATE_MESSAGES.getBoolean(Config.getNode(), true);
	}

	public Boolean PAUSE_REMINDER() {
		return Config.PRIVATE_MESSAGES.getBoolean(Config.getNode(), true);
	}

}

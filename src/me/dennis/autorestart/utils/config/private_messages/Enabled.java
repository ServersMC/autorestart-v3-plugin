package me.dennis.autorestart.utils.config.private_messages;

import me.dennis.autorestart.utils.config.Config;
import me.dennis.autorestart.utils.config.private_messages.enabled.Status;

public class Enabled {

	public Boolean TIME() {
		return Config.getBoolean("private_messages.enabled.time", true);
	}

	public Status STATUS = new Status();
	
	public Boolean CHANGE() {
		return Config.getBoolean("private_messages.enabled.change", true);
	}

	public Boolean PAUSE_REMINDER() {
		return Config.getBoolean("private_messages.enabled.pause_reminder", true);
	}

}

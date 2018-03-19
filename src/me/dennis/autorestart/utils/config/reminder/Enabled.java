package me.dennis.autorestart.utils.config.reminder;

import me.dennis.autorestart.utils.config.Config;

public class Enabled {

	public Boolean MINUTES() {
		return Config.getBoolean("reminder.enabled.minutes", true);
	}

	public Boolean SECONDS() {
		return Config.getBoolean("reminder.enabled.seconds", true);
	}
	
}

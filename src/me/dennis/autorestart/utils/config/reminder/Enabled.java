package me.dennis.autorestart.utils.config.reminder;

import me.dennis.autorestart.utils.config.Config;

public class Enabled {

	public Boolean MINUTES() {
		return Config.REMINDER.getBoolean(Config.getNode(), true);
	}

	public Boolean SECONDS() {
		return Config.REMINDER.getBoolean(Config.getNode(), true);
	}
	
}

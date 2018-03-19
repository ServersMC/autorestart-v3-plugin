package me.dennis.autorestart.utils.config.private_popups;

import me.dennis.autorestart.utils.config.Config;
import me.dennis.autorestart.utils.config.private_popups.enabled.Status;

public class Enabled {
	
	public Boolean TIME() {
		return Config.getBoolean(Config.getNode(), true);
	}

	public Status STATUS = new Status();
	
	public Boolean CHANGE() {
		return Config.getBoolean(Config.getNode(), true);
	}

	public Boolean PAUSE_REMINDER() {
		return Config.getBoolean(Config.getNode(), true);
	}

}

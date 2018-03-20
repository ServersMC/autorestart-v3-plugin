package me.dennis.autorestart.utils.config.global_popups;

import me.dennis.autorestart.utils.config.Config;
import me.dennis.autorestart.utils.config.global_popups.enabled.MaxPlayers;
import me.dennis.autorestart.utils.config.global_popups.enabled.Status;

public class Enabled {

	public Boolean MINUTES() {
		return Config.GLOBAL_POPUPS.getBoolean("global_popups.enabled.minutes", true);
	}

	public Boolean SECONDS() {
		return Config.GLOBAL_POPUPS.getBoolean("global_popups.enabled.seconds", true);
	}

	public Status STATUS = new Status();
	
	public Boolean CHANGE() {
		return Config.GLOBAL_POPUPS.getBoolean("global_popups.enabled.change", true);
	}

	public MaxPlayers MAX_PLAYERS = new MaxPlayers();
	
	public Boolean SHUTDOWN() {
		return Config.GLOBAL_POPUPS.getBoolean("global_popups.enabled.shutdown", true);
	}

}

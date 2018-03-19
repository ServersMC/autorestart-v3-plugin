package me.dennis.autorestart.utils.config.global_broadcast;

import me.dennis.autorestart.utils.config.Config;
import me.dennis.autorestart.utils.config.global_broadcast.enabled.MaxPlayers;
import me.dennis.autorestart.utils.config.global_broadcast.enabled.Status;

public class Enabled {

	public Boolean MINUTES() {
		return Config.getBoolean("global_broadcast.enabled.minutes", true);
	}

	public Boolean SECONDS() {
		return Config.getBoolean("global_broadcast.enabled.seconds", true);
	}

	public Status STATUS = new Status();

	public Boolean CHANGE() {
		return Config.getBoolean("global_broadcast.enabled.change", true);
	}

	public MaxPlayers MAX_PLAYERS = new MaxPlayers();
	
	public Boolean SHUTDOWN() {
		return Config.getBoolean("global_broadcast.enabled.shutdown", true);
	}

}

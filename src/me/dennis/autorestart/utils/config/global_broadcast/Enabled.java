package me.dennis.autorestart.utils.config.global_broadcast;

import me.dennis.autorestart.utils.config.Config;
import me.dennis.autorestart.utils.config.global_broadcast.enabled.MaxPlayers;
import me.dennis.autorestart.utils.config.global_broadcast.enabled.Status;

public class Enabled {

	public Boolean MINUTES() {
		return Config.GLOBAL_BROADCAST.getBoolean(Config.getNode(), true);
	}

	public Boolean SECONDS() {
		return Config.GLOBAL_BROADCAST.getBoolean(Config.getNode(), true);
	}

	public Status STATUS = new Status();

	public Boolean CHANGE() {
		return Config.GLOBAL_BROADCAST.getBoolean(Config.getNode(), true);
	}

	public MaxPlayers MAX_PLAYERS = new MaxPlayers();
	
	public Boolean SHUTDOWN() {
		return Config.GLOBAL_BROADCAST.getBoolean(Config.getNode(), true);
	}

}

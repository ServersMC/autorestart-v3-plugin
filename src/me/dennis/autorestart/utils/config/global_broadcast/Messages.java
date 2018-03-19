package me.dennis.autorestart.utils.config.global_broadcast;

import java.util.List;

import me.dennis.autorestart.utils.config.Config;
import me.dennis.autorestart.utils.config.global_broadcast.messages.MaxPlayers;
import me.dennis.autorestart.utils.config.global_broadcast.messages.Status;

public class Messages extends Config {

	public List<String> MINUTES() {
		return getStringList(Config.getNode());
	}

	public List<String> SECONDS() {
		return getStringList(Config.getNode());
	}

	public Status STATUS = new Status();
	
	public List<String> CHANGE() {
		return getStringList(Config.getNode());
	}

	public MaxPlayers MAX_PLAYERS = new MaxPlayers();
	
	public List<String> SHUTDOWN() {
		return getStringList(Config.getNode());
	}

}

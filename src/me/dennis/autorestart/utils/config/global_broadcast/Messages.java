package me.dennis.autorestart.utils.config.global_broadcast;

import java.util.List;

import me.dennis.autorestart.utils.config.Config;
import me.dennis.autorestart.utils.config.global_broadcast.messages.MaxPlayers;
import me.dennis.autorestart.utils.config.global_broadcast.messages.Status;

public class Messages extends Config {

	public List<String> MINUTES() {
		return getStringList("global_broadcast.messages.minutes");
	}

	public List<String> SECONDS() {
		return getStringList("global_broadcast.messages.seconds");
	}

	public Status STATUS = new Status();
	
	public List<String> CHANGE() {
		return getStringList("global_broadcast.messages.change");
	}

	public MaxPlayers MAX_PLAYERS = new MaxPlayers();
	
	public List<String> SHUTDOWN() {
		return getStringList("global_broadcast.messages.shutdown");
	}

}

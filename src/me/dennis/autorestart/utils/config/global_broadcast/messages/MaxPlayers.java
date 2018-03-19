package me.dennis.autorestart.utils.config.global_broadcast.messages;

import java.util.List;

import me.dennis.autorestart.utils.config.Config;

public class MaxPlayers extends Config {

	public List<String> ALERT() {
		return getStringList("global_broadcast.messages.max_players.alert");
	}

	public List<String> PRE_SHUTDOWN() {
		return getStringList("global_broadcast.messages.max_players.pre_shutdown");
	}
	
}

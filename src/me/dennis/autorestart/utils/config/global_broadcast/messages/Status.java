package me.dennis.autorestart.utils.config.global_broadcast.messages;

import java.util.List;

import me.dennis.autorestart.utils.config.Config;

public class Status extends Config {

	public List<String> START() {
		return getStringList("global_broadcast.messages.status.start");
	}

	public List<String> PAUSE() {
		return getStringList("global_broadcast.messages.status.pause");
	}
	
}

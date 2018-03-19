package me.dennis.autorestart.utils.config.private_messages.messages;

import java.util.List;

import me.dennis.autorestart.utils.config.Config;

public class Status {

	public List<String> START() {
		return Config.getStringList(Config.getNode());
	}

	public List<String> PAUSE() {
		return Config.getStringList(Config.getNode());
	}
	
}

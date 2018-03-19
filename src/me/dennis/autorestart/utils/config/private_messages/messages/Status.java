package me.dennis.autorestart.utils.config.private_messages.messages;

import java.util.List;

import me.dennis.autorestart.utils.config.Config;

public class Status extends Config {

	public List<String> START() {
		return getStringList("private_messages.messages.status.start");
	}

	public List<String> PAUSE() {
		return getStringList("private_messages.messages.status.pause");
	}
	
}

package me.dennis.autorestart.utils.config.private_messages;

import java.util.List;

import me.dennis.autorestart.utils.config.Config;
import me.dennis.autorestart.utils.config.private_messages.messages.Status;

public class Messages {

	public List<String> TIME() {
		return Config.PRIVATE_MESSAGES.getStringList(Config.getNode());
	}

	public Status STATUS = new Status();
	
	public List<String> CHANGE() {
		return Config.PRIVATE_MESSAGES.getStringList(Config.getNode());
	}

	public List<String> PAUSE_REMINDER() {
		return Config.PRIVATE_MESSAGES.getStringList(Config.getNode());
	}

}

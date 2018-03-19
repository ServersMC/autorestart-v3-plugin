package me.dennis.autorestart.utils.config.private_messages;

import java.util.List;

import me.dennis.autorestart.utils.config.Config;
import me.dennis.autorestart.utils.config.private_messages.messages.Status;

public class Messages extends Config {

	public List<String> TIME() {
		return getStringList("private_messages.messages.time");
	}

	public Status STATUS = new Status();
	
	public List<String> CHANGE() {
		return getStringList("private_messages.messages.change");
	}

	public List<String> PAUSE_REMINDER() {
		return getStringList("private_messages.messages.pause_reminder");
	}

}

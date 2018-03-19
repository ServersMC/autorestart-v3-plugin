package me.dennis.autorestart.utils.config;

import java.util.List;

import me.dennis.autorestart.utils.config.reminder.Enabled;

public class Reminder {

	public Enabled ENABLED = new Enabled();

	public List<Integer> MINUTES() {
		return Config.getIntegerList(Config.getNode());
	}

	public Integer SECONDS() {
		return Config.getInteger(Config.getNode(), 5);
	}

	public Integer PAUSE_REMINDER() {
		return Config.getInteger(Config.getNode(), 10);
	}

}

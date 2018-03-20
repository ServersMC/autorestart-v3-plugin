package me.dennis.autorestart.utils.config;

import java.util.List;

import me.dennis.autorestart.objects.ConfigFile;
import me.dennis.autorestart.utils.config.reminder.Enabled;

public class Reminder extends ConfigFile {

	public Enabled ENABLED = new Enabled();

	public List<Integer> MINUTES() {
		return Config.REMINDER.getIntegerList(Config.getNode());
	}

	public Integer SECONDS() {
		return Config.REMINDER.getInteger(Config.getNode(), 5);
	}

	public Integer PAUSE_REMINDER() {
		return Config.REMINDER.getInteger(Config.getNode(), 10);
	}

}

package me.dennis.autorestart.utils.config;

import me.dennis.autorestart.objects.ConfigFile;
import me.dennis.autorestart.utils.config.global_popups.Enabled;
import me.dennis.autorestart.utils.config.global_popups.Messages;

public class GlobalPopups extends ConfigFile {

	public Enabled ENABLED = new Enabled();

	public Messages MESSAGES = new Messages();
	
}

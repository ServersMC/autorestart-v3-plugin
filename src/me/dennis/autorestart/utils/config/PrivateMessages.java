package me.dennis.autorestart.utils.config;

import me.dennis.autorestart.objects.ConfigFile;
import me.dennis.autorestart.utils.config.private_messages.Enabled;
import me.dennis.autorestart.utils.config.private_messages.Messages;

public class PrivateMessages extends ConfigFile {

	public Enabled ENABLED = new Enabled();
	
	public Messages MESSAGES = new Messages();
	
}

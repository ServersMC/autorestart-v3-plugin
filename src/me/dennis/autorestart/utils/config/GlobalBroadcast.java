package me.dennis.autorestart.utils.config;

import me.dennis.autorestart.objects.ConfigFile;
import me.dennis.autorestart.utils.config.global_broadcast.Enabled;
import me.dennis.autorestart.utils.config.global_broadcast.Messages;

public class GlobalBroadcast extends ConfigFile {

	public Enabled ENABLED = new Enabled();
	
	public Messages MESSAGES = new Messages();
	
}

package me.dennis.autorestart.utils.config.private_popups.messages;

import me.dennis.autorestart.objects.ConfigPopup;

public class Status {

	public ConfigPopup START = new ConfigPopup("private_popups.messages.status.start", "&cYou started AutoRestart back up!", "", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});
	
	public ConfigPopup PAUSE = new ConfigPopup("private_popups.messages.status.pause", "&cYou have paused AutoRestart!", "", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});
	
}

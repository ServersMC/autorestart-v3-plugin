package me.dennis.autorestart.utils.config.global_popups.messages;

import me.dennis.autorestart.objects.ConfigPopup;

public class Status {

	public ConfigPopup START = new ConfigPopup("global_popups.messages.status.start", "&cAutoRestart has started!", "", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});
	
	public ConfigPopup PAUSE = new ConfigPopup("global_popups.messages.status.pause", "&cAutoRestart has been paused!", "", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});
	
}

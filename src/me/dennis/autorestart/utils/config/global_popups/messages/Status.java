package me.dennis.autorestart.utils.config.global_popups.messages;

import me.dennis.autorestart.objects.ConfigPopup;
import me.dennis.autorestart.utils.config.Config;

public class Status {

	public ConfigPopup START() {
		return new ConfigPopup(Config.GLOBAL_POPUPS, Config.getNode(), "&cAutoRestart has started!", "", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});
	}
	
	public ConfigPopup PAUSE() {
		return new ConfigPopup(Config.GLOBAL_POPUPS, Config.getNode(), "&cAutoRestart has been paused!", "", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});
	}
	
}

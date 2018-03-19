package me.dennis.autorestart.utils.config.private_popups.messages;

import me.dennis.autorestart.objects.ConfigPopup;
import me.dennis.autorestart.utils.config.Config;

public class Status {

	public ConfigPopup START() {
		return new ConfigPopup(Config.getNode(), "&cYou started AutoRestart back up!", "", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});
	}
	
	public ConfigPopup PAUSE() {
		return new ConfigPopup(Config.getNode(), "&cYou have paused AutoRestart!", "", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});
	}
	
}

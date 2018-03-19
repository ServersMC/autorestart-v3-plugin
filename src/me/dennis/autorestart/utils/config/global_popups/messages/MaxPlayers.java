package me.dennis.autorestart.utils.config.global_popups.messages;

import me.dennis.autorestart.objects.ConfigPopup;
import me.dennis.autorestart.utils.config.Config;

public class MaxPlayers {

	public ConfigPopup ALERT() {
		return new ConfigPopup(Config.getNode(), "&bToo many players online for restart.", "Max &f%a&b amount of players allowed for a restart.", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});
	}
	
	public ConfigPopup PRE_SHUTDOWN() {
		return new ConfigPopup(Config.getNode(), "&aServer now restarting in &f%d&a seconds!", "", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});
	}
	
}

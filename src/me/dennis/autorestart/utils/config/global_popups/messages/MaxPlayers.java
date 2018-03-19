package me.dennis.autorestart.utils.config.global_popups.messages;

import me.dennis.autorestart.objects.ConfigPopup;

public class MaxPlayers {

	public ConfigPopup ALERT = new ConfigPopup("global_popups.messages.max_players.alert", "&bToo many players online for restart.", "Max &f%a&b amount of players allowed for a restart.", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});

	public ConfigPopup PRE_SHUTDOWN = new ConfigPopup("global_popups.messages.max_players.pre_shutdown", "&aServer now restarting in &f%d&a seconds!", "", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});
	
}

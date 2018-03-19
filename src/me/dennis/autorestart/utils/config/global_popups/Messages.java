package me.dennis.autorestart.utils.config.global_popups;

import me.dennis.autorestart.objects.ConfigPopup;
import me.dennis.autorestart.utils.config.Config;
import me.dennis.autorestart.utils.config.global_popups.messages.MaxPlayers;
import me.dennis.autorestart.utils.config.global_popups.messages.Status;

public class Messages extends Config {

	public ConfigPopup MINUTES() {
		return new ConfigPopup(Config.getNode(), "&cServer Restarting In", "&f%m &cMinutes!", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});
	}
	
	public ConfigPopup SECONDS() {
		return new ConfigPopup(Config.getNode(), "&cServer Restarting In", "&f%s &cSeconds!", new Integer[]{5, 20, 5}, new Integer[]{5, 10, 5});
	}
	
	public Status STATUS = new Status();

	public ConfigPopup CHANGE() {
		return new ConfigPopup(Config.getNode(), "&cServer Restarting In", "&f%h&cH &f%m&cM &f%s&cS!", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});
	}

	public MaxPlayers MAX_PLAYERS = new MaxPlayers();

	public ConfigPopup SHUTDOWN() {
		return new ConfigPopup(Config.getNode(), "&cServer is now", "&cRestarting!", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});
	}
	
}

package me.dennis.autorestart.utils.config.global_popups;

import me.dennis.autorestart.objects.ConfigPopup;
import me.dennis.autorestart.utils.config.Config;
import me.dennis.autorestart.utils.config.global_popups.messages.MaxPlayers;
import me.dennis.autorestart.utils.config.global_popups.messages.Status;

public class Messages extends Config {

	public ConfigPopup MINUTES = new ConfigPopup("global_popups.messages.minutes", "&cServer Restarting In", "&f%m &cMinutes!", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});
	
	public ConfigPopup SECONDS = new ConfigPopup("global_popups.messages.seconds", "&cServer Restarting In", "&f%s &cSeconds!", new Integer[]{5, 20, 5}, new Integer[]{5, 10, 5});
	
	public Status STATUS = new Status();

	public ConfigPopup CHANGE = new ConfigPopup("global_popups.messages.change", "&cServer Restarting In", "&f%h&cH &f%m&cM &f%s&cS!", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});

	public MaxPlayers MAX_PLAYERS = new MaxPlayers();

	public ConfigPopup SHUTDOWN = new ConfigPopup("global_popups.messages.shutdown", "&cServer is now", "&cRestarting!", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});
	
}

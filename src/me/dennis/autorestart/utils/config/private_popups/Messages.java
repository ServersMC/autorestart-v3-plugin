package me.dennis.autorestart.utils.config.private_popups;

import me.dennis.autorestart.objects.ConfigPopup;
import me.dennis.autorestart.utils.config.Config;
import me.dennis.autorestart.utils.config.private_popups.messages.Status;

public class Messages {

	public ConfigPopup TIME() {
		return new ConfigPopup(Config.PRIVATE_POPUPS, Config.getNode(), "&cServer Restarting In", "&f%h&cH &f%m&cM &f%s&cS!", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});
	}
	
	public Status STATUS = new Status();
	
	public ConfigPopup CHANGE() {
		return new ConfigPopup(Config.PRIVATE_POPUPS, Config.getNode(), "&cServer Restarting In", "&f%h&cH &f%m&cM &f%s&cS!", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});
	}
	
	public ConfigPopup PAUSE_REMINDER() {
		return new ConfigPopup(Config.PRIVATE_POPUPS, Config.getNode(), "&cDont forget that", "&cAutoRestart timer is still paused!", new Integer[]{20, 40, 20}, new Integer[]{20, 40, 20});
	}
	
}

package me.dennis.autorestart.utils.config;

public class MaxPlayers {

	public Boolean ENABLED() {
		return Config.getBoolean(Config.getNode(), true);
	}

	public Integer AMOUNT() {
		return Config.getInteger(Config.getNode(), 10);
	}

	public Integer DELAY() {
		return Config.getInteger(Config.getNode(), 10);
	}

}

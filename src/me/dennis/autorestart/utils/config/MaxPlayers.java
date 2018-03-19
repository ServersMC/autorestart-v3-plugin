package me.dennis.autorestart.utils.config;

public class MaxPlayers {

	public Boolean ENABLED() {
		return Config.getBoolean("max_players.enabled", true);
	}

	public Integer AMOUNT() {
		return Config.getInteger("max_players.amount", 10);
	}

	public Integer DELAY() {
		return Config.getInteger("max_players.delay", 10);
	}

}

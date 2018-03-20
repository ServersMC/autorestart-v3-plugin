package me.dennis.autorestart.utils.config;

import me.dennis.autorestart.objects.ConfigFile;
import me.dennis.autorestart.utils.config.main.Modes;

public class Main extends ConfigFile {

	public String RESTART_MODE() {
		return Config.MAIN.getString(Config.getNode(), "interval");
	}

	public Modes MODES = new Modes();

	public String PREFIX() {
		return Config.MAIN.getString(Config.getNode(), "&f[&7AutoRestart&f] &e");
	}

	public String KICK_MESSAGE() {
		return Config.MAIN.getString(Config.getNode(), "&cServer Restarting! We will be back up any minute!");
	}

}

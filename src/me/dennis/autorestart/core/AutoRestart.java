package me.dennis.autorestart.core;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.dennis.autorestart.commands.CmdAutoRestart;
import me.dennis.autorestart.utils.Config;
import me.dennis.autorestart.utils.Console;


public class AutoRestart extends JavaPlugin {

	public static AutoRestart PLUGIN;
	public static String VERSION;
	public static TimerThread TIMER = new TimerThread();
	
	@Override
	public void onEnable() {
		// Plug-in
		PLUGIN = this;
		VERSION = getDescription().getVersion();
		
		// Configuration file
		Config.setConfig(getConfig());

		// Command
		new CmdAutoRestart();
		CmdAutoRestart.setupSubCommands();
		Bukkit.getPluginCommand("autore").setExecutor(new CmdAutoRestart());
		
		// Timer
		TIMER.calculateTimer();
		new Thread(TIMER).start();
		
		// Done
		Console.info("Loaded!");
	}
	
}

package me.dennis.autorestart.core;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.dennis.autorestart.commands.CmdAutoRestart;
import me.dennis.autorestart.enums.FileEnum;
import me.dennis.autorestart.objects.ConfigFile;
import me.dennis.autorestart.utils.Console;
import me.dennis.autorestart.utils.Metrics;
import me.dennis.autorestart.utils.UpdateChecker;

public class AutoRestart extends JavaPlugin {

	public static AutoRestart PLUGIN;
	public static String VERSION;
	public static Metrics METRICS;
	public static TimerThread TIMER = new TimerThread();

	@Override
	public void onEnable() {
		try {
			// Plugin variables
			PLUGIN = this;
			VERSION = getDescription().getVersion();
			METRICS = new Metrics(PLUGIN);

			// Setup plugin folder if does not exist
			getDataFolder().mkdirs();

			// Setup files
			for (FileEnum file : FileEnum.values()) {
				file.setup();
			}

			// Configuration file
			ConfigFile.setupConfigFiles();
			ConfigFile.loadConfig();
			ConfigFile.updateConfig();

			// Event register
			Bukkit.getPluginManager().registerEvents(new UpdateChecker(), PLUGIN);
			
			// Command setup
			new CmdAutoRestart();
			CmdAutoRestart.setupSubCommands();
			Bukkit.getPluginCommand("autore").setExecutor(new CmdAutoRestart());

			// Timer thread
			TIMER.calculateTimer();
			new Thread(TIMER).start();
			
			// Check for updates
			Bukkit.getScheduler().scheduleSyncDelayedTask(PLUGIN, () -> {
				UpdateChecker.checkUpdate();
				if (UpdateChecker.UPDATE_FOUND) {
					Console.warn("There is a new version of AutoRestart! Go get it now! Latest version: v" + UpdateChecker.LATEST_VERSION);
				}
				else {
					Console.info("Up to date!");
				}
			});
			
			// Done
			Console.info("Loaded!");
		} catch (Exception e) {
			Console.catchError(e, "UNFILTERED ERROR");
		}
	}
	
}

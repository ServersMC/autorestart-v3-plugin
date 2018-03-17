package me.dennis.autorestart.core;

import java.io.File;
import java.util.Calendar;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.dennis.autorestart.commands.CmdAutoRestart;
import me.dennis.autorestart.enums.FileEnum;
import me.dennis.autorestart.utils.Config;
import me.dennis.autorestart.utils.Console;
import me.dennis.autorestart.utils.UpdateChecker;

public class AutoRestart extends JavaPlugin {

	public static AutoRestart PLUGIN;
	public static String VERSION;
	public static TimerThread TIMER = new TimerThread();

	@Override
	public void onEnable() {
		try {
			// Plug-in
			PLUGIN = this;
			VERSION = getDescription().getVersion();

			// Setup plugin folder if does not exist
			getDataFolder().mkdirs();

			// Setup files
			for (FileEnum file : FileEnum.values()) {
				file.setup();
			}

			// Configuration file
			Config.setConfig(getConfig());
			Integer configVersion = getConfig().getDefaults().getInt("version");
			Integer configVersionLoaded = Config.VERSION;
			if (configVersion != configVersionLoaded) {
				Calendar cal = Calendar.getInstance();
				Console.warn("The config has updated since the last update!");
				File config = new File(getDataFolder(), "config.yml");
				File rename = new File(getDataFolder(), "config (" + cal.getTime().toString().replaceAll(":", "_") + ").yml");
				if (rename.exists()) {
					rename.delete();
				}
				config.renameTo(rename);
				saveResource(config.getName(), true);
				Console.warn("Config file has been backed up to " + rename.getName() + "!");
			}

			// Command setup
			new CmdAutoRestart();
			CmdAutoRestart.setupSubCommands();
			Bukkit.getPluginCommand("autore").setExecutor(new CmdAutoRestart());

			// Timer thread
			TIMER.calculateTimer();
			new Thread(TIMER).start();

			// Done
			Console.info("Loaded!");
			
			// Check for updates
			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				@Override
				public void run() {
					if (UpdateChecker.checkUpdate()) {
						Console.warn("There is a new version of AutoRestart! Go get it now!");
					}
					else {
						Console.info("Up to date!");
					}
				}
			});
		} catch (Exception e) {
			Console.catchError(e, "Unfiltered Error!");
		}
	}

}

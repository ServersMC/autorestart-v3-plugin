package me.dennis.autorestart.core;

import java.io.File;
import java.util.Calendar;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.dennis.autorestart.commands.CmdAutoRestart;
import me.dennis.autorestart.enums.FileEnum;
import me.dennis.autorestart.utils.Console;
import me.dennis.autorestart.utils.Metrics;
import me.dennis.autorestart.utils.UpdateChecker;
import me.dennis.autorestart.utils.config.Config;

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
			Console.catchError(e, "Unfiltered Error!");
		}
	}

}

package me.dennis.autorestart.objects;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.dennis.autorestart.core.AutoRestart;
import me.dennis.autorestart.utils.Console;
import me.dennis.autorestart.utils.config.Config;

public abstract class ConfigFile {

	// STATIC CLASS
	
	private static List<ConfigFile> configs = new ArrayList<ConfigFile>();
	
	public static void setupConfigFiles() {
		configs.add(Config.MAIN);
		configs.add(Config.REMINDER);
		configs.add(Config.GLOBAL_BROADCAST);
		configs.add(Config.PRIVATE_MESSAGES);
		configs.add(Config.GLOBAL_POPUPS);
		configs.add(Config.PRIVATE_POPUPS);
		configs.add(Config.COMMANDS);
		configs.add(Config.MAX_PLAYERS);
	}
	
	public static void loadConfig() {
		for (ConfigFile config : configs) {
			// Load configuration from plugin folder
			config.CONFIG = YamlConfiguration.loadConfiguration(config.CONFIG_FILE);
			
			// Load configuration from jar file
			InputStream fileStream = AutoRestart.PLUGIN.getResource(config.CONFIG_FILE.getName());
			FileConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(fileStream));
			
			// Set jar file configuration to defaults
			config.CONFIG.setDefaults(defaultConfig);
			
			// Set current version from plugin folder
			config.VERSION = config.CONFIG.getInt("version", 0);
		}
	}
	
	public static void updateConfig() {
		for (ConfigFile config : configs) {
			
			// Get version numbers
			Integer latestVersion = config.CONFIG.getDefaults().getInt("version");
			Integer currentVersion = config.VERSION;
			
			// Check if versions match
			if (latestVersion != currentVersion) {
				
				// Notify console about update
				Console.warn("The config file " + config.CONFIG_FILE.getName() + " has updated since the last update!");
				
				// Create rename file
				Calendar cal = Calendar.getInstance();
				File rename = new File(AutoRestart.PLUGIN.getDataFolder(), "(" + cal.getTime().toString().replaceAll(":", "_") + ") " + config.CONFIG_FILE.getName());
				
				// Check if already exists (should never happen)
				if (rename.exists()) {
					rename.delete();
				}
				
				// Renamed out dated configuration file
				new File(config.CONFIG_FILE.getPath()).renameTo(rename);
				
				// Save new configuration file
				AutoRestart.PLUGIN.saveResource(config.CONFIG_FILE.getName(), true);
				
				// Notify Console
				Console.warn("Config file has been backed up to " + rename.getName() + "!");
				
				// Reload configuration file
				Console.warn(config.CONFIG_FILE.getName());
				config.CONFIG = YamlConfiguration.loadConfiguration(config.CONFIG_FILE);
			}
		}
	}
	
	// OBJECT CLASS
	
	private Integer VERSION;
	private FileConfiguration CONFIG;
	private File CONFIG_FILE;

	public ConfigFile() {
		// Get class name of ConfigFile
		String fileName = Thread.currentThread().getStackTrace()[2].getFileName().split("\\.")[0] + ".yml";
		
		// Declare configuration File.class
		CONFIG_FILE = new File(AutoRestart.PLUGIN.getDataFolder(), fileName);
		
		// Check if configuration file exists
		if (!CONFIG_FILE.exists()) {
			
			// Save file
			AutoRestart.PLUGIN.saveResource(fileName, true);
			
			// Message console
			Console.info("Created " + fileName + " config file!");
			
		}
	}

    public String getString(String node, String defaultValue) {
		return CONFIG.getString(node, defaultValue);
	}
    
    public Integer getInteger(String node, Integer defaultValue) {
		return CONFIG.getInt(node, defaultValue);
	}
    
    public Double getDouble(String node, Double defaultValue) {
		return CONFIG.getDouble(node, defaultValue);
	}
    
    public Boolean getBoolean(String node, Boolean defaultValue) {
		return CONFIG.getBoolean(node, defaultValue);
	}
    
    public List<Integer> getIntegerList(String node) {
		return CONFIG.getIntegerList(node);
	}
    
    public List<String> getStringList(String node) {
		return CONFIG.getStringList(node);
	}

}

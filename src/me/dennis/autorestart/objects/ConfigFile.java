package me.dennis.autorestart.objects;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.dennis.autorestart.core.AutoRestart;
import me.dennis.autorestart.utils.Console;

public abstract class ConfigFile {

	// STATIC CLASS
	
	private static List<ConfigFile> configs = new ArrayList<ConfigFile>();
	
	public static void loadConfig() {
		for (ConfigFile config : configs) {
			config.CONFIG = YamlConfiguration.loadConfiguration(config.CONFIG_FILE);
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
				config.CONFIG_FILE.renameTo(rename);
				
				// Save new configuration file
				AutoRestart.PLUGIN.saveResource(config.CONFIG_FILE.getName(), true);
				
				// Notify Console
				Console.warn("Config file has been backed up to " + rename.getName() + "!");
				
				// Reload configuration file
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
		String className = Thread.currentThread().getStackTrace()[2].getFileName().split("\\.")[0];
		
		// Convert class name to file name
		String fileName = "";
		for (int i = 0; i < className.length(); i++) {
			char c = className.charAt(i);
			
			// Check if character is upper case
			if (i != 0) {
				if (Character.isUpperCase(c)) {
					fileName += "_";
				}
			}
			
			// Append character to fileName string
			fileName += Character.toString(c).toLowerCase();
		}
		// Append file extension
		fileName += ".config.yml";
		
		// Declare configuration File.class
		CONFIG_FILE = new File(AutoRestart.PLUGIN.getDataFolder(), fileName);
		
		// Check if configuration file exists
		if (!CONFIG_FILE.exists()) {
			
			// save file
			AutoRestart.PLUGIN.saveResource(fileName, true);
			
			// Message console
			Console.info("Created " + fileName);
			
		}
		
		// Add self to static list
		configs.add(this);
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

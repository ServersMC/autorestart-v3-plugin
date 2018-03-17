package me.dennis.autorestart.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Console {
    
    public static void info(String s) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[AutoRestart] " + s);
    }
    
    public static void warn(String s) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[AutoRestart] " + s);
    }
    
    public static void err(String s) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[AutoRestart] " + s);
    }
    
    public static void consoleSendMessage(String s) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', s));
    }

	public static void catchError(Exception e, String loc) {
		// Error exception catch
		err("There was an error in " + loc + ". If this is common, please PM error to ServersMC via PasteBin, or quickly send bug with /autore senderror");
		e.printStackTrace();
		err("End of error");
	}
    
}

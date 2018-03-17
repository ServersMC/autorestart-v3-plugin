package me.dennis.autorestart.types;

import org.bukkit.command.CommandSender;

public abstract class AutoCommand {
	
	public abstract void execute(CommandSender sender, String[] args);
	public abstract String getLabel();
	public abstract String getDescription();
	public abstract String getPermission();
	public abstract String getUsage();
	
	
}

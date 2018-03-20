package me.dennis.autorestart.commands.autore;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import me.dennis.autorestart.abstracts.AutoCommand;
import me.dennis.autorestart.core.AutoRestart;
import me.dennis.autorestart.objects.ConfigFile;

public class CmdReload extends AutoCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		ConfigFile.loadConfig();
		AutoRestart.TIMER.calculateTimer();
		sender.sendMessage(ChatColor.GRAY + "Config has been reloaded!");
	}

	@Override
	public String getLabel() {
		return "RELOAD";
	}

	@Override
	public String getDescription() {
		return "Reloads AutoRestart config.";
	}

	@Override
	public String getPermission() {
		return "autorestart.reload";
	}

	@Override
	public String getUsage() {
		return "/autore reload";
	}

}

package me.dennis.autorestart.commands.autore;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import me.dennis.autorestart.abstracts.AutoCommand;
import me.dennis.autorestart.core.AutoRestart;

public class CmdNow extends AutoCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		sender.sendMessage(ChatColor.GRAY + "Restarting server!");
		AutoRestart.TIMER.TIME = 0;
	}

	@Override
	public String getLabel() {
		return "NOW";
	}

	@Override
	public String getDescription() {
		return "Force restarts server.";
	}

	@Override
	public String getPermission() {
		return "autorestart.now";
	}

	@Override
	public String getUsage() {
		return "/autore now";
	}

}

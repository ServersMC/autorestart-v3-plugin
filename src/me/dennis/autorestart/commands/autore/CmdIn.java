package me.dennis.autorestart.commands.autore;

import org.bukkit.command.CommandSender;

import me.dennis.autorestart.types.AutoCommand;

public class CmdIn extends AutoCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
	}

	@Override
	public String getLabel() {
		return "IN";
	}

	@Override
	public String getDescription() {
		return "Changes restart time in minutes.";
	}

	@Override
	public String getPermission() {
		return "autorestart.in";
	}

	@Override
	public String getUsage() {
		return "/autore in <minutes>";
	}

}

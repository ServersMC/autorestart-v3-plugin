package me.dennis.autorestart.commands.autore;

import org.bukkit.command.CommandSender;

import me.dennis.autorestart.types.AutoCommand;
import me.dennis.autorestart.utils.Messenger;

public class CmdTime extends AutoCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		Messenger.messageSenderTime(sender);
	}

	@Override
	public String getLabel() {
		return "TIME";
	}

	@Override
	public String getDescription() {
		return "Shows current restart countdown.";
	}

	@Override
	public String getPermission() {
		return null;
	}

	@Override
	public String getUsage() {
		return "/autore time";
	}

}

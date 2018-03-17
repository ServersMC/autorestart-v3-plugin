package me.dennis.autorestart.commands.autore;

import static org.bukkit.ChatColor.*;
import org.bukkit.command.CommandSender;

import me.dennis.autorestart.commands.CmdAutoRestart;
import me.dennis.autorestart.types.AutoCommand;

public class CmdHelp extends AutoCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		for (AutoCommand cmd : CmdAutoRestart.subCommands) {
			// Check if player has permission
			if (cmd.getPermission() != null) {
				if (!sender.hasPermission(cmd.getPermission())) {
					continue;
				}
			}
			
			// Outputs command usage and description
			sender.sendMessage(GRAY + cmd.getUsage() + RED + " - " + GRAY + cmd.getDescription());
		}
	}

	@Override
	public String getLabel() {
		return "HELP";
	}

	@Override
	public String getDescription() {
		return "Shows this help screen.";	
	}

	@Override
	public String getPermission() {
		return null;
	}

	@Override
	public String getUsage() {
		return "/autore help";
	}

}

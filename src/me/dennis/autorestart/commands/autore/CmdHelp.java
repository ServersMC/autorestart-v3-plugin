package me.dennis.autorestart.commands.autore;

import static org.bukkit.ChatColor.*;
import org.bukkit.command.CommandSender;

import me.dennis.autorestart.commands.CmdAutoRestart;
import me.dennis.autorestart.types.AutoCommand;

public class CmdHelp extends AutoCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		// Check if argument number requirement meet
		if (args.length == 0) {
			
			// List Sub Commands usage and Descriptions
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
		else {
			// TODO Add help dictionary
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
		return "/autore help <command>";
	}

}

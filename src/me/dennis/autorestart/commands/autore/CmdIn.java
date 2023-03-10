package me.dennis.autorestart.commands.autore;

import static org.bukkit.ChatColor.*;

import org.bukkit.command.CommandSender;

import me.dennis.autorestart.abstracts.AutoCommand;
import me.dennis.autorestart.core.AutoRestart;
import me.dennis.autorestart.utils.Messenger;

public class CmdIn extends AutoCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		// Checks if enough arguments are present
		if (args.length == 0) {
			sender.sendMessage(RED + "Not enough arguments! Try: /autore help in");
			return;
		}
		
		// Variable initialization
		int time = 0;
		
		// Argument adding/parsing loop
		for (String arg : args) {
			try {
				// Split argument
				String[] vars = arg.split(":");
				if (vars.length != 2) {
					sender.sendMessage(RED + "Please follow format! Try: /autore help in");
					return;
				}
				int number = Integer.parseInt(vars[0]);
				String type = vars[1].toUpperCase();
				
				// Check type and add with appropriate product
				switch(type) {
				case "H":
					time += number * 3600;
					break;
				case "M":
					time += number * 60;
					break;
				case "S":
					time += number;
					break;
				default:
					sender.sendMessage(RED + "Unknown suffix \"" + type + "\"! Try: /autore help in");
					return;
				}
			} catch (NumberFormatException e) {
				sender.sendMessage(RED + "Please enter a number! Try: /autore help in");
				return;
			}
		}
		
		// Update timer thread with new time value
		AutoRestart.TIMER.TIME = time;
		
		// Send updated time to appropriate players (Method automatically sorts who gets what message, and pop ups)
		Messenger.broadcastChange(sender);
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
		return "/autore in [hours]:h [minutes]:m [seconds]:s";
	}

}

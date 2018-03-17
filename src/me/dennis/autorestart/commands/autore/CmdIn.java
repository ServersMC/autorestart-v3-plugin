package me.dennis.autorestart.commands.autore;

import static org.bukkit.ChatColor.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dennis.autorestart.core.AutoRestart;
import me.dennis.autorestart.types.AutoCommand;
import me.dennis.autorestart.types.HMS;
import me.dennis.autorestart.utils.Console;
import me.dennis.autorestart.utils.TimerParser;
import me.dennis.autorestart.utils.TitleAPI;

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
		
		// Send updated time to sender
		HMS hms = TimerParser.parseToHMS(AutoRestart.TIMER.TIME);
		sender.sendMessage(GRAY + "Server now restarting in" + RED + hms.H + GRAY + " Hours " + RED + hms.M + GRAY + " Minutes and " + RED + hms.S + GRAY + " Seconds!");
		Console.consoleSendMessage(" Command execution successful: Server now restarting in" + hms.H + " Hours " + hms.M + " Minutes and " + hms.S + " Seconds!");
		if (sender instanceof Player) {
			Player player = (Player) sender;
			TitleAPI.sendTitle(player, 10, 40, 10, RED + "Server now restarting in", RED + hms.H.toString() + GRAY + " Hours " + RED + hms.M + GRAY + " Minutes and " + RED + hms.S + GRAY + " Seconds!");
		}
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

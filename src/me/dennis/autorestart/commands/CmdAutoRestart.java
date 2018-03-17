package me.dennis.autorestart.commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.dennis.autorestart.commands.autore.*;
import me.dennis.autorestart.core.AutoRestart;
import me.dennis.autorestart.types.AutoCommand;

public class CmdAutoRestart implements CommandExecutor {

	public static ArrayList<AutoCommand> subCommands = new ArrayList<AutoCommand>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		sender.sendMessage(ChatColor.RED + "AutoRestart " + ChatColor.GRAY + "- v" + AutoRestart.VERSION);
		if (args.length == 0) {
			sender.sendMessage(ChatColor.RED + "Not enough arguments. Try: /autore help");
		}
		else {
			// Sub command arguments list trimmer
			ArrayList<String> argsList = new ArrayList<String>();
			for (String arg : args) {
				argsList.add(arg);
			}
			argsList.remove(0);
			
			// Sub command iteration
			String subCmdLabel = args[0];
			for (AutoCommand autoSubCmd : subCommands) {
				
				// Check if label matches sub command label
				if (autoSubCmd.getLabel().equalsIgnoreCase(subCmdLabel)) {
					
					// Check if sender has permission
					if (autoSubCmd.getPermission() != null) {
						if (!sender.hasPermission(autoSubCmd.getPermission())) {
							
							// Not enough permissions error
							sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
							return true;
						}
					}

					autoSubCmd.execute(sender, (String[]) argsList.toArray(new String[argsList.size()]));
					return true;
				}
			}
			
			// Unknown sub command (will be stopped by return statement)
			sender.sendMessage(ChatColor.RED + "Unknown sub command. Try: /autore help");
		}
		
		return true;
	}
	
	public static void setupSubCommands() {
		subCommands.add(new CmdHelp());
		subCommands.add(new CmdIn());
		subCommands.add(new CmdNow());
	}

}

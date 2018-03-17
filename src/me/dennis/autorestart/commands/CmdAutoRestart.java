package me.dennis.autorestart.commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.dennis.autorestart.commands.autore.*;
import me.dennis.autorestart.core.AutoRestart;
import me.dennis.autorestart.types.AutoCommand;
import me.dennis.autorestart.utils.Console;

public class CmdAutoRestart implements CommandExecutor {

	public static ArrayList<AutoCommand> subCommands = new ArrayList<AutoCommand>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// Default command text header
		sender.sendMessage(ChatColor.RED + "AutoRestart " + ChatColor.GRAY + "- v" + AutoRestart.VERSION);
		
		// Check if argument length requirement meet
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
							Console.consoleSendMessage(" Does not have permission");
							return true;
						}
					}

					// Executes sub command
					try {
						autoSubCmd.execute(sender, (String[]) argsList.toArray(new String[argsList.size()]));
					} catch(Exception e) {
						Console.catchError(e, "CmdAutoRestart.onCommand():" + autoSubCmd.getLabel());
					}
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
		subCommands.add(new CmdPause());
		subCommands.add(new CmdReload());
		subCommands.add(new CmdStart());
		subCommands.add(new CmdTime());
	}

}

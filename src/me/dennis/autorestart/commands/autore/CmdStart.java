package me.dennis.autorestart.commands.autore;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import me.dennis.autorestart.core.AutoRestart;
import me.dennis.autorestart.types.AutoCommand;
import me.dennis.autorestart.utils.Console;
import me.dennis.autorestart.utils.Messenger;
import net.md_5.bungee.api.ChatColor;

public class CmdStart extends AutoCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (AutoRestart.TIMER.PAUSED) {
			AutoRestart.TIMER.PAUSED = false;
			Messenger.broadcastStatusStart(sender);
		}
		else {
			sender.sendMessage(ChatColor.RED + "Timer is already counting down.");
			if (sender instanceof ConsoleCommandSender) {
				Console.consoleSendMessage(" Tried to use command, but timer is already counting down.");
			}
		}
	}

	@Override
	public String getLabel() {
		return "START";
	}

	@Override
	public String getDescription() {
		return "Starts the AutoRestart timer back up";
	}

	@Override
	public String getPermission() {
		return "autorestart.start";
	}

	@Override
	public String getUsage() {
		return "/autore start";
	}

}

package me.dennis.autorestart.commands.autore;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import me.dennis.autorestart.core.AutoRestart;
import me.dennis.autorestart.types.AutoCommand;
import me.dennis.autorestart.utils.Console;
import me.dennis.autorestart.utils.Messenger;
import net.md_5.bungee.api.ChatColor;

public class CmdPause extends AutoCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (!AutoRestart.TIMER.PAUSED) {
			AutoRestart.TIMER.PAUSED = true;
			Messenger.broadcastStatusPause(sender);
		}
		else {
			sender.sendMessage(ChatColor.RED + "Timer is already paused.");
			if (sender instanceof ConsoleCommandSender) {
				Console.consoleSendMessage(" Tried to use command, but timer is already paused.");
			}
		}
	}

	@Override
	public String getLabel() {
		return "PAUSE";
	}

	@Override
	public String getDescription() {
		return "Pauses the AutoRestart timer";
	}

	@Override
	public String getPermission() {
		return "autorestart.pause";
	}

	@Override
	public String getUsage() {
		return "/autore pause";
	}

}

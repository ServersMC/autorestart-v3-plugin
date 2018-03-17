package me.dennis.autorestart.commands.autore;

import static org.bukkit.ChatColor.*;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dennis.autorestart.core.AutoRestart;
import me.dennis.autorestart.types.AutoCommand;
import me.dennis.autorestart.types.HMS;
import me.dennis.autorestart.utils.TimerParser;
import me.dennis.autorestart.utils.TitleAPI;

public class CmdIn extends AutoCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		HMS hms = TimerParser.parseToHMS(AutoRestart.TIMER.TIME);
		sender.sendMessage(GRAY + "Server will restart in "
				+ RED + hms.H + GRAY + " Hours "
				+ RED + hms.M + GRAY + " Minutes and "
				+ RED + hms.S + GRAY + " Seconds!");
		if (sender instanceof Player) {
			Player player = (Player) sender;
			TitleAPI.sendTitle(player, 10, 40, 10, GRAY + "Server will restart in", RED + hms.H.toString() + GRAY + " Hours " + RED + hms.M + GRAY + " Minutes and " + RED + hms.S + GRAY + " Seconds!");
		}
	}

	@Override
	public String getLabel() {
		return "IN";
	}

	@Override
	public String getDescription() {
		return "Shows current timer countdown.";
	}

	@Override
	public String getPermission() {
		return null;
	}

	@Override
	public String getUsage() {
		return "/autore in";
	}

}

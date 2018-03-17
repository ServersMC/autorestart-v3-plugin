package me.dennis.autorestart.utils;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import me.dennis.autorestart.core.AutoRestart;
import me.dennis.autorestart.types.HMS;

public class Messenger {

	private static void broadcastMessage(String msg) {
		String prefix = Config.MAIN.PREFIX();
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix + msg));
	}
	
	public static void broadcastReminderMinutes() {
		if (true) { // TODO Check if pop ups are enabled
			if (!Config.GLOBAL_BROADCAST.ENABLED.MINUTES()) {
				return;
			}
		}
		HMS hms = TimerParser.parseToHMS(AutoRestart.TIMER.TIME);
		List<String> msgLines = Config.GLOBAL_BROADCAST.MESSAGES.MINUTES();
		for (String msg : msgLines) {
			broadcastMessage(msg.replaceAll("%m", hms.M.toString()));
		}
	}
	
	public static void broadcastReminderSeconds() {
		if (true) { // TODO Check if pop ups are enabled
			if (!Config.GLOBAL_BROADCAST.ENABLED.SECONDS()) {
				return;
			}
		}
		HMS hms = TimerParser.parseToHMS(AutoRestart.TIMER.TIME);
		List<String> msgLines = Config.GLOBAL_BROADCAST.MESSAGES.SECONDS();
		for (String msg : msgLines) {
			broadcastMessage(msg.replaceAll("%s", hms.S.toString()));
		}
	}
	
	public static void broadcastMaxplayersAlert() {
		if (true) { // TODO Check if pop ups are enabled
			if (!Config.GLOBAL_BROADCAST.ENABLED.MAX_PLAYERS.ALERT()) {
				return;
			}
		}
		String amount = Config.MAX_PLAYERS.AMOUNT().toString();
		List<String> msgLines = Config.GLOBAL_BROADCAST.MESSAGES.MAX_PLAYERS.ALERT();
		for (String msg : msgLines) {
			broadcastMessage(msg.replaceAll("%a", amount));
		}
	}
	public static void broadcastMaxplayersPreShutdown() {
		if (true) { // TODO Check if pop ups are enabled
			if (!Config.GLOBAL_BROADCAST.ENABLED.MAX_PLAYERS.PRE_SHUTDOWN()) {
				return;
			}
		}
		String delay = Config.MAX_PLAYERS.DELAY().toString();
		List<String> msgLines = Config.GLOBAL_BROADCAST.MESSAGES.MAX_PLAYERS.PRE_SHUTDOWN();
		for (String msg : msgLines) {
			broadcastMessage(msg.replaceAll("%d", delay));
		}
	}
	
}

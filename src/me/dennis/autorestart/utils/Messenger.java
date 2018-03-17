package me.dennis.autorestart.utils;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dennis.autorestart.core.AutoRestart;
import me.dennis.autorestart.types.HMS;

public class Messenger {

	private static void broadcastMessage(String msg) {
		String prefix = Config.MAIN.PREFIX();
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix + msg));
	}
	
	private static void sendMessage(CommandSender sender, String msg) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}

	private static void sortWhoGetsWhatChat(Boolean globalBroadcast, Boolean privateMessage, Player playerSender, List<String> globalMsgLines, List<String> privateMsgLines) {
		
		// Check if global broadcast is enabled
		if (globalBroadcast) {
			
			// Everyone but console and/or sender gets global message
			for (Player player : Bukkit.getOnlinePlayers()) {
				if (player.equals(playerSender) && privateMessage) {
					continue;
				}
				for (String msg : globalMsgLines) {
					sendMessage(player, msg);
				}
			}
		}
		
		// Check if player broadcast is enabled
		if (privateMessage) {
			
			// Check if player triggered event
			if (playerSender != null) {

				// send private message to player
				for (String msg : privateMsgLines) {
					sendMessage(playerSender, msg);
				}
				
			}
		}
		
		// Console message list variable deceleration
		List<String> consoleList;
		
		// Check if console is sender and set console message list
		if (playerSender == null) {
			consoleList = privateMsgLines;
		}
		else {
			consoleList = globalMsgLines;
		}
		
		// Send Message to console
		for (String msg : consoleList) {
			Console.consoleSendMessage(msg);
		}
	}
	
	public static void broadcastReminderMinutes() {
		// Placeholder setups and message fetch
		HMS hms = TimerParser.parseToHMS(AutoRestart.TIMER.TIME);
		List<String> msgLines = Config.GLOBAL_BROADCAST.MESSAGES.MINUTES();
		
		// TODO Check if pop ups are enabled
		if (true) {
			if (!Config.GLOBAL_BROADCAST.ENABLED.MINUTES()) {
				
				// TODO send pop ups
				
				// Send to console only
				for (String msg : msgLines) {
					Console.consoleSendMessage(msg.replaceAll("%m", hms.M.toString()));
				}
				
				// Disable for players
				return;
			}
		}
		
		// Send to everyone
		for (String msg : msgLines) {
			broadcastMessage(msg.replaceAll("%m", hms.M.toString()));
		}
	}
	
	public static void broadcastReminderSeconds() {
		// Placeholder setups and message fetch
		HMS hms = TimerParser.parseToHMS(AutoRestart.TIMER.TIME);
		List<String> msgLines = Config.GLOBAL_BROADCAST.MESSAGES.SECONDS();
		
		// TODO Check if pop ups are enabled
		if (true) {
			if (!Config.GLOBAL_BROADCAST.ENABLED.SECONDS()) {
				
				// TODO send pop ups
				
				// Send to console only
				for (String msg : msgLines) {
					Console.consoleSendMessage(msg.replaceAll("%s", hms.S.toString()));
				}
				
				// Disable for players
				return;
			}
		}
		
		// Send to everyone
		for (String msg : msgLines) {
			broadcastMessage(msg.replaceAll("%s", hms.S.toString()));
		}
	}

	public static void broadcastStatusStart(CommandSender sender) {
		// Check if player executed command
		Player playerSender = null;
		if (sender instanceof Player) {
			playerSender = (Player) sender;
		}
		
		// Placeholder setups and message fetch
		List<String> globalMsgLines = Config.GLOBAL_BROADCAST.MESSAGES.STATUS.START();
		List<String> privateMsgLines = Config.PRIVATE_MESSAGES.MESSAGES.STATUS.START();
		
		// Boolean shortcuts
		Boolean globalBroadcast = Config.GLOBAL_BROADCAST.ENABLED.STATUS.START();
		Boolean privateMessage = Config.PRIVATE_MESSAGES.ENABLED.STATUS.START();

		// TODO COPY EVERYTHING FOR POPUPS!!
		
		// TODO check if global and player pop ups are on
		if (true && true) { // THESE VALUES ARE SUPPOSE TO BE FALSE
			if (!privateMessage) {
				globalBroadcast = true;
			}
		}
		
		// Sorts who gets global broadcast and who gets player message depending on config setup
		sortWhoGetsWhatChat(globalBroadcast, privateMessage, playerSender, globalMsgLines, privateMsgLines);
	}

	public static void broadcastStatusPause(CommandSender sender) {
		// Check if player executed command
		Player playerSender = null;
		if (sender instanceof Player) {
			playerSender = (Player) sender;
		}
		
		// Placeholder setups and message fetch
		List<String> globalMsgLines = Config.GLOBAL_BROADCAST.MESSAGES.STATUS.PAUSE();
		List<String> privateMsgLines = Config.PRIVATE_MESSAGES.MESSAGES.STATUS.PAUSE();
		
		// Boolean shortcuts
		Boolean globalBroadcast = Config.GLOBAL_BROADCAST.ENABLED.STATUS.PAUSE();
		Boolean privateMessage = Config.PRIVATE_MESSAGES.ENABLED.STATUS.PAUSE();

		// TODO COPY EVERYTHING FOR POPUPS!!
		
		// TODO check if global and player pop ups are on
		if (true && true) { // THESE VALUES ARE SUPPOSE TO BE FALSE
			if (!privateMessage) {
				globalBroadcast = true;
			}
		}
		
		// Sorts who gets global broadcast and who gets player message depending on config setup
		sortWhoGetsWhatChat(globalBroadcast, privateMessage, playerSender, globalMsgLines, privateMsgLines);
	}
	
	public static void broadcastChange(CommandSender sender) {
		// Check if player executed command
		Player playerSender = null;
		if (sender instanceof Player) {
			playerSender = (Player) sender;
		}
		
		// Placeholder setups and message fetch
		HMS hms = TimerParser.parseToHMS(AutoRestart.TIMER.TIME);
		List<String> globalMsgLines = Config.GLOBAL_BROADCAST.MESSAGES.CHANGE();
		List<String> privateMsgLines = Config.PRIVATE_MESSAGES.MESSAGES.CHANGE();
		
		// Boolean shortcuts
		Boolean globalBroadcast = Config.GLOBAL_BROADCAST.ENABLED.CHANGE();
		Boolean privateMessage = Config.PRIVATE_MESSAGES.ENABLED.CHANGE();
		
		// TODO COPY EVERYTHING FOR POPUPS!!
		
		// TODO check if global and player pop ups are on
		if (true && true) { // THESE VALUES ARE SUPPOSE TO BE FALSE
			if (!privateMessage) {
				globalBroadcast = true;
			}
		}
		
		// Format message lines, before processing in sortWhoGetsWhatChat()
		for (int i = 0; i < globalMsgLines.size(); i++) {
			globalMsgLines.set(i, globalMsgLines.get(i).replaceAll("%h", hms.H.toString()).replaceAll("%m", hms.M.toString()).replaceAll("%s", hms.S.toString()));
		}
		for (int i = 0; i < privateMsgLines.size(); i++) {
			privateMsgLines.set(i, privateMsgLines.get(i).replaceAll("%h", hms.H.toString()).replaceAll("%m", hms.M.toString()).replaceAll("%s", hms.S.toString()));
		}

		sortWhoGetsWhatChat(globalBroadcast, privateMessage, playerSender, globalMsgLines, privateMsgLines);
	}
	
	public static void broadcastMaxplayersAlert() {
		// Placeholder setups and message fetch
		String amount = Config.MAX_PLAYERS.AMOUNT().toString();
		List<String> msgLines = Config.GLOBAL_BROADCAST.MESSAGES.MAX_PLAYERS.ALERT();
		
		// TODO Check if pop ups are enabled
		if (true) {
			if (!Config.GLOBAL_BROADCAST.ENABLED.MAX_PLAYERS.ALERT()) {
				
				// TODO send pop ups
				
				// Send to console only
				for (String msg : msgLines) {
					Console.consoleSendMessage(msg.replaceAll("%a", amount));
				}
				
				// Disable for players
				return;
			}
		}
		
		// Send to everyone
		for (String msg : msgLines) {
			broadcastMessage(msg.replaceAll("%a", amount));
		}
	}
	
	public static void broadcastMaxplayersPreShutdown() {
		String delay = Config.MAX_PLAYERS.DELAY().toString();
		List<String> msgLines = Config.GLOBAL_BROADCAST.MESSAGES.MAX_PLAYERS.PRE_SHUTDOWN();
		
		// TODO Check if pop ups are enabled
		if (true) {
			if (!Config.GLOBAL_BROADCAST.ENABLED.MAX_PLAYERS.PRE_SHUTDOWN()) {
				
				// TODO send pop ups
				
				// Send to console only
				for (String msg : msgLines) {
					Console.consoleSendMessage(msg.replaceAll("%d", delay));
				}
				
				// Disable for players
				return;
			}
		}
		
		// Send to everyone
		for (String msg : msgLines) {
			broadcastMessage(msg.replaceAll("%d", delay));
		}
	}
	
	public static void messageSenderTime(CommandSender sender) {
		// Placeholder setups and message fetch
		HMS hms = TimerParser.parseToHMS(AutoRestart.TIMER.TIME);
		List<String> msgLines = Config.PRIVATE_MESSAGES.MESSAGES.TIME();
		
		// Checks if sender is a player
		if (sender instanceof Player) {
			// TODO Check if pop ups are enabled
			if (true) {
				if (!Config.PRIVATE_MESSAGES.ENABLED.TIME()) {
					
					// TODO send pop ups
					
					// Disables message
					return;
				}
			}
		}
		
		// Private message lines
		for (String msg : msgLines) {
			sendMessage(sender, msg.replaceAll("%h", hms.H.toString()).replaceAll("%m", hms.M.toString()).replaceAll("%s", hms.S.toString()));
		}
	}
	
}

package me.dennis.autorestart.utils;

import java.lang.reflect.Method;
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


	private static void broadcastMessage(String msg, String perm) {
		String prefix = Config.MAIN.PREFIX();
		Bukkit.broadcast(ChatColor.translateAlternateColorCodes('&', prefix + msg), perm);
	}
	
	private static void sendMessage(CommandSender sender, String msg) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}

	private static void sendTitle(Player player, Class<?> c, Method formater) {
		TitleAPI.sendTitle(player, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "");
		try {
			Class<?> clezz = Class.forName(c.getName() + "$TITLE");
			Integer fadeIn = Integer.parseInt(clezz.getMethod("FADEIN").invoke(null).toString());
			Integer stay = Integer.parseInt(clezz.getMethod("STAY").invoke(null).toString());
			Integer fadeOut = Integer.parseInt(clezz.getMethod("FADEOUT").invoke(null).toString());
			String text = clezz.getMethod("TEXT").invoke(null).toString();
			TitleAPI.sendTitle(player, fadeIn, stay, fadeOut, formater.invoke(null, text).toString(), null);
		} catch (Exception e) {
			Console.catchError(e, "Messenger.sendTitle():TITLE");
		}
		try {
			Class<?> clazz = Class.forName(c.getName() + "$SUBTITLE");
			Integer fadeIn = Integer.parseInt(clazz.getMethod("FADEIN").invoke(null).toString());
			Integer stay = Integer.parseInt(clazz.getMethod("STAY").invoke(null).toString());
			Integer fadeOut = Integer.parseInt(clazz.getMethod("FADEOUT").invoke(null).toString());
			String text = clazz.getMethod("TEXT").invoke(null).toString();
			TitleAPI.sendTitle(player, fadeIn, stay, fadeOut, null, formater.invoke(null, text).toString());
		} catch (Exception e) {
			Console.catchError(e, "Messenger.sendTitle():SUBTITLE");
		}
	}

	public static String formatM(String s) {
		HMS hms = TimerParser.parseToHMS();
		return s.replaceAll("%m", hms.M.toString());
	}
	
	public static String formatS(String s) {
		HMS hms = TimerParser.parseToHMS();
		return s.replaceAll("%s", hms.S.toString());
	}

	public static String formatHMS(String s) {
		HMS hms = TimerParser.parseToHMS();
		return s.replaceAll("%h", hms.H.toString()).replaceAll("%m", hms.M.toString()).replaceAll("%s", hms.S.toString());
	}

	public static String formatA(String s) {
		return s.replaceAll("%a", AutoRestart.TIMER.TIME.toString());
	}

	public static String formatD(String s) {
		String delay = Config.MAX_PLAYERS.DELAY().toString();
		return s.replaceAll("%d", delay);
	}
	
	public static String formatSkip(String s) {
		return s;
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
					sendMessage(player, Config.MAIN.PREFIX() + msg);
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
	
	private static void sortWhoGetsWhatPopUp(Boolean globalPopup, Boolean privatePopup, Player playerSender, Class<?> globalClass, Class<?> privateClass, Method method) {

		// Check if global pop up is enabled
		if (globalPopup) {
			
			// Everyone but sender gets global message
			for (Player player : Bukkit.getOnlinePlayers()) {
				if (player.equals(playerSender) && privatePopup) {
					continue;
				}
				sendTitle(player, globalClass, method);
			}
		}
		
		// Check if player pop up is enabled
		if (privatePopup) {
			
			// Check if player triggered event
			if (playerSender != null) {

				// send private pop up to player
				sendTitle(playerSender, privateClass, method);
				
			}
		}
		
	}
	
	public static void broadcastReminderMinutes() {
		// Placeholder setups and message fetch
		HMS hms = TimerParser.parseToHMS();
		List<String> msgLines = Config.GLOBAL_BROADCAST.MESSAGES.MINUTES();
		
		// Check if pop ups are enabled
		if (Config.GLOBAL_POPUPS.ENABLED.MINUTES()) {
			
			// send pop ups
			for (Player player : Bukkit.getOnlinePlayers()) {
				try {
					sendTitle(player, Config.GLOBAL_POPUPS.MESSAGES.MINUTES.class, Messenger.class.getMethod("formatM", String.class));
				} catch (Exception e) {
					Console.catchError(e, "Messenger.broadcastReminderMinutes():SendPopUps");
				}
			}
			
			if (!Config.GLOBAL_BROADCAST.ENABLED.MINUTES()) {
				
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
		HMS hms = TimerParser.parseToHMS();
		List<String> msgLines = Config.GLOBAL_BROADCAST.MESSAGES.SECONDS();
		
		// Check if pop ups are enabled
		if (Config.GLOBAL_POPUPS.ENABLED.SECONDS()) {
			
			// send pop ups
			for (Player player : Bukkit.getOnlinePlayers()) {
				try {
					sendTitle(player, Config.GLOBAL_POPUPS.MESSAGES.SECONDS.class, Messenger.class.getMethod("formatS", String.class));
				} catch (Exception e) {
					Console.catchError(e, "Messenger.broadcastReminderSeconds():SendPopUps");
				}
			}
			
			if (!Config.GLOBAL_BROADCAST.ENABLED.SECONDS()) {
				
				// Send to console only
				for (String msg : msgLines) {
					Console.consoleSendMessage(msg.replaceAll("%s", AutoRestart.TIMER.TIME.toString()));
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
		Boolean globalPopup = Config.GLOBAL_POPUPS.ENABLED.STATUS.START();
		Boolean privatePopup = Config.PRIVATE_POPUPS.ENABLED.STATUS.START();

		// check if global and player pop ups are off
		if (!globalPopup && !privatePopup) {
			if (!privateMessage) {
				globalBroadcast = true;
			}
		}
		else {
			try {
				sortWhoGetsWhatPopUp(globalPopup, privatePopup, playerSender, Config.GLOBAL_POPUPS.MESSAGES.STATUS.START.class, Config.PRIVATE_POPUPS.MESSAGES.STATUS.START.class, Messenger.class.getMethod("formatSkip", String.class));
			} catch (Exception e) {
				Console.catchError(e, "Messenger.broadcastStatusStart():SortWhoGetsWhatPopUp");
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
		Boolean globalPopup = Config.GLOBAL_POPUPS.ENABLED.STATUS.PAUSE();
		Boolean privatePopup = Config.PRIVATE_POPUPS.ENABLED.STATUS.PAUSE();

		// check if global and player pop ups are off
		if (!globalPopup && !privatePopup) {
			if (!privateMessage) {
				globalBroadcast = true;
			}
		}
		else {
			try {
				sortWhoGetsWhatPopUp(globalPopup, privatePopup, playerSender, Config.GLOBAL_POPUPS.MESSAGES.STATUS.PAUSE.class, Config.PRIVATE_POPUPS.MESSAGES.STATUS.PAUSE.class, Messenger.class.getMethod("formatSkip", String.class));
			} catch (Exception e) {
				Console.catchError(e, "Messenger.broadcastStatusPause():SortWhoGetsWhatPopUp");
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
		HMS hms = TimerParser.parseToHMS();
		List<String> globalMsgLines = Config.GLOBAL_BROADCAST.MESSAGES.CHANGE();
		List<String> privateMsgLines = Config.PRIVATE_MESSAGES.MESSAGES.CHANGE();
		
		// Boolean shortcuts
		Boolean globalBroadcast = Config.GLOBAL_BROADCAST.ENABLED.CHANGE();
		Boolean privateMessage = Config.PRIVATE_MESSAGES.ENABLED.CHANGE();
		Boolean globalPopup = Config.GLOBAL_POPUPS.ENABLED.CHANGE();
		Boolean privatePopup = Config.PRIVATE_POPUPS.ENABLED.CHANGE();

		// check if global and player pop ups are off
		if (!globalPopup && !privatePopup) {
			if (!privateMessage) {
				globalBroadcast = true;
			}
		}
		else {
			try {
				sortWhoGetsWhatPopUp(globalPopup, privatePopup, playerSender, Config.GLOBAL_POPUPS.MESSAGES.CHANGE.class, Config.PRIVATE_POPUPS.MESSAGES.CHANGE.class, Messenger.class.getMethod("formatHMS", String.class));
			} catch (Exception e) {
				Console.catchError(e, "Messenger.broadcastChange():SortWhoGetsWhatPopUp");
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
		
		// Check if pop ups are enabled
		if (Config.GLOBAL_POPUPS.ENABLED.MAX_PLAYERS.ALERT()) {
			
			// send pop ups
			for (Player player : Bukkit.getOnlinePlayers()) {
				try {
					sendTitle(player, Config.GLOBAL_POPUPS.MESSAGES.MAX_PLAYERS.ALERT.class, Messenger.class.getMethod("formatA", String.class));
				} catch (Exception e) {
					Console.catchError(e, "Messenger.broadcastMaxplayersAlert():SendPopUps");
				}
			}
			
			if (!Config.GLOBAL_BROADCAST.ENABLED.MAX_PLAYERS.ALERT()) {
				
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
		
		// Check if pop ups are enabled
		if (Config.GLOBAL_POPUPS.ENABLED.MAX_PLAYERS.PRE_SHUTDOWN()) {
			
			// send pop ups
			for (Player player : Bukkit.getOnlinePlayers()) {
				try {
					sendTitle(player, Config.GLOBAL_POPUPS.MESSAGES.MAX_PLAYERS.PRE_SHUTDOWN.class, Messenger.class.getMethod("formatD", String.class));
				} catch (Exception e) {
					Console.catchError(e, "Messenger.broadcastMaxplayersPreShutdown():SendPopUps");
				}
			}
			
			if (!Config.GLOBAL_BROADCAST.ENABLED.MAX_PLAYERS.PRE_SHUTDOWN()) {
				
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
	
	public static void broadcastPauseReminder() {
		
		List<String> msgLines = Config.PRIVATE_MESSAGES.MESSAGES.PAUSE_REMINDER();
		
		// Send to console only
		for (String msg : msgLines) {
			Console.consoleSendMessage(msg);
		}
		
		// Check if pop ups are enabled
		if (Config.PRIVATE_POPUPS.ENABLED.PAUSE_REMINDER()) {
			
			// send pop ups
			for (Player player : Bukkit.getOnlinePlayers()) {
				try {
					sendTitle(player, Config.PRIVATE_POPUPS.MESSAGES.PAUSE_REMINDER.class, Messenger.class.getMethod("formatSkip", String.class));
				} catch (Exception e) {
					Console.catchError(e, "Messenger.broadcastPauseReminder():SendPopUps");
				}
			}
			
			if (!Config.PRIVATE_MESSAGES.ENABLED.PAUSE_REMINDER()) {
				
				// Disable for players
				return;
			}
		}
		
		// Send to everyone
		for (String msg : msgLines) {
			broadcastMessage(msg, "autorestart.start");
		}
	}
	
	public static void broadcastShutdown() {
		List<String> msgLines = Config.GLOBAL_BROADCAST.MESSAGES.SHUTDOWN();
		
		// Check if pop ups are enabled
		if (Config.GLOBAL_POPUPS.ENABLED.SHUTDOWN()) {
			
			// send pop ups
			for (Player player : Bukkit.getOnlinePlayers()) {
				try {
					sendTitle(player, Config.GLOBAL_POPUPS.MESSAGES.SHUTDOWN.class, Messenger.class.getMethod("formatSkip", String.class));
				} catch (Exception e) {
					Console.catchError(e, "Messenger.broadcastShutdown():SendPopUps");
				}
			}
			
			if (!Config.GLOBAL_BROADCAST.ENABLED.SHUTDOWN()) {
				
				// Send to console only
				for (String msg : msgLines) {
					Console.consoleSendMessage(msg);
				}
				
				// Disable for players
				return;
			}
		}
		
		// Send to everyone
		for (String msg : msgLines) {
			broadcastMessage(msg);
		}
	}
	
	public static void messageSenderTime(CommandSender sender) {
		// Placeholder setups and message fetch
		HMS hms = TimerParser.parseToHMS();
		List<String> msgLines = Config.PRIVATE_MESSAGES.MESSAGES.TIME();
		
		// Checks if sender is a player
		if (sender instanceof Player) {
			
			// Check if pop ups are enabled
			if (Config.PRIVATE_POPUPS.ENABLED.TIME()) {
				
				// send pop ups
				try {
					sendTitle((Player) sender, Config.PRIVATE_POPUPS.MESSAGES.TIME.class, Messenger.class.getMethod("formatHMS", String.class));
				} catch (Exception e) {
					Console.catchError(e, "Messenger.messageSenderTime():SendPopUps");
				}
				
				if (!Config.PRIVATE_MESSAGES.ENABLED.TIME()) {
					
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

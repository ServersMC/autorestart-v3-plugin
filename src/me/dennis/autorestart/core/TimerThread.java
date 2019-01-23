package me.dennis.autorestart.core;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import me.dennis.autorestart.utils.Console;
import me.dennis.autorestart.utils.Messenger;
import me.dennis.autorestart.utils.TimeManager;
import me.dennis.autorestart.utils.config.Config;

public class TimerThread {

	public Boolean PAUSED = false;
	public Integer PAUSED_TIMER = 0;
	public Integer TIME;
	public Integer loopId = 0;
	public Integer shutdownId = 0;
	
	public void runLoop() {
		
		loopId = Bukkit.getScheduler().scheduleSyncRepeatingTask(AutoRestart.PLUGIN, () -> {
			// Check if timer is paused
			if (PAUSED) {
				PAUSED_TIMER++;
				if (PAUSED_TIMER == Config.REMINDER.PAUSE_REMINDER() * 60) {
					Messenger.broadcastPauseReminder();
					PAUSED_TIMER = 0;
					return;
				}
			}
			else {
				
				// Reset Paused Timer
				PAUSED_TIMER = 0;

				// Timer end break
				if (TIME == 0) {
					Bukkit.getScheduler().cancelTask(getLoopId());
					return;
				}
				
				// Minutes Reminder
				if (Config.REMINDER.ENABLED.MINUTES()) {
					List<Integer> minuteReminderList = Config.REMINDER.MINUTES();
					for (Integer minuteReminder : minuteReminderList) {
						if (TIME == minuteReminder * 60) {
							Messenger.broadcastReminderMinutes();
						}
					}
				}
				
				// Seconds Reminder
				if (Config.REMINDER.ENABLED.SECONDS()) {
					Integer secondReminder = Config.REMINDER.SECONDS();
					if (TIME <= secondReminder) {
						Messenger.broadcastReminderSeconds();
					}
				}
				
				// Command Execute
				if (Config.COMMANDS.ENABLED()) {
					if (TIME == Config.COMMANDS.SECONDS()) {
						for (String cmd : Config.COMMANDS.LIST()) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
						}
					}
				}
				
				// Timer decrement
				TIME--;
				
			}
		}, 0L, 20L);
		
		shutdownId = Bukkit.getScheduler().scheduleSyncRepeatingTask(AutoRestart.PLUGIN, () -> {
			if (TIME <= 0) {

				// Global broadcast chat / popup handler
				Messenger.broadcastShutdown();
				
				// Player kick / restart message
				Bukkit.getScheduler().callSyncMethod(AutoRestart.PLUGIN, () -> 
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kickall " + ChatColor.translateAlternateColorCodes('&', Config.MAIN.KICK_MESSAGE()))
				);
				
				// DISABLED MAX_PLAYERS
				/*
				// Check if max_players is enabled
				if (Config.MAX_PLAYERS.ENABLED()) {
					// Check if player count is over configured amount
					if (Bukkit.getOnlinePlayers().size() >= Config.MAX_PLAYERS.AMOUNT()) {
						// Broadcast alert (Includes Check if message enabled)
						Messenger.broadcastMaxplayersAlert();

						// Start Shutdown wait
						while (true) {
							if (Bukkit.getOnlinePlayers().size() < Config.MAX_PLAYERS.AMOUNT()) {
								break;
							}
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								Console.catchError(e, "ShutdownTimeout.run()");
							}
						}
						
						// Broadcast pre shutdown message (Includes Check if message enabled)
						Messenger.broadcastMaxplayersPreShutdown();
					}
				}
				*/
				
				// Timeout alarm initialization
				long timeout = System.currentTimeMillis() + 5000;
				
				// Wait until players are successfully kicked, unless timeout is called
				while (timeout < System.currentTimeMillis()) {
					if (Bukkit.getOnlinePlayers().size() == 0) {
						break;
					}
				}
				
				// Multicraft shutdown
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart");
				
				// Shutdown server method
				AutoRestart.PLUGIN.getServer().shutdown();
				
				Bukkit.getScheduler().cancelTask(getShutdownId());
			}
		}, 0L, 1L);
		
	}
	
	public void calculateTimer() {
		// Initialize variable
		boolean doDefault = false;
		
		// Check restart mode
		switch (Config.MAIN.RESTART_MODE().toUpperCase()) {
		
		// Interval timer calculator
		case "INTERVAL":

			doDefault = true;
			break;

		// Time stamp timer calculator
		case "TIMESTAMP":
			
			List<String> timestamps = Config.MAIN.MODES.TIMESTAMP();
			List<Long> differences = new ArrayList<Long>();
			Long now = Calendar.getInstance().getTimeInMillis();
			
			// Convert time stamps to a list of differences
			for (String timestamp : timestamps) {
				Long convertedTime = TimeManager.parseTimeStamp(timestamp);
				
				// Check if converted time was accepted
				if (convertedTime == null) {
					Console.warn(timestamp + " does not follow correct format!");
					continue;
				}
				
				// Add converted time to test list
				differences.add(convertedTime - now);
			}
			
			// Check if test list is empty
			if (differences.isEmpty()) {
				Console.warn("There are no accepted timestamps availiable! Please check config to ensure that you have followed the correct format.");
				doDefault = true;
				break;
			}
			
			// Find smallest difference
			Long closestTime = differences.get(0);
			for (int i = 1; i < differences.size(); i++) {
				Long test = differences.get(i);
				if (test < closestTime) {
					closestTime = test;
				}
			}
			
			// Convert milliseconds to TIME
			TIME = (int) (closestTime / 1000l);
			break;
			
		default:

			// Default timer calculator
			doDefault = true;
			Console.err("Restart mode \"" + Config.MAIN.RESTART_MODE() + "\" was not found! Switching to interval mode!");
			break;

		}
		
		// Do default when requested
		if (doDefault) {
			
			// Calculate interval time
			TIME = (int) (Config.MAIN.MODES.INTERVAL() * 3600);
		}
	}
	
	public Integer getLoopId() {
		return loopId;
	}
	
	public Integer getShutdownId() {
		return shutdownId;
	}

}

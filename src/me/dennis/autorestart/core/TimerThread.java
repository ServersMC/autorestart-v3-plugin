package me.dennis.autorestart.core;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.dennis.autorestart.utils.Console;
import me.dennis.autorestart.utils.Messenger;
import me.dennis.autorestart.utils.ShutdownTimeout;
import me.dennis.autorestart.utils.config.Config;

public class TimerThread implements Runnable {

	public Boolean PAUSED = false;
	public Integer PAUSED_TIMER = 0;
	public Integer TIME;
	
	@Override
	public void run() {
		while (true) {
			// Timer freeze frame
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Console.catchError(e, "TimerThread.run():sleep");
			}
			
			// Timer end break
			if (TIME == 0) {
				break;
			}
			
			// Check if timer is paused
			if (PAUSED) {
				PAUSED_TIMER++;
				if (PAUSED_TIMER == Config.REMINDER.PAUSE_REMINDER() * 60) {
					Messenger.broadcastPauseReminder();
					PAUSED_TIMER = 0;
				}
				continue;
			}
			PAUSED_TIMER = 0;
			
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
		
		// Request RESTART for AutoRestart-BootLoader
		File file = new File("RESTART");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				Console.catchError(e, "TimerThread.run():requestRestart");
			}
		}
		
		// Global broadcast chat / popup handler
		Messenger.broadcastShutdown();
		
		// Player kick / restart message
		for (int i = 0; i < Bukkit.getOnlinePlayers().size(); i++) {
			final Player player = (Player) Bukkit.getOnlinePlayers().toArray()[0];
			
			// Bukkit Scheduler to avoid asynchronous error
			Bukkit.getScheduler().scheduleSyncDelayedTask(AutoRestart.PLUGIN, new Runnable() {
				
				@Override
				public void run() {
					
					// Player kick / restart message
					player.kickPlayer(ChatColor.translateAlternateColorCodes('&', Config.MAIN.KICK_MESSAGE()));
					
				}
				
			});
			
		}
		
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
		
		// Timeout runnable if error on kick
		new Thread(new ShutdownTimeout()).start();
		
		// Wait until players are successfully kicked, unless timeout is finished
		while (!ShutdownTimeout.timeout) {
			if (Bukkit.getOnlinePlayers().size() == 0) {
				break;
			}
		}
		
		// Shutdown server method
		AutoRestart.PLUGIN.getServer().shutdown();
		
	}
	
	public void calculateTimer() {
		// Check restart mode
		switch (Config.MAIN.RESTART_MODE().toUpperCase()) {
		case "INTERVAL":
			
			// Interval timer calculator
			TIME = (int) (Config.MAIN.MODES.INTERVAL() * 3600);
			break;
			
		default:

			// Default timer calculator
			TIME = (int) (Config.MAIN.MODES.INTERVAL() * 3600);
			Console.err("Restart mode \"" + Config.MAIN.RESTART_MODE() + "\" was not found! Switching to interval mode!");
			break;
			
		}
	}

}

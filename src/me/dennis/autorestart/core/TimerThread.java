package me.dennis.autorestart.core;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.dennis.autorestart.utils.Config;
import me.dennis.autorestart.utils.Console;
import me.dennis.autorestart.utils.ShutdownTimeout;

public class TimerThread implements Runnable {

	public Boolean RUNNING = true;
	public Integer TIME;
	
	@Override
	public void run() {
		while (RUNNING) {
			if (TIME == 0) {
				break;
			}
			
			// Timer decrement
			TIME--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Console.catchError(e, "TimerThread.run()");
			}
		}
		
		for (int i = 0; i < Bukkit.getOnlinePlayers().size(); i++) {
			final Player player = (Player) Bukkit.getOnlinePlayers().toArray()[0];
			
			// Bukkit Scheduler to avoid asynchronous error
			Bukkit.getScheduler().scheduleSyncDelayedTask(AutoRestart.PLUGIN, new Runnable() {
				@Override
				public void run() {
					
					// Player kick shutdown message
					player.kickPlayer("Shutdown message!");
					
				}
			});
			
		}
		
		// Timeout runnable if error on kick
		new Thread(new ShutdownTimeout()).start();
		
		// Wait until players are successfully kicked, unless timeout is called
		while (!ShutdownTimeout.timeout) {
			if (Bukkit.getOnlinePlayers().size() == 0) {
				break;
			}
		}
		
		// Shutdown server method
		AutoRestart.PLUGIN.getServer().shutdown();
		
	}
	
	public void calculateTimer() {
		// Check config restart mode
		switch (Config.MAIN.RESTART_MODE().toLowerCase()) {
		case "interval":
			
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

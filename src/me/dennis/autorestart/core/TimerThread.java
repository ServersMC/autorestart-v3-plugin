package me.dennis.autorestart.core;

import me.dennis.autorestart.utils.Config;
import me.dennis.autorestart.utils.Console;

public class TimerThread implements Runnable {

	public Boolean RUNNING = true;
	public Integer TIME;
	
	@Override
	public void run() {
		while (RUNNING) {
			
			// Timer decrement
			TIME--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				// Error exception catch
				Console.err("There was an error in the TimerThread class. If this is common, please PM error to ServersMC via PasteBin, or quickly send bug with /autore senderror");
				e.printStackTrace();
				Console.err("End of error");
				
			}
		}
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

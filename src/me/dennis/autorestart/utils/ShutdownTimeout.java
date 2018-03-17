package me.dennis.autorestart.utils;

public class ShutdownTimeout implements Runnable {

	public static Boolean timeout = false;
	
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			Console.catchError(e, "ShutdownTimeout.run()");
		}
		timeout = true;
	}

}

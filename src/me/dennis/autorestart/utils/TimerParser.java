package me.dennis.autorestart.utils;

import me.dennis.autorestart.core.AutoRestart;
import me.dennis.autorestart.objects.HMS;

public class TimerParser {

	public static HMS parseToHMS() {
		int H = AutoRestart.TIMER.TIME / 3600;
		int M = AutoRestart.TIMER.TIME / 60 - H * 60;
		int S = AutoRestart.TIMER.TIME - H * 3600 - M * 60;
		return new HMS(H, M, S);
	}
	
}

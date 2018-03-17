package me.dennis.autorestart.utils;

import me.dennis.autorestart.types.HMS;

public class TimerParser {

	public static HMS parseToHMS(Integer timer) {
		int H = timer / 3600;
		int M = timer / 60 - H * 60;
		int S = timer - H * 3600 - M * 60;
		return new HMS(H, M, S);
	}
	
}

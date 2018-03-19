package me.dennis.autorestart.objects;

import me.dennis.autorestart.enums.TitleEnum;

public class ConfigPopup {

	public ConfigTitle TITLE;
	public ConfigTitle SUBTITLE;
	
	public ConfigPopup(String node, String titleDefault, String subtitleDefault, Integer[] titleTimes, Integer[] subtitleTimes) {
		TITLE = new ConfigTitle(node, titleDefault, titleTimes[0], titleTimes[1], titleTimes[2], TitleEnum.TITLE);
		SUBTITLE = new ConfigTitle(node, subtitleDefault, subtitleTimes[0], subtitleTimes[1], subtitleTimes[2], TitleEnum.SUBTITLE);
	}
	
}

package me.dennis.autorestart.objects;

import me.dennis.autorestart.enums.TitleEnum;
import me.dennis.autorestart.utils.config.Config;

public class ConfigTitle {

	private String node;
	private String titleDefault;
	private Integer fadein;
	private Integer stay;
	private Integer fadeout;
	private TitleEnum type;
	
	public ConfigTitle(String node, String titleDefault, Integer fadein, Integer stay, Integer fadeout, TitleEnum type) {
		this.node = node;
		this.titleDefault = titleDefault;
		this.fadein = fadein;
		this.stay = stay;
		this.fadeout = fadeout;
		this.type = type;
	}

	public String TEXT() {
		return Config.getString(node + "." + type.name().toLowerCase() + ".text", titleDefault);
	}

	public Integer FADEIN() {
		return Config.getInteger(node + "." + type.name().toLowerCase() + ".fadein", fadein);
	}

	public Integer STAY() {
		return Config.getInteger(node + "." + type.name().toLowerCase() + ".stay", stay);
	}

	public Integer FADEOUT() {
		return Config.getInteger(node + "." + type.name().toLowerCase() + ".fadeout", fadeout);
	}

}

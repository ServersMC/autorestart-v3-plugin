package me.dennis.autorestart.objects;

import me.dennis.autorestart.enums.TitleEnum;

public class ConfigTitle {

	private ConfigFile config;
	private String node;
	private String titleDefault;
	private Integer fadein;
	private Integer stay;
	private Integer fadeout;
	private TitleEnum type;
	
	public ConfigTitle(ConfigFile config, String node, String titleDefault, Integer fadein, Integer stay, Integer fadeout, TitleEnum type) {
		this.config = config;
		this.node = node;
		this.titleDefault = titleDefault;
		this.fadein = fadein;
		this.stay = stay;
		this.fadeout = fadeout;
		this.type = type;
	}

	public String TEXT() {
		return config.getString(node + "." + type.name().toLowerCase() + ".text", titleDefault);
	}

	public Integer FADEIN() {
		return config.getInteger(node + "." + type.name().toLowerCase() + ".fadein", fadein);
	}

	public Integer STAY() {
		return config.getInteger(node + "." + type.name().toLowerCase() + ".stay", stay);
	}

	public Integer FADEOUT() {
		return config.getInteger(node + "." + type.name().toLowerCase() + ".fadeout", fadeout);
	}

}

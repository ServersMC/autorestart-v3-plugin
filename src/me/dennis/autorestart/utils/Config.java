package me.dennis.autorestart.utils;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    private static FileConfiguration config = null;
    
    public static Integer VERSION;
    
    private static FileConfiguration getConfig() {
        return config;
    }
    
    public static void setConfig(FileConfiguration config) {
        Config.config = config;
        VERSION = getInteger("version", 0);
    }

	private static String getString(String node, String defaultValue) {
		return getConfig().getString(node, defaultValue);
	}
	private static Integer getInteger(String node, Integer defaultValue) {
		return getConfig().getInt(node, defaultValue);
	}
	private static Double getDouble(String node, Double defaultValue) {
		return getConfig().getDouble(node, defaultValue);
	}
	private static Boolean getBoolean(String node, Boolean defaultValue) {
		return getConfig().getBoolean(node, defaultValue);
	}
	private static List<Integer> getIntegerList(String node) {
		return getConfig().getIntegerList(node);
	}
	private static List<String> getStringList(String node) {
		return getConfig().getStringList(node);
	}
	
	public static class MAIN {
		public static String RESTART_MODE() { return getString("main.restart_mode", "interval"); }
		public static class MODES {
			public static Double INTERVAL() { return getDouble("main.modes.interval", 3d); }
			public static String TIMESTAMP() { return getString("main.modes.timestamp", "6:00"); }
		}
		public static String PREFIX() { return getString("main.prefix", "&f[&7AutoRestart&f] &e"); }
		public static String RESTART_MESSAGE() { return getString("main.restart_message", "&cServer Restarting! We will be back up any minute!"); }
	}
	
	public static class REMINDER {
		public static class ENABLED {
			public static Boolean MINUTES() { return getBoolean("reminder.enabled.minutes", true); }
			public static Boolean SECONDS() { return getBoolean("reminder.enabled.seconds", true); }
		}
		public static List<Integer> MINUTES() { return getIntegerList("reminder.minutes"); }
		public static Integer SECONDS() { return getInteger("reminder.seconds", 5); }
	}
	
	public static class GLOBAL_BROADCAST {
		public static class ENABLED {
			public static Boolean MINUTES() { return getBoolean("global_broadcast.enabled.minutes", true); }
			public static Boolean SECONDS() { return getBoolean("global_broadcast.enabled.seconds", true); }
			public static class STATUS {
				public static Boolean START() { return getBoolean("global_broadcast.enabled.status.start", true); }
				public static Boolean PAUSE() { return getBoolean("global_broadcast.enabled.status.pause", true); }
			}
			public static Boolean CHANGE() { return getBoolean("global_broadcast.enabled.change", true); }
			public static class MAX_PLAYERS {
				public static Boolean ALERT() { return getBoolean("global_broadcast.enabled.max_players.alert", true); }
				public static Boolean PRE_SHUTDOWN() { return getBoolean("global_broadcast.enabled.max_players.pre_shutdown", true); }
			}
		}
		public static class MESSAGES {
			public static List<String> MINUTES() { return getStringList("global_broadcast.messages.minutes"); }
			public static List<String> SECONDS() { return getStringList("global_broadcast.messages.seconds"); }
			public static class STATUS {
				public static List<String> START() { return getStringList("global_broadcast.messages.status.start"); }
				public static List<String> PAUSE() { return getStringList("global_broadcast.messages.status.pause"); }
			}
			public static List<String> CHANGE() { return getStringList("global_broadcast.messages.change"); }
			public static class MAX_PLAYERS {
				public static List<String> ALERT() { return getStringList("global_broadcast.messages.max_players.alert"); }
				public static List<String> PRE_SHUTDOWN() { return getStringList("global_broadcast.messages.max_players.pre_shutdown"); }
			}
		}
	}
	
	public static class PRIVATE_MESSAGES {
		public static class ENABLED {
			public static Boolean TIME() { return getBoolean("private_messages.enabled.time", true); }
			public static class STATUS {
				public static Boolean START() { return getBoolean("private_messages.enabled.status.start", true); }
				public static Boolean PAUSE() { return getBoolean("private_messages.enabled.status.pause", true); }
			}
			public static Boolean CHANGE() { return getBoolean("private_messages.enabled.change", true); }
		}
		public static class MESSAGES {
			public static List<String> TIME() { return getStringList("private_messages.messages.time"); }
			public static class STATUS {
				public static List<String> START() { return getStringList("private_messages.messages.status.start"); }
				public static List<String> PAUSE() { return getStringList("private_messages.messages.status.pause"); }
			}
			public static List<String> CHANGE() { return getStringList("private_messages.messages.change"); }
		}
	}

	public static class GLOBAL_POPUPS {
		public static class ENABLED {
			public static Boolean MINUTES() { return getBoolean("global_popups.enabled.minutes", true); }
			public static Boolean SECONDS() { return getBoolean("global_popups.enabled.seconds", true); }
			public static class STATUS {
				public static Boolean START() { return getBoolean("global_popups.enabled.status.start", true); }
				public static Boolean PAUSE() { return getBoolean("global_popups.enabled.status.pause", true); }
			}
			public static Boolean CHANGE() { return getBoolean("global_popups.enabled.change", true); }
			public static class MAX_PLAYERS {
				public static Boolean ALERT() { return getBoolean("global_popups.enabled.max_players.alert", true); }
				public static Boolean PRE_SHUTDOWN() { return getBoolean("global_popups.enabled.max_players.pre_shutdown", true); }
			}
			public static Boolean SHUTDOWN() { return getBoolean("global_popups.enabled.shutdown", true); }
		}
		public static class MESSAGES {
			public static class MINUTES {
				public static class TITLE {
					public static String TEXT() { return getString("global_popups.messages.minutes.title.text", ""); }
					public static Integer FADEIN() { return getInteger("global_popups.messages.minutes.title.fadein", 20); }
					public static Integer STAY() { return getInteger("global_popups.messages.minutes.title.stay", 40); }
					public static Integer FADEOUT() { return getInteger("global_popups.messages.minutes.title.fadeout", 20); }
				}
				public static class SUBTITLE {
					public static String TEXT() { return getString("global_popups.messages.minutes.subtitle.text", ""); }
					public static Integer FADEIN() { return getInteger("global_popups.messages.minutes.subtitle.fadein", 20); }
					public static Integer STAY() { return getInteger("global_popups.messages.minutes.subtitle.stay", 40); }
					public static Integer FADEOUT() { return getInteger("global_popups.messages.minutes.subtitle.fadeout", 20); }
				}
			}
			public static class SECONDS {
				public static class TITLE {
					public static String TEXT() { return getString("global_popups.messages.seconds.title.text", ""); }
					public static Integer FADEIN() { return getInteger("global_popups.messages.seconds.title.fadein", 20); }
					public static Integer STAY() { return getInteger("global_popups.messages.seconds.title.stay", 40); }
					public static Integer FADEOUT() { return getInteger("global_popups.messages.seconds.title.fadeout", 20); }
				}
				public static class SUBTITLE {
					public static String TEXT() { return getString("global_popups.messages.seconds.subtitle.text", ""); }
					public static Integer FADEIN() { return getInteger("global_popups.messages.seconds.subtitle.fadein", 20); }
					public static Integer STAY() { return getInteger("global_popups.messages.seconds.subtitle.stay", 40); }
					public static Integer FADEOUT() { return getInteger("global_popups.messages.seconds.subtitle.fadeout", 20); }
				}
			}
			public static class STATUS {
				public static class START {
					public static class TITLE {
						public static String TEXT() { return getString("global_popups.messages.status.start.title.text", ""); }
						public static Integer FADEIN() { return getInteger("global_popups.messages.status.start.title.fadein", 20); }
						public static Integer STAY() { return getInteger("global_popups.messages.status.start.title.stay", 40); }
						public static Integer FADEOUT() { return getInteger("global_popups.messages.status.start.title.fadeout", 20); }
					}
					public static class SUBTITLE {
						public static String TEXT() { return getString("global_popups.messages.status.start.subtitle.text", ""); }
						public static Integer FADEIN() { return getInteger("global_popups.messages.status.start.subtitle.fadein", 20); }
						public static Integer STAY() { return getInteger("global_popups.messages.status.start.subtitle.stay", 40); }
						public static Integer FADEOUT() { return getInteger("global_popups.messages.status.start.subtitle.fadeout", 20); }
					}
				}
				public static class PAUSE {
					public static class TITLE {
						public static String TEXT() { return getString("global_popups.messages.status.pause.title.text", ""); }
						public static Integer FADEIN() { return getInteger("global_popups.messages.status.pause.title.fadein", 20); }
						public static Integer STAY() { return getInteger("global_popups.messages.status.pause.title.stay", 40); }
						public static Integer FADEOUT() { return getInteger("global_popups.messages.status.pause.title.fadeout", 20); }
					}
					public static class SUBTITLE {
						public static String TEXT() { return getString("global_popups.messages.status.pause.subtitle.text", ""); }
						public static Integer FADEIN() { return getInteger("global_popups.messages.status.pause.subtitle.fadein", 20); }
						public static Integer STAY() { return getInteger("global_popups.messages.status.pause.subtitle.stay", 40); }
						public static Integer FADEOUT() { return getInteger("global_popups.messages.status.pause.subtitle.fadeout", 20); }
					}
				}
			}
			public static class CHANGE {
				public static class TITLE {
					public static String TEXT() { return getString("global_popups.messages.change.title.text", ""); }
					public static Integer FADEIN() { return getInteger("global_popups.messages.change.title.fadein", 20); }
					public static Integer STAY() { return getInteger("global_popups.messages.change.title.stay", 40); }
					public static Integer FADEOUT() { return getInteger("global_popups.messages.change.title.fadeout", 20); }
				}
				public static class SUBTITLE {
					public static String TEXT() { return getString("global_popups.messages.change.subtitle.text", ""); }
					public static Integer FADEIN() { return getInteger("global_popups.messages.change.subtitle.fadein", 20); }
					public static Integer STAY() { return getInteger("global_popups.messages.change.subtitle.stay", 40); }
					public static Integer FADEOUT() { return getInteger("global_popups.messages.change.subtitle.fadeout", 20); }
				}
			}
			public static class MAX_PLAYERS {
				public static class ALERT {
					public static class TITLE {
						public static String TEXT() { return getString("global_popups.messages.max_players.alert.title.text", ""); }
						public static Integer FADEIN() { return getInteger("global_popups.messages.max_players.alert.title.fadein", 20); }
						public static Integer STAY() { return getInteger("global_popups.messages.max_players.alert.title.stay", 40); }
						public static Integer FADEOUT() { return getInteger("global_popups.messages.max_players.alert.title.fadeout", 20); }
					}
					public static class SUBTITLE {
						public static String TEXT() { return getString("global_popups.messages.max_players.alert.subtitle.text", ""); }
						public static Integer FADEIN() { return getInteger("global_popups.messages.max_players.alert.subtitle.fadein", 20); }
						public static Integer STAY() { return getInteger("global_popups.messages.max_players.alert.subtitle.stay", 40); }
						public static Integer FADEOUT() { return getInteger("global_popups.messages.max_players.alert.subtitle.fadeout", 20); }
					}
				}
				public static class PRE_SHUTDOWN {
					public static class TITLE {
						public static String TEXT() { return getString("global_popups.messages.max_players.pre_shutdown.title.text", ""); }
						public static Integer FADEIN() { return getInteger("global_popups.messages.max_players.pre_shutdown.title.fadein", 20); }
						public static Integer STAY() { return getInteger("global_popups.messages.max_players.pre_shutdown.title.stay", 40); }
						public static Integer FADEOUT() { return getInteger("global_popups.messages.max_players.pre_shutdown.title.fadeout", 20); }
					}
					public static class SUBTITLE {
						public static String TEXT() { return getString("global_popups.messages.max_players.pre_shutdown.subtitle.text", ""); }
						public static Integer FADEIN() { return getInteger("global_popups.messages.max_players.pre_shutdown.subtitle.fadein", 20); }
						public static Integer STAY() { return getInteger("global_popups.messages.max_players.pre_shutdown.subtitle.stay", 40); }
						public static Integer FADEOUT() { return getInteger("global_popups.messages.max_players.pre_shutdown.subtitle.fadeout", 20); }
					}
				}
			}
			public static class SHUTDOWN {
				public static class TITLE {
					public static String TEXT() { return getString("global_popups.messages.shutdown.title.text", ""); }
					public static Integer FADEIN() { return getInteger("global_popups.messages.shutdown.title.fadein", 20); }
					public static Integer STAY() { return getInteger("global_popups.messages.shutdown.title.stay", 40); }
					public static Integer FADEOUT() { return getInteger("global_popups.messages.shutdown.title.fadeout", 20); }
				}
				public static class SUBTITLE {
					public static String TEXT() { return getString("global_popups.messages.shutdown.subtitle.text", ""); }
					public static Integer FADEIN() { return getInteger("global_popups.messages.shutdown.subtitle.fadein", 20); }
					public static Integer STAY() { return getInteger("global_popups.messages.shutdown.subtitle.stay", 40); }
					public static Integer FADEOUT() { return getInteger("global_popups.messages.shutdown.subtitle.fadeout", 20); }
				}
			}
		}
	}
	
	public static class PRIVATE_POPUPS {
		public static class ENABLED {
			public static Boolean TIME() { return getBoolean("private_popups.enabled.time", true); }
			public static class STATUS {
				public static Boolean START() { return getBoolean("private_popups.enabled.status.start", true); }
				public static Boolean PAUSE() { return getBoolean("private_popups.enabled.status.pause", true); }
			}
			public static Boolean CHANGE() { return getBoolean("private_popups.enabled.change", true); }
		}
		public static class MESSAGES {
			public static class TIME {
				public static class TITLE {
					public static String TEXT() { return getString("private_popups.messages.time.title.text", ""); }
					public static Integer FADEIN() { return getInteger("private_popups.messages.time.title.fadein", 20); }
					public static Integer STAY() { return getInteger("private_popups.messages.time.title.stay", 40); }
					public static Integer FADEOUT() { return getInteger("private_popups.messages.time.title.fadeout", 20); }
				}
				public static class SUBTITLE {
					public static String TEXT() { return getString("private_popups.messages.time.subtitle.text", ""); }
					public static Integer FADEIN() { return getInteger("private_popups.messages.time.subtitle.fadein", 20); }
					public static Integer STAY() { return getInteger("private_popups.messages.time.subtitle.stay", 40); }
					public static Integer FADEOUT() { return getInteger("private_popups.messages.time.subtitle.fadeout", 20); }
				}
			}
			public static class STATUS {
				public static class START {
					public static class TITLE {
						public static String TEXT() { return getString("private_popups.messages.status.start.title.text", ""); }
						public static Integer FADEIN() { return getInteger("private_popups.messages.status.start.title.fadein", 20); }
						public static Integer STAY() { return getInteger("private_popups.messages.status.start.title.stay", 40); }
						public static Integer FADEOUT() { return getInteger("private_popups.messages.status.start.title.fadeout", 20); }
					}
					public static class SUBTITLE {
						public static String TEXT() { return getString("private_popups.messages.status.start.subtitle.text", ""); }
						public static Integer FADEIN() { return getInteger("private_popups.messages.status.start.subtitle.fadein", 20); }
						public static Integer STAY() { return getInteger("private_popups.messages.status.start.subtitle.stay", 40); }
						public static Integer FADEOUT() { return getInteger("private_popups.messages.status.start.subtitle.fadeout", 20); }
					}
				}
				public static class PAUSE {
					public static class TITLE {
						public static String TEXT() { return getString("private_popups.messages.status.pause.title.text", ""); }
						public static Integer FADEIN() { return getInteger("private_popups.messages.status.pause.title.fadein", 20); }
						public static Integer STAY() { return getInteger("private_popups.messages.status.pause.title.stay", 40); }
						public static Integer FADEOUT() { return getInteger("private_popups.messages.status.pause.title.fadeout", 20); }
					}
					public static class SUBTITLE {
						public static String TEXT() { return getString("private_popups.messages.status.pause.subtitle.text", ""); }
						public static Integer FADEIN() { return getInteger("private_popups.messages.status.pause.subtitle.fadein", 20); }
						public static Integer STAY() { return getInteger("private_popups.messages.status.pause.subtitle.stay", 40); }
						public static Integer FADEOUT() { return getInteger("private_popups.messages.status.pause.subtitle.fadeout", 20); }
					}
				}
			}
			public static class CHANGE {
				public static class TITLE {
					public static String TEXT() { return getString("private_popups.messages.change.title.text", ""); }
					public static Integer FADEIN() { return getInteger("private_popups.messages.change.title.fadein", 20); }
					public static Integer STAY() { return getInteger("private_popups.messages.change.title.stay", 40); }
					public static Integer FADEOUT() { return getInteger("private_popups.messages.change.title.fadeout", 20); }
				}
				public static class SUBTITLE {
					public static String TEXT() { return getString("private_popups.messages.change.subtitle.text", ""); }
					public static Integer FADEIN() { return getInteger("private_popups.messages.change.subtitle.fadein", 20); }
					public static Integer STAY() { return getInteger("private_popups.messages.change.subtitle.stay", 40); }
					public static Integer FADEOUT() { return getInteger("private_popups.messages.change.subtitle.fadeout", 20); }
				}
			}
		}
	}
	
	public static class MAX_PLAYERS {
		public static Boolean ENABLED() { return getBoolean("max_players.enabled", true); }
		public static Integer AMOUNT() { return getInteger("max_players.amount", 10); }
		public static Integer DELAY() { return getInteger("max_players.delay", 10); }
	}
	
}

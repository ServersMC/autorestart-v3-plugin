package me.dennis.autorestart.enums;

import java.io.File;
import java.util.concurrent.Callable;

import me.dennis.autorestart.core.AutoRestart;
import me.dennis.autorestart.utils.Console;

public enum FileEnum {
    
    STARTUP_WIN(new Callable<Void>() {
        @Override
        public Void call() throws Exception {
            if (System.getProperty("os.name").contains("Win")) {
            	AutoRestart.PLUGIN.saveResource("start.bat", true);
            }
            return null;
        };
    }),
    STARTUP_UNIX(new Callable<Void>() {
        @Override
        public Void call() throws Exception {
            if (!System.getProperty("os.name").contains("Win")) {
            	AutoRestart.PLUGIN.saveResource("start.sh", true);
            }
            return null;
        };
    }),
    BOOTLOADER(new Callable<Void>() {
		@Override
		public Void call() throws Exception {
            if (!new File(AutoRestart.PLUGIN.getDataFolder(), "AutoRestart-BootLoader.jar").exists()) {
                //AutoRestart.PLUGIN.saveResource("AutoRestart-BootLoader.jar", false);
            }
			return null;
		}
    });
    
    public Callable<Void> func;
    
    private FileEnum(Callable<Void> func) {
        this.func = func;
    }
    
    public void setup() {
        try {
            func.call();
        }
        catch (Exception e) {
        	Console.catchError(e, "FileEnum.setup()");
        }
    }
    
}

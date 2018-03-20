package me.dennis.autorestart.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.dennis.autorestart.core.AutoRestart;

public class UpdateChecker implements Listener {

	public static String LATEST_VERSION = "";
	public static Boolean UPDATE_FOUND = false;
	
	public static void checkUpdate() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("https://gitlab.com/dennislysenko/AutoRestart-v3/raw/master/plugin.yml").openStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith("version:")) {
					LATEST_VERSION = line.split("version:")[1].trim();
					break;
				}
			}
			reader.close();
			if (!LATEST_VERSION.replace("v", "").equalsIgnoreCase(AutoRestart.VERSION)) {
				UPDATE_FOUND = true;
			}
		} catch (IOException ex) {}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		// Get player entity
		Player player = event.getPlayer();
		
		// Check if there is an update
		if (!UPDATE_FOUND) {
			return;
		}
		
		// Check if player is operator
		if (!player.isOp()) {
			return;
		}
		
		// Check if player has moderator permissions
		Boolean found = false;
		List<String> perms = new ArrayList<String>();
		perms.add("autorestart.start");
		perms.add("autorestart.stop");
		perms.add("autorestart.reload");
		perms.add("autorestart.now");
		perms.add("autorestart.in");
		for (String perm : perms) {
			if (player.hasPermission(perm)) {
				found = true;
				break;
			}
		}
		if (!found) {
			return;
		}
		
		// Update notify message
		player.sendMessage(ChatColor.RED + "AutoRestart has an update! Please update to version v" + LATEST_VERSION);
	}
	
}

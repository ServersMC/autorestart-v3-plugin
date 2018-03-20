package me.dennis.autorestart.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.dennis.autorestart.utils.UpdateChecker;

public class UpdateNotifiyEvent implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		// Get player entity
		Player player = event.getPlayer();
		
		// Check if there is an update
		if (!UpdateChecker.UPDATE_FOUND) {
			return;
		}
		
		// Check if player has permissions
		List<String> perms = new ArrayList<String>();
		perms.add("autorestart.start");
		perms.add("autorestart.stop");
		perms.add("autorestart.reload");
		perms.add("autorestart.now");
		perms.add("autorestart.in");
		if (!player.isOp()) {
			return;
		}
		Boolean found = false;
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
		player.sendMessage(ChatColor.RED + "AutoRestart has an update! Please update to version v" + UpdateChecker.LATEST_VERSION);
	}
	
}

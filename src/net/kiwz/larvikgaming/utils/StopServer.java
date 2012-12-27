package net.kiwz.larvikgaming.utils;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;

public class StopServer {
	
	public void stopServer() {
		Server server = Bukkit.getServer();
		Player[] players = server.getOnlinePlayers();
		for (Player player : players) {
			player.kickPlayer("Dont worry! It's just a restart. Come back in a few minutes");
		}
		server.shutdown();
	}

}
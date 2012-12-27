package net.kiwz.larvikgaming.tasks;

import net.kiwz.larvikgaming.utils.OnlinePlayers;
import net.kiwz.larvikgaming.utils.PlayerGroups;
import net.kiwz.larvikgaming.utils.StopServer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class Schedules {
	static Server server = Bukkit.getServer();
	static Plugin larvikGaming = server.getPluginManager().getPlugin("LarvikGaming");
	static FileConfiguration conf = larvikGaming.getConfig();
	int permGroupsRefreshTime = conf.getInt("RefreshGroupInMin", 10) * 1200;
	int onlinePlayersLogTime = conf.getInt("TimeBetweenOnlinePlayersLog", 10) * 1200;
	int restartTime = conf.getInt("RestartTimeInHours", 6) * 20;//72000;
	
	public void PlayerGroups() {
		larvikGaming.getServer().getScheduler().scheduleSyncRepeatingTask(larvikGaming, new Runnable() {
			@Override
			public void run() {
				PlayerGroups pg = new PlayerGroups();
				pg.refreshGroups();
			}
		}, permGroupsRefreshTime - 600, permGroupsRefreshTime);
	}
	
	public void OnlinePlayersLog() {
		larvikGaming.getServer().getScheduler().scheduleSyncRepeatingTask(larvikGaming, new Runnable() {
			@Override
			public void run() {
				OnlinePlayers op = new OnlinePlayers();
				op.makeFile();
			}
		}, onlinePlayersLogTime - 600, onlinePlayersLogTime);
	}
	
	public void StopServer() {
		larvikGaming.getServer().getScheduler().scheduleSyncDelayedTask(larvikGaming, new Runnable() {
			@Override
			public void run() {
				StopServer ss = new StopServer();
				ss.stopServer();
			}
		}, restartTime);
	}
	
	public void StopServerMessage() {
		larvikGaming.getServer().getScheduler().scheduleSyncDelayedTask(larvikGaming, new Runnable() {
			@Override
			public void run() {
				server.broadcastMessage(ChatColor.DARK_PURPLE + "**Server-Restart in 2min**");
			}
		}, restartTime - 2400);
	}
}

package net.kiwz.larvikgaming.tasks;

import net.kiwz.larvikgaming.LarvikGaming;
import net.kiwz.larvikgaming.utils.AutoMessage;
import net.kiwz.larvikgaming.utils.AutoWorldSave;
import net.kiwz.larvikgaming.utils.OnlinePlayers;
import net.kiwz.larvikgaming.utils.PlayerGroups;
import net.kiwz.larvikgaming.utils.StopServer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class Schedules {
	Server server = Bukkit.getServer();
	Plugin larvikGaming = server.getPluginManager().getPlugin("LarvikGaming");
	FileConfiguration conf = larvikGaming.getConfig();
	int autoWorldSaveTime = conf.getInt("autoWorldSaveInMin", 15) * 1200;
	int autoMsgTime = conf.getInt("autoMsgDelayInMin", 20) * 1200;
	int permGroupsRefreshTime = conf.getInt("RefreshGroupInMin", 0) * 1200;
	int onlinePlayersLogTime = conf.getInt("TimeBetweenOnlinePlayersLog", 15) * 1200;
	int restartTime = conf.getInt("RestartTimeInHours", 6) * 72000;
	int autoMsgLine = 0;
	
	public void allSchedules() {
		if (autoWorldSaveTime > 0) {
			autoWorldSave();
		}
		if (autoMsgTime > 0) {
			autoMsg();
		}
		if (permGroupsRefreshTime > 0) {
			playerGroups();
		}
		if (onlinePlayersLogTime > 0) {
			onlinePlayersLog();
		}
		if (restartTime > 0) {
			stopServer();
			stopServerMessage5();
			stopServerMessage1();
			serverStartTime();
		}
	}
	
	private void autoWorldSave() {
		larvikGaming.getServer().getScheduler().scheduleSyncRepeatingTask(larvikGaming, new Runnable() {
			@Override
			public void run() {
				AutoWorldSave aw = new AutoWorldSave();
				aw.autoSave();
			}
		}, autoWorldSaveTime - 100, autoWorldSaveTime);
	}
	
	private void autoMsg() {
		larvikGaming.getServer().getScheduler().scheduleSyncRepeatingTask(larvikGaming, new Runnable() {
			@Override
			public void run() {
				AutoMessage am = new AutoMessage();
				autoMsgLine = am.autoMsgBroadcast(autoMsgLine);
				autoMsgLine++;
			}
		}, autoMsgTime + 200, autoMsgTime);
	}
	
	private void playerGroups() {
		larvikGaming.getServer().getScheduler().scheduleSyncRepeatingTask(larvikGaming, new Runnable() {
			@Override
			public void run() {
				PlayerGroups pg = new PlayerGroups();
				pg.refreshGroups();
			}
		}, permGroupsRefreshTime - 600, permGroupsRefreshTime);
	}
	
	private void onlinePlayersLog() {
		larvikGaming.getServer().getScheduler().scheduleSyncRepeatingTask(larvikGaming, new Runnable() {
			@Override
			public void run() {
				OnlinePlayers op = new OnlinePlayers();
				op.makeFile();
			}
		}, onlinePlayersLogTime - 600, onlinePlayersLogTime);
	}
	
	private void stopServer() {
		larvikGaming.getServer().getScheduler().scheduleSyncDelayedTask(larvikGaming, new Runnable() {
			@Override
			public void run() {
				StopServer ss = new StopServer();
				ss.stopServer();
			}
		}, restartTime + 60);
	}
	
	private void stopServerMessage5() {
		larvikGaming.getServer().getScheduler().scheduleSyncDelayedTask(larvikGaming, new Runnable() {
			@Override
			public void run() {
				server.broadcastMessage(ChatColor.DARK_PURPLE + "**Server-Restart in 5min**");
			}
		}, restartTime - 6000);
	}
	
	private void stopServerMessage1() {
		larvikGaming.getServer().getScheduler().scheduleSyncDelayedTask(larvikGaming, new Runnable() {
			@Override
			public void run() {
				server.broadcastMessage(ChatColor.DARK_PURPLE + "**Server-Restart in 1min**");
			}
		}, restartTime - 1200);
	}
	
	private void serverStartTime() {
		larvikGaming.getServer().getScheduler().scheduleSyncDelayedTask(larvikGaming, new Runnable() {
			@Override
			public void run() {
				LarvikGaming.start = System.currentTimeMillis();
			}
		});
	}
}

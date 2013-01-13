package net.kiwz.larvikgaming.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import net.kiwz.larvikgaming.LarvikGaming;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class OnlinePlayers {
	Logger log = Logger.getLogger("Minecraft");
	Server server = Bukkit.getServer();
	Plugin larvikGaming = server.getPluginManager().getPlugin("LarvikGaming");
	FileConfiguration conf = larvikGaming.getConfig();
	int onlinePlayersLogTime = conf.getInt("TimeBetweenOnlinePlayersLog", 15);
	
	public void onlinePlayers() {
    	long lastMillis = 0;
    	Format  sdf = new SimpleDateFormat("m");
		if (60 % onlinePlayersLogTime == 0) {
	    	if (onlinePlayersLogTime > 59) {
	    		onlinePlayersLogTime = 0;
	    	}
	    	
	    	while (true) {
	        	int time = Integer.parseInt(sdf.format(new Date()));
	        	long currentMillis = System.currentTimeMillis() / 60000;
		        if (time % onlinePlayersLogTime == 0) {
		        	if (lastMillis != currentMillis) {
		        		makeFile();
		        		lastMillis = currentMillis;
		        	}
		        }
	    	}
		}
		else {
			log.warning(LarvikGaming.name + "TimeBetweenOnlinePlayersLog is not a valid number! Disabled!");
		}
	}
	
	private void makeFile() {
		Plugin larvikGaming = Bukkit.getServer().getPluginManager().getPlugin("LarvikGaming");
		String dir = larvikGaming.getConfig().getString("FileDir", "plugins/LarvikGaming/files") + "/misc/";
		Format  sdf = new SimpleDateFormat(larvikGaming.getConfig().getString("TimeFormat", "yyyy-MM-dd HH:mm:ss"));
		String date = sdf.format(new Date());
		File outFile = new File(dir + "player_traffic.txt");
		FileWriter pw = null;
		try {
			pw = new FileWriter(outFile, true);
			pw.write(date + " " + getPlayers() + "\n");
			pw.close();
		} catch (IOException e) {
		}
	}
	
	private int getPlayers() {
		int players = Bukkit.getServer().getOnlinePlayers().length;
		return players;
	}
}

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
	
	public long logOnlinePlayers(long lastMillis) {
		int onlinePlayersLogTime = conf.getInt("TimeBetweenOnlinePlayersLog", 15);
    	Format sdf = new SimpleDateFormat("mm");
    	
		if (60 % onlinePlayersLogTime == 0) {
			
	    	if (onlinePlayersLogTime > 59) {
	    		onlinePlayersLogTime = 0;
	    	}
	    	
        	String time = sdf.format(new Date());
        	long currentMillis = System.currentTimeMillis() / 60000;
	        if (Integer.parseInt(time) % onlinePlayersLogTime == 0 && lastMillis != currentMillis) {
        		makeFile();
        		lastMillis = currentMillis;
	        }
		}
		else {
			log.warning(LarvikGaming.name + "TimeBetweenOnlinePlayersLog is not a valid number! Disabled!");
		}
		return lastMillis;
	}
	
	private void makeFile() {
		String dir = conf.getString("FileDir", "plugins/LarvikGaming/files") + "/misc/";
		Format  sdf = new SimpleDateFormat(conf.getString("TimeFormat", "yyyy-MM-dd HH:mm:ss"));
		String date = sdf.format(new Date());
		File outFile = new File(dir + "player_traffic.txt");
		FileWriter pw = null;
		
		try {
			pw = new FileWriter(outFile, true);
			pw.write(date + " " + getPlayers() + "\n");
			pw.close();
		}
		catch (IOException e) {
		}
	}
	
	private int getPlayers() {
		int players = Bukkit.getServer().getOnlinePlayers().length;
		return players;
	}
}

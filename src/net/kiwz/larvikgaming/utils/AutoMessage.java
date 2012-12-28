package net.kiwz.larvikgaming.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class AutoMessage {

	Plugin larvikGaming = Bukkit.getServer().getPluginManager().getPlugin("LarvikGaming");
	Server server = Bukkit.getServer();
	boolean toConsole = larvikGaming.getConfig().getBoolean("autoMsgToConsole", false);
	String mPre = larvikGaming.getConfig().getString("autoMsgPrefix", "'&d[Viktig Beskjed] '");
	public static File message;
	public static Vector<String> messageList = new Vector<String>();
	
	public int autoMsgBroadcast(int autoMsgLine) {

		msgFile();
		int messages = messageList.size();
		
		if (autoMsgLine >= messages) {
			autoMsgLine = 0;
		}
		
		if (messages != 0 && autoMsgLine < messages) {
			String[] out = messageList.get(autoMsgLine).split(";");
			if (toConsole) {
				for (int i = 0; out.length > i; i++) {
					server.broadcastMessage(out[i]);
				}
			}
			else {
				for (Player p : server.getOnlinePlayers()) {
					for (int i = 0; out.length > i; i++) {
						p.sendMessage(out[i]);
					}
				}
			}
		}
		return autoMsgLine;
	}
	
	private void msgFile() {
		message = new File("plugins/LarvikGaming/Messages.txt");
		
		if (!message.exists())
	    	try {
	    		message.createNewFile();
	    	}
	    catch (IOException localIOException) {
	    }
		messageList.clear();
		
		try {
			Scanner scanner = new Scanner(message);
			while (scanner.hasNextLine()) {
					String in = mPre + ChatColor.WHITE + scanner.nextLine().trim() + ChatColor.WHITE;
					in = in.replaceAll("(&([a-f0-9]))", "\u00A7$2");
					messageList.add(in);
	        }
			scanner.close();
		}
		catch (FileNotFoundException localFileNotFoundException) {
	    }
	}
}

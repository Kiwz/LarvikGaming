package net.kiwz.larvikgaming.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import net.kiwz.larvikgaming.LarvikGaming;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;


public class PlayerGroups {

	String Group;
	String Name;

	public String refreshGroups() {
		long startTime = System.currentTimeMillis();
		Logger log = Logger.getLogger("Minecraft");
		Plugin larvikGaming = Bukkit.getServer().getPluginManager().getPlugin("LarvikGaming");
		String fileSrc = "plugins/bPermissions/" + larvikGaming.getConfig().getString("WorldToGetGroupFrom", "world") + "/";
		String fileDest = larvikGaming.getConfig().getString("FileDir", "plugins/LarvikGaming/files") + "/";
		String miscFolder = fileDest + "misc/";
		File origUsers = new File(fileSrc + "users.yml");
		File destUsers = new File(miscFolder + "perm_groups.txt");
		boolean logTime = larvikGaming.getConfig().getBoolean("LogGetGroupTime", false);
		List<String> groups = larvikGaming.getConfig().getStringList("Groups");
		String cmdSender = "";
		boolean outException = false;
		boolean inException = false;
		try {
			PrintStream printStream = new PrintStream(destUsers);
			for (int i=0; i < groups.size(); i++) {
				try {
					Scanner scanner = new Scanner(origUsers);
					String playerName = "";
					printStream.println("Group " + groups.get(i) + ":");
					int players = 0;
					while (scanner.hasNextLine()) {
						String line = scanner.nextLine();
						if (line.contains("  ") && !line.contains("   ")) {
							playerName = line;
						}
						if (line.contains("groups:")) {
							if (scanner.nextLine().contains("    - " + groups.get(i))) {
								String trimmed = playerName.replaceAll("[':-]", "");
								String formatted = String.format("%04d", players + 1);
								printStream.println(formatted + ". " + trimmed.trim());
								players++;
							}
						}
					}
					printStream.println();
					scanner.close();
				}
				catch (FileNotFoundException e) {
					inException = true;
				}
			}
			printStream.close();
		}
		catch (FileNotFoundException e) {
			outException = true;
		}
		if (outException || inException) {
			cmdSender = ("Syntax error! More information in your server.log");
		}
		if (inException) {
			log.warning(LarvikGaming.name + "File: " + origUsers + " not found!");
		}
		if (outException) {
			log.warning(LarvikGaming.name + "FileDir: " + miscFolder + " do not excist!");
		}
		else {
			long endTime = System.currentTimeMillis() - startTime;
			cmdSender = ("Time used to generate this information: " + endTime + "ms.");
			if (logTime) {
				log.info(LarvikGaming.name + "Time used to generate perm_groups.txt: " + endTime + "ms.");
			}
		}
		return cmdSender;
	}
}

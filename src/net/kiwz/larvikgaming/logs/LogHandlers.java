package net.kiwz.larvikgaming.logs;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
//import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class LogHandlers {

	private static Logger log = Logger.getLogger("Minecraft");
	private static Logger global = Logger.getLogger("");
	private static Plugin larvikGaming = Bukkit.getServer().getPluginManager().getPlugin("LarvikGaming");
	private static String folderToSave = larvikGaming.getConfig().getString("FileDir", "plugins/LarvikGaming/files") + "/";
	private static String logFolder = folderToSave + "logs/";
	private static String log_file = logFolder + "log.txt";
	private static String info_file = logFolder + "info_log.txt";
	private static String warning_file = logFolder + "warning_log.txt";
	private static String severe_file = logFolder + "severe_log.txt";

	public static void log() {
		boolean full = larvikGaming.getConfig().getBoolean("Full-Logger", true);
		boolean info = larvikGaming.getConfig().getBoolean("Info-Logger", false);
		boolean warning = larvikGaming.getConfig().getBoolean("Warning-Logger", true);
		boolean severe = larvikGaming.getConfig().getBoolean("Severe-Logger", true);
		File log_lck = new File(log_file + ".lck");
		File info_lck = new File(info_file + ".lck");
		File warning_lck = new File(warning_file + ".lck");
		File severe_lck = new File(severe_file + ".lck");
		if (log_lck.exists()) {
			log_lck.delete();
		}
		if (info_lck.exists()) {
			info_lck.delete();
		}
		if (warning_lck.exists()) {
			warning_lck.delete();
		}
		if (severe_lck.exists()) {
			severe_lck.delete();
		}
		
		log.setLevel(Level.ALL);
		//Handler[] mcHandler = log.getHandlers();
		//mcHandler[0].setLevel(Level.INFO);
		if (full)
			full();
		if (info)
			info();
		if (warning)
			warning();
		if (severe)
			severe();
	}
	
	private static void full() {
		FileHandler fullHandler = null;
		try {
			fullHandler = new FileHandler(log_file, true);
		} catch (IOException e) {
		}
		log.addHandler(fullHandler);
		global.addHandler(fullHandler);
		fullHandler.setLevel(Level.ALL);
		fullHandler.setFormatter(new FullFormatter());
	}
	
	private static void info() {
		FileHandler infoHandler = null;
		try {
			infoHandler = new FileHandler(info_file, true);
		} catch (IOException e) {
		}
		log.addHandler(infoHandler);
		global.addHandler(infoHandler);
		infoHandler.setLevel(Level.INFO);
		infoHandler.setFormatter(new InfoFormatter());
	}
	
	private static void warning() {
		FileHandler warningHandler = null;
		try {
			warningHandler = new FileHandler(warning_file, true);
		} catch (IOException e) {
		}
		log.addHandler(warningHandler);
		global.addHandler(warningHandler);
		warningHandler.setLevel(Level.WARNING);
		warningHandler.setFormatter(new WarningFormatter());
	}
	
	private static void severe() {
		FileHandler severeHandler = null;
		try {
			severeHandler = new FileHandler(severe_file, true);
		} catch (IOException e) {
		}
		log.addHandler(severeHandler);
		global.addHandler(severeHandler);
		severeHandler.setLevel(Level.SEVERE);
		severeHandler.setFormatter(new SevereFormatter());
	}
}

package net.kiwz.larvikgaming;

import net.kiwz.larvikgaming.utils.PlayerGroups;
import net.kiwz.larvikgaming.utils.StopServer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;


public class Commands implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Plugin larvikGaming = Bukkit.getServer().getPluginManager().getPlugin("LarvikGaming");
		ChatColor color = ChatColor.DARK_GREEN;
		
		if (cmd.getName().equalsIgnoreCase("lginfo") && sender.hasPermission("larvikgaming.info")) {
			PluginDescriptionFile pdFile = larvikGaming.getDescription();
			sender.sendMessage(color + "The [" + pdFile.getName() + "] plugin is running version: " + pdFile.getVersion());
			sender.sendMessage(color + "Here is a list of commands to use:");
			sender.sendMessage(color + "</lginfo> Shows this information.");
			sender.sendMessage(color + "</help larvikgaming> Show the help entries.");
			sender.sendMessage(color + "</lgrestart> Will stop the server!");
			sender.sendMessage(color + "</lgreload> Reloads this plugin.");
			sender.sendMessage(color + "</lggroups> Create a user.txt file that contains groups of players.");
			sender.sendMessage(color + "</restart> Gives information about time untill next restart.");
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("lgreload") && sender.hasPermission("larvikgaming.reload")) {
			Bukkit.getPluginManager().disablePlugin(larvikGaming);
			larvikGaming.reloadConfig();
			Bukkit.getPluginManager().enablePlugin(larvikGaming);
			if (sender instanceof Player) {
				sender.sendMessage(color + "The LarivkGaming plugin is reloaded!");
			}
			else {
				sender.sendMessage(LarvikGaming.name + color + "Plugin is reloaded!");
			}
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("lgrestart") && sender.hasPermission("larvikgaming.restart")) {
			StopServer.stopServer();
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("lggroups") && sender.hasPermission("larvikgaming.groups")) {
			String message = "";
			message = PlayerGroups.refreshGroups();
			if (sender instanceof Player) {
				sender.sendMessage(color + message);
			}
			else {
				if (!larvikGaming.getConfig().getBoolean("LogGetGroupTime", false)) {
					sender.sendMessage(LarvikGaming.name + color + message);
				}
			}
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("restart")) {
			int restart = larvikGaming.getConfig().getInt("RestartTimeInHours", 6) * 3600000;
			long time = System.currentTimeMillis() - LarvikGaming.start;
			long left = restart - time;
			left = left / 60000;
			long hour = left / 60;
			long min = left % 60;
			sender.sendMessage(color + "[LarvikGaming] Tid til neste restart av serveren: " + hour + " timer, " + min + " minutter.");
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("lgtest") && sender.hasPermission("larvikgaming.test")) {
			long start = System.currentTimeMillis();
			
			// All testing stuff goes in here:

			// All testing stuff ends here!
			
			sender.sendMessage("Dette er 'test' kommandoen til larvikgaming! " + (System.currentTimeMillis() - start));
			return true;
		}
		return false;
	}
}
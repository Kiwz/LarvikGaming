package net.kiwz.larvikgaming;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
			sender.sendMessage(color + "</help larvikgaming> Will maybe show the help entries.");
			sender.sendMessage(color + "</lgstop> Will stop the server!");
			sender.sendMessage(color + "</lggroups> Create a perm_groups.txt file that contains groups of players.");
			sender.sendMessage(color + "</lgrestart> Gives information about time untill next restart.");
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("lgstop") && sender.hasPermission("larvikgaming.stop")) {
			StopServer ss = new StopServer();
			ss.stopServer();
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("lggroups") && sender.hasPermission("larvikgaming.groups")) {
			String message = "";
			PlayerGroups pg = new PlayerGroups();
			message = pg.refreshGroups();
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
		
		if (cmd.getName().equalsIgnoreCase("lgrestart") && sender.hasPermission("larvikgaming.restart")) {
			if (LarvikGaming.start == 0) {
				sender.sendMessage(color + "[LarvikGaming] Serveren vil ikke restarte automatisk!");
			}
			else {
				DateFormat df = new SimpleDateFormat("HH:mm:ss");
				int restart = larvikGaming.getConfig().getInt("RestartTimeInHours", 6) * 3600000;
				long serverStartTime = System.currentTimeMillis() - LarvikGaming.start;
				long milliSeconds = restart - serverStartTime - 3600000;
				sender.sendMessage(color + "[LarvikGaming] Neste server restart: " + df.format(new Date(milliSeconds)));
			}
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
package net.kiwz.larvikgaming.utils;

import net.kiwz.larvikgaming.LarvikGaming;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class AutoWorldSave {

	public void autoSave()
	{
		for (Player p : Bukkit.getServer().getOnlinePlayers()) {
			p.sendMessage(ChatColor.DARK_PURPLE + LarvikGaming.name + "Starter auto-lagring!");
		}
		long startTime = System.currentTimeMillis();
		
		Bukkit.savePlayers();
		/*for (Player p : Bukkit.getServer().getOnlinePlayers()) {
			p.sendMessage(ChatColor.GOLD + LarvikGaming.name + "Spillere lagret!");
		}*/
		
		for (World world : Bukkit.getWorlds()) {
			world.save();
			/*for (Player p : Bukkit.getServer().getOnlinePlayers()) {
				p.sendMessage(ChatColor.GOLD + LarvikGaming.name + world.getName() + " lagret!");
			}*/
		}
		long elapsedTime = System.currentTimeMillis() - startTime;
		Bukkit.broadcastMessage(ChatColor.DARK_GREEN + LarvikGaming.name + "Auto-lagring fullført på: " + elapsedTime + "ms.");
	}
}
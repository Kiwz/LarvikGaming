package net.kiwz.larvikgaming.listeners;

import net.kiwz.larvikgaming.logs.CmdLogger;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

public class CommandListener implements Listener {
	
	private Server server = Bukkit.getServer();
	Plugin larvikGaming = Bukkit.getServer().getPluginManager().getPlugin("LarvikGaming");
	ChatColor color = ChatColor.DARK_GREEN;
	
	@EventHandler
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
		Player player = e.getPlayer();
		String playername = player.getName();
		String cmd = e.getMessage();
		
		CmdLogger cl = new CmdLogger();
		cl.cmdLogger(playername, cmd);
		cl.privMsgLogger(playername, cmd);
		
		//The following will add a fee to the /tp command:
		String[] args = cmd.split(" ");
	    if(args[0].equalsIgnoreCase("/tp") && (args.length > 1)) {
			if (player.hasPermission("larvikgaming.freetp")) {
				player.sendMessage(color + "[LarvikGaming] Du er frikjent fra teleporterings avgiften!");
			}
			else {
				int charge = larvikGaming.getConfig().getInt("TeleportCharge", 30);
				Economy econ = server.getServicesManager().getRegistration(Economy.class).getProvider();
				EconomyResponse r = econ.withdrawPlayer(playername, charge);
				if (r.transactionSuccess()) {
					player.sendMessage(color + "[LarvikGaming] Teleportering koster " + charge + " Dollar!");
					player.sendMessage(color + "[LarvikGaming] Uansett om du blir teleportert eller ikke.");
				}
				else {
					e.setCancelled(true);
					player.sendMessage(color + "[LarvikGaming] Denne kommandoen koster " + charge + " Dollar!");
					player.sendMessage(color + "[LarvikGaming] Du har IKKE " + charge + " Dollar og kan dermed ikke teleportere!");
				}
			}
		}
	}
}
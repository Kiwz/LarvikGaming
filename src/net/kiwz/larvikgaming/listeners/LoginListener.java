package net.kiwz.larvikgaming.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LoginListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        String pName = p.getName();
        
    	if (pName.length() + 4 > 16) {
    		pName = pName.substring(0, 12);
    	}

        if (p.hasPermission("larvikgaming.tab.aqua")) {
            p.setPlayerListName(ChatColor.AQUA + pName + ChatColor.WHITE);
        }
        else if (p.hasPermission("larvikgaming.tab.black")) {
            p.setPlayerListName(ChatColor.BLACK + pName + ChatColor.WHITE);
        }
        else if (p.hasPermission("larvikgaming.tab.blue")) {
            p.setPlayerListName(ChatColor.BLUE + pName + ChatColor.WHITE);
        }
        else if (p.hasPermission("larvikgaming.tab.dark_aqua")) {
            p.setPlayerListName(ChatColor.DARK_AQUA + pName + ChatColor.WHITE);
        }
        else if (p.hasPermission("larvikgaming.tab.dark_blue")) {
            p.setPlayerListName(ChatColor.DARK_BLUE + pName + ChatColor.WHITE);
        }
        else if (p.hasPermission("larvikgaming.tab.dark_gray")) {
            p.setPlayerListName(ChatColor.DARK_GRAY + pName + ChatColor.WHITE);
        }
        else if (p.hasPermission("larvikgaming.tab.dark_green")) {
            p.setPlayerListName(ChatColor.DARK_GREEN + pName + ChatColor.WHITE);
        }
        else if (p.hasPermission("larvikgaming.tab.dark_purple")) {
            p.setPlayerListName(ChatColor.DARK_PURPLE + pName + ChatColor.WHITE);
        }
        else if (p.hasPermission("larvikgaming.tab.dark_red")) {
            p.setPlayerListName(ChatColor.DARK_RED + pName + ChatColor.WHITE);
        }
        else if (p.hasPermission("larvikgaming.tab.gold")) {
            p.setPlayerListName(ChatColor.GOLD + pName + ChatColor.WHITE);
        }
        else if (p.hasPermission("larvikgaming.tab.gray")) {
            p.setPlayerListName(ChatColor.GRAY + pName + ChatColor.WHITE);
        }
        else if (p.hasPermission("larvikgaming.tab.green")) {
            p.setPlayerListName(ChatColor.GREEN + pName + ChatColor.WHITE);
        }
        else if (p.hasPermission("larvikgaming.tab.light_purple")) {
            p.setPlayerListName(ChatColor.LIGHT_PURPLE + pName + ChatColor.WHITE);
        }
        else if (p.hasPermission("larvikgaming.tab.red") || p.hasPermission("larvikgaming.tab.*")) {
            p.setPlayerListName(ChatColor.RED + pName + ChatColor.WHITE);
        }
        else if (p.hasPermission("larvikgaming.tab.yellow")) {
            p.setPlayerListName(ChatColor.YELLOW + pName + ChatColor.WHITE);
        }
    }
}
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

        if (p.hasPermission("tablist.aqua")) {
            p.setPlayerListName(ChatColor.AQUA + p.getName() + ChatColor.WHITE);
        }
        else if (p.hasPermission("tablist.black")) {
            p.setPlayerListName(ChatColor.BLACK + p.getName() + ChatColor.WHITE);
        }
        else if (p.hasPermission("tablist.blue")) {
            p.setPlayerListName(ChatColor.BLUE + p.getName() + ChatColor.WHITE);
        }
        else if (p.hasPermission("tablist.dark_aqua")) {
            p.setPlayerListName(ChatColor.DARK_AQUA + p.getName() + ChatColor.WHITE);
        }
        else if (p.hasPermission("tablist.dark_blue")) {
            p.setPlayerListName(ChatColor.DARK_BLUE + p.getName() + ChatColor.WHITE);
        }
        else if (p.hasPermission("tablist.dark_gray")) {
            p.setPlayerListName(ChatColor.DARK_GRAY + p.getName() + ChatColor.WHITE);
        }
        else if (p.hasPermission("tablist.dark_green")) {
            p.setPlayerListName(ChatColor.DARK_GREEN + p.getName() + ChatColor.WHITE);
        }
        else if (p.hasPermission("tablist.dark_purple")) {
            p.setPlayerListName(ChatColor.DARK_PURPLE + p.getName() + ChatColor.WHITE);
        }
        else if (p.hasPermission("tablist.dark_red")) {
            p.setPlayerListName(ChatColor.DARK_RED + p.getName() + ChatColor.WHITE);
        }
        else if (p.hasPermission("tablist.gold")) {
            p.setPlayerListName(ChatColor.GOLD + p.getName() + ChatColor.WHITE);
        }
        else if (p.hasPermission("tablist.gray")) {
            p.setPlayerListName(ChatColor.GRAY + p.getName() + ChatColor.WHITE);
        }
        else if (p.hasPermission("tablist.green")) {
            p.setPlayerListName(ChatColor.GREEN + p.getName() + ChatColor.WHITE);
        }
        else if (p.hasPermission("tablist.light_purple")) {
            p.setPlayerListName(ChatColor.LIGHT_PURPLE + p.getName() + ChatColor.WHITE);
        }
        else if (p.hasPermission("tablist.red") || p.hasPermission("tablist.*")) {
            p.setPlayerListName(ChatColor.RED + p.getName() + ChatColor.WHITE);
        }
        else if (p.hasPermission("tablist.yellow")) {
            p.setPlayerListName(ChatColor.YELLOW + p.getName() + ChatColor.WHITE);
        }
    }
}
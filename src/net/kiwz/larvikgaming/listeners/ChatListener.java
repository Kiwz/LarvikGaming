package net.kiwz.larvikgaming.listeners;

import net.kiwz.larvikgaming.logs.ChatLogger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
//import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		String player = e.getPlayer().getName();
		String message = e.getMessage();
		
		ChatLogger cl = new ChatLogger();
		cl.chatLogger(player, message);
	}
}
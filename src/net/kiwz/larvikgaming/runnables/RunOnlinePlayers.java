package net.kiwz.larvikgaming.runnables;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import net.kiwz.larvikgaming.utils.OnlinePlayers;

public class RunOnlinePlayers implements Runnable {
	
	private boolean go = true;
	
	public void setGo(boolean go) {
		this.go = go;
	}
	
	public void run() {
		Plugin larvikGaming = Bukkit.getServer().getPluginManager().getPlugin("LarvikGaming");
		int delay = larvikGaming.getConfig().getInt("TimeBetweenOnlinePlayersLog", 10) * 60000;
    	if (delay < 1) {
    		return;
    	}
	    while (go) {
			try {
				Thread.sleep(delay);
			}
			catch (InterruptedException e) {
			}
			if (go) {
				OnlinePlayers op = new OnlinePlayers();
				op.makeFile();
			}
	    }
	}
	

}
package net.kiwz.larvikgaming;

import java.util.logging.Logger;

import net.kiwz.larvikgaming.listeners.ChatListener;
import net.kiwz.larvikgaming.listeners.CommandListener;
import net.kiwz.larvikgaming.listeners.LoginListener;
import net.kiwz.larvikgaming.logs.LogHandlers;
import net.kiwz.larvikgaming.runnables.RunAutoMessage;
import net.kiwz.larvikgaming.runnables.Threads;
import net.kiwz.larvikgaming.tasks.Schedules;
import net.kiwz.larvikgaming.utils.ConfigHeader;
import net.kiwz.larvikgaming.utils.MakeFolders;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class LarvikGaming extends JavaPlugin {

	public static String name = "[LarvikGaming] ";
	public static long start = System.currentTimeMillis();
	private Logger log = Logger.getLogger("Minecraft");
	private PluginManager pm = Bukkit.getServer().getPluginManager();
	private RunAutoMessage abm;
	
	public void onLoad() {
		this.getConfig().options().copyDefaults(true);
		this.getConfig().options().header(ConfigHeader.header());
		this.saveConfig();
		MakeFolders.makeDirs();
		LogHandlers.log();
	}
	
	public void onEnable() {
		Commands cmds = new Commands();
		getCommand("lginfo").setExecutor(cmds);
		getCommand("lgrestart").setExecutor(cmds);
	    getCommand("lggroups").setExecutor(cmds);
	    getCommand("restart").setExecutor(cmds);
	    getCommand("lgtest").setExecutor(cmds);
	    
	    ChatListener chat = new ChatListener();
	    pm.registerEvents(chat, this);
	    
	    CommandListener cmd = new CommandListener();
	    pm.registerEvents(cmd, this);
	    
	    LoginListener ll = new LoginListener();
	    pm.registerEvents(ll, this);
	    
	    Schedules sche = new Schedules();
	    sche.PlayerGroups();
	    sche.OnlinePlayersLog();
	    sche.StopServer();
	    sche.StopServerMessage();
	    
	    //////////////
	    abm = Threads.threadABM();
	    ///////////////
		log.info(name + "ENABLED!");
	}

	public void onDisable() {
		////////////
		if (abm != null) {
			abm.setGo(false);
		}
		///////////////
		log.info(name + "DISABLED!");
	}
}
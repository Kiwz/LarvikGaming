package net.kiwz.larvikgaming.runnables;

public class Threads {
	
	public static RunAutoMessage threadABM() {
		RunAutoMessage run = new RunAutoMessage();
		Thread thread = new Thread(run);
	    thread.start();
		return run;
	}
	
	public static RunOnlinePlayers threadOP() {
		RunOnlinePlayers run = new RunOnlinePlayers();
	    Thread thread = new Thread(run);
	    thread.start();
		return run;
	}
	
	public static RunPlayerGroups threadPG() {
		RunPlayerGroups run = new RunPlayerGroups();
	    Thread thread = new Thread(run);
	    thread.start();
		return run;
	}
	
	public static RunStopServer threadSS() {
		RunStopServer run = new RunStopServer();
	    Thread thread = new Thread(run);
	    thread.start();
		return run;
	}
}
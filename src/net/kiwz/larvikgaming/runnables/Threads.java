package net.kiwz.larvikgaming.runnables;

public class Threads {
	
	public static RunAutoMessage threadABM() {
		RunAutoMessage run = new RunAutoMessage();
		Thread thread = new Thread(run);
	    thread.start();
		return run;
	}
}
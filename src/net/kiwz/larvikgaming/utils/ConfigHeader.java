package net.kiwz.larvikgaming.utils;

public class ConfigHeader {
	
	public static String header() {
		
		String n = "\n";
		
		String s01 = "Configurations for LarvikGaming plugin!" + n;
		String s02 = "Author: Kiwz!" + n;
		String s03 = "Remember to keep it in yml format!" + n + n;
		String s04 = "</lginfo> <larvikgaming.info> Displayes  some information about this plugin." + n;
		String s05 = "</lgreload> <larvikgaming.reload> Reloads this plugin." + n;
		String s06 = "</lgrestart> <larvikgaming.restart> Restarts the server completly." + n;
		String s08 = "</lggroups> <larvikgaming.groups> Generates a txt file with bPerm's users sortet into groups." + n;
		String s081 = "</restart> <none> Copies all the files in 'FilesToCopy'." + n;
		String s082 = "<> <larvikgaming.freetp> This permissionons will skip the money charge when /tp commando is used." + n + n;
		String s083 = "TeleportCharge = How many money a player is charged upon using /tp commands." + n;
		String s09 = "autoMsgDelayInMin = How many minutes between each line in the 'messages.txt' is broadcastet to all players. 0 to disable this feature." + n;
		String s10 = "autoMsgToConsole = If 'true' all messages will also be broadcastet in your console." + n;
		String s11 = "autoMsgPrefix = This text will be added in front of each broadcastet message, you can use regular color codes here." + n;
		String s12 = "RestartTimeInHours = Time in hours between each server restart, remember to make a loop in your 'start.bat' file as this will just stop the server! 0 to disable this feature." + n;
		String s13 = "FileDir = Where you want this plugin to store all the files it handles. I.e. 'C:/whatever/you/like'." + n;
		String s14 = "TimeBetweenOnlinePlayersLog = Time in minutes between each time to log how many players are online. 0 to disable this." + n;
		String s19 = "LogGetGroupTime = If 'true' it will log the time it takes to generate the 'users.txt' file from bPermissions." + n;
		String s20 = "RefreshGroupInMin = How many minutes between each time the 'users.txt' file will be uppdated.  0 to disable this feature. Set to 0 if you do not have bPermissions!" + n;
		String s21 = "WorldToGetGroupFrom = I am sorry to tell that this is not a multiworld plugin, so choose what world you want to get groups from." + n;
		String s22 = "Groups = A list of what groups you care about." + n;
		String s23 = "TimeFormat = This is how you want the time stamp to look like in front of all lines in the next logging files. See http://docs.oracle.com/javase/1.4.2/docs/api/java/text/SimpleDateFormat.html" + n;
		String s24 = "CmdToLog = A list of all the commands you want to log to 'Cmd-Logger1.txt'." + n;
		String s26 = "PrivMsgToLog = A list of all the commands your players use to whisper, this will be logged to 'Private-Msg.txt'." + n;
		String s27 = "Chat = If 'true' it will log the chat from your players to 'Chat.txt'." + n;
		String s28 = "Full-Logger = If 'true' it will log everything to 'Full-Logger.txt'" + n;
		String s29 = "Fine-Logger = If 'true' it will log all finest, finer and fine levels to 'Fine-Logger.txt' (theese levels are almost never in use)" + n;
		String s30 = "Info-Logger = If 'true' it will log all info levels to 'Info-Logger.txt'" + n;
		String s31 = "Warning-Logger = If 'true' it will log all warning levels to 'Warning-Logger.txt'" + n;
		String s32 = "Severe-Logger = If 'true' it will log all severe levels to 'Severe-Logger.txt'" + n;
		
		String header = s01 + s02 + s03 + s04 + s05 + s06 + s08 + s081 + s082 + s083 + s09 + s10 +
				s11 + s12 + s13 + s14 + s19 + s20 +
				s21 + s22 + s23 + s24 + s26 + s27 + s28 + s29 + s30 +
				s31 + s32;
		
		return header;
	}
}
package alisolarflare.components.links;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.lib.chat.TBMCCommandBase;

public class Command_PressAliLink extends TBMCCommandBase {
	private JavaPlugin plugin;
	private Command_SetAliLink setAliLink;

	public Command_PressAliLink(JavaPlugin plugin, Command_SetAliLink setAliLink) {
		this.plugin = plugin;
		this.setAliLink = setAliLink;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {

		sender.getServer().broadcastMessage(setAliLink.linkList.toString() + "over.");

		if (args.length < 1) {
			sender.sendMessage("You must specify a link frequency");
			sender.sendMessage("/pressalilink [frequency]");
		}
		for (Memory_Link link : setAliLink.linkList) {
			for (String inputlink : args) {
				if (inputlink.equals(link.frequency)) {
					link.press(plugin);
				}
			}
		}
		return false;
	}

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String GetCommandPath() {
		return "pressalilink";
	}

	@Override
	public boolean GetPlayerOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean GetModOnly() {
		// TODO Auto-generated method stub
		return false;
	}

}

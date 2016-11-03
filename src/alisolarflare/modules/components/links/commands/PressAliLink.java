package alisolarflare.modules.components.links.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.modules.components.links.entities.Link;
import buttondevteam.lib.chat.TBMCCommandBase;

public class PressAliLink extends TBMCCommandBase {
	private JavaPlugin plugin;
	private SetAliLink setAliLink;

	public PressAliLink(JavaPlugin plugin, SetAliLink setAliLink) {
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
		for (Link link : setAliLink.linkList) {
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

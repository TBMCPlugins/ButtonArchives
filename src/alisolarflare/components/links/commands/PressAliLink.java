package alisolarflare.components.links.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.links.entities.Link;
import alisolarflare.modules.PlayerCommand;

public class PressAliLink extends PlayerCommand {
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
		return null;
	}
}

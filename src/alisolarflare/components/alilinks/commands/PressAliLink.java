package alisolarflare.components.alilinks.commands;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.PlayerCommand;
import alisolarflare.components.alilinks.entities.Link;

public class PressAliLink extends PlayerCommand {
	private JavaPlugin plugin;
	private List<Link> linkList;

	public PressAliLink(JavaPlugin plugin, List<Link> linkList) {
		this.plugin = plugin;
		this.linkList = linkList;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] inputFrequencies) {
		if (inputFrequencies.length < 1) {
			sender.sendMessage("You must specify a link frequency");
			return false;
		}
		
		for (Link link : linkList) {
			for (String frequency : inputFrequencies) {
				if (frequency.equals(link.frequency)) {
					link.press(plugin);
				}
			}
		}
		sender.sendMessage("Link pressed!");
		return true;
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{
			"Usage: /pressalilink <frequency>"
		};
	}
}

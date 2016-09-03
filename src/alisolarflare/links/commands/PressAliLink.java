package alisolarflare.links.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import alisolarflare.links.AliLinkSubPlug;
import alisolarflare.links.entities.Link;

public class PressAliLink implements CommandExecutor{
	private AliLinkSubPlug subplugin;
	public PressAliLink(AliLinkSubPlug subplugin){
		this.subplugin = subplugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		subplugin.plugin.getServer().broadcastMessage(subplugin.linkList.toString() + "over.");
		
		if (args.length < 1){
			sender.sendMessage("You must specify a link frequency");
			sender.sendMessage("/pressalilink [frequency]");
		}
		for (Link link: subplugin.linkList){
			for (String inputlink: args){
				if(inputlink.equals(link.frequency)){
					link.press(subplugin);
				}
			}
		}
		return false;
	}

}

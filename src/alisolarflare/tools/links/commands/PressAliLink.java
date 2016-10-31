package alisolarflare.links.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import alisolarflare.links.AliLinkSubPlug;
import alisolarflare.links.entities.Link;

public class PressAliLink implements CommandExecutor{
	private AliLinkSubPlug subplugin;
	private SetAliLink setAliLink;
	public PressAliLink(AliLinkSubPlug subplugin, SetAliLink setAliLink){
		this.subplugin = subplugin;
		this.setAliLink	= setAliLink;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		subplugin.plugin.getServer().broadcastMessage(setAliLink.linkList.toString() + "over.");
		
		if (args.length < 1){
			sender.sendMessage("You must specify a link frequency");
			sender.sendMessage("/pressalilink [frequency]");
		}
		for (Link link: setAliLink.linkList){
			for (String inputlink: args){
				if(inputlink.equals(link.frequency)){
					link.press(subplugin);
				}
			}
		}
		return false;
	}

}

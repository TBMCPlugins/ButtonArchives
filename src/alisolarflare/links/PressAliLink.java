package alisolarflare.links;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PressAliLink implements CommandExecutor{
	private AliLinkSubPlugin subplugin;
	public PressAliLink(AliLinkSubPlugin subplugin){
		this.subplugin = subplugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args == null){
			sender.sendMessage("You must specify a link frequency");
			sender.sendMessage("/pressalilink [frequency]");
		}
		for (Link link: subplugin.linkList){
			for (String inputlink: args){
				if(inputlink.equals(link.frequency)){
					link.press();
				}
			}
		}
		return false;
	}

}

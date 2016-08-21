package alisolarflare.links;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetAliLink implements CommandExecutor{
	AliLinkSubPlug subplugin;
	public SetAliLink(AliLinkSubPlug plugin){
		this.subplugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args == null){
			sender.sendMessage("You must specify a link frequency");
			sender.sendMessage("/pressalilink [name]");
		}
		if (!(sender instanceof Player)){
			sender.sendMessage("You must be a player to use this command!");
		}
		Player player = (Player) sender;
		if (args.length < 4){
			subplugin.linkList.add(new Link(subplugin, args[0], player.getLocation()));
			subplugin.serializer.saveLinkList(subplugin.linkList);
			return false;
		}
		if (StringUtils.isNumericSpace(args[1]) && StringUtils.isNumericSpace(args[2]) && StringUtils.isNumericSpace(args[3])){
			subplugin.linkList.add(new Link(subplugin, args[0],new Location(player.getWorld(), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]))));
			subplugin.serializer.saveLinkList(subplugin.linkList);
		}else{
			subplugin.linkList.add(new Link(subplugin, args[0], player.getLocation()));
			subplugin.serializer.saveLinkList(subplugin.linkList);
			return false;
		}
		return false;
	}
	
}

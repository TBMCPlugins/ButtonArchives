package alisolarflare.links.commands;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.links.AliLinkSubPlug;
import alisolarflare.links.entities.Link;

public class SetAliLink implements CommandExecutor{
	AliLinkSubPlug subplugin;
	public SetAliLink(AliLinkSubPlug plugin){
		this.subplugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sender.sendMessage("you pressed shit");
		if (args == null || args.length < 1){
			sender.sendMessage("You must specify a link frequency");
			sender.sendMessage("/pressalilink [name]");
			return false;
		}
		if (!(sender instanceof Player)){
			sender.sendMessage("You must be a player to use this command!");
		}
		Player player = (Player) sender;
		if (args.length < 4){
			player.sendMessage("short");
			subplugin.linkList.add(new Link(args[0], player.getLocation()));
			save(player);
			player.sendMessage("end");
			return false;
		}
		if (StringUtils.isNumericSpace(args[1]) && StringUtils.isNumericSpace(args[2]) && StringUtils.isNumericSpace(args[3])){
			player.sendMessage("CUUUSTOM");
			subplugin.linkList.add(new Link(args[0],new Location(player.getWorld(), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]))));
			save(player);
			player.sendMessage("FINISHED");
		}else{
			player.sendMessage("UNCUSTOOM");
			subplugin.linkList.add(new Link(args[0], player.getLocation()));
			save(player);
			player.sendMessage("UNFINISHED");
			return false;
		}
		return false;
	}
	private void save(Player player){
		player.sendMessage("SAAAVING");
		subplugin.plugin.getConfig().set("aliLinkList", subplugin.linkList);
		try {
			player.sendMessage("SAVIN");
			subplugin.plugin.getConfig().save("aliLinkList");
			player.sendMessage("GOOD SAVE");
		} catch (IOException e) {
			player.sendMessage("YOU FUCKED STUFF UP");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

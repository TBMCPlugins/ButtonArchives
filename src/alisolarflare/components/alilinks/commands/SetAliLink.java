package alisolarflare.components.alilinks.commands;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import alisolarflare.components.PlayerCommand;
import alisolarflare.components.alilinks.entities.Link;

public class SetAliLink extends PlayerCommand {
	public List<Link> linkList;
	public List<Map<String, String>> linkData;
	private FileConfiguration config;
	
	public SetAliLink(FileConfiguration config, List<Link> linkList, List<Map<String, String>> linkData) {
		this.linkList = linkList;
		this.linkData = linkData;		
		this.config = config;
	}

	@Override
	public boolean OnCommand(Player player, String label, String[] args) {
		if (args == null || args.length < 1) {
			player.sendMessage("You must specify a link frequency");
			player.sendMessage("/pressalilink [name]");
			return false;
		}

		String frequency = args[0];
		World world = player.getWorld();
		int x = player.getLocation().getBlockX();
		int y = player.getLocation().getBlockY();
		int z = player.getLocation().getBlockZ();
		
		if (args.length > 4) {
			boolean arg1isNumber = StringUtils.isNumericSpace(args[1]);
			boolean arg2isNumber = StringUtils.isNumericSpace(args[2]);
			boolean arg3isNumber = StringUtils.isNumericSpace(args[3]);
			if (arg1isNumber && arg2isNumber && arg3isNumber) {
				x = Integer.parseInt(args[1]);
				y = Integer.parseInt(args[2]);
				z = Integer.parseInt(args[3]);
			}
		}
		
		Link link = new Link(frequency, world, x, y, z);
		linkList.add(link);
		linkData.add(link.toMap());
		saveLinkList();
		return true;
	}
	private void saveLinkList(){
		config.set("aliLinkList", linkData);
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{
			"Usage: /setalilink <frequency> [x] [y] [z]"
		};
	}
}

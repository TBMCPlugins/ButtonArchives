package alisolarflare.components.alilinks.commands;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.architecture.commands.PlayerCommand;
import alisolarflare.components.alilinks.entities.Link;

public class AliLink extends PlayerCommand{
	private JavaPlugin plugin;
	private List<Link> linkList;

	public AliLink(JavaPlugin plugin, List<Link> linkList) {
		this.plugin = plugin;
		this.linkList = linkList;
	}
	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		if(args.length < 1)
			return false;
		
		switch (args[0].toLowerCase()){
		case "press": 
			return press(player, alias, args);
		case "set":   
			return set(player, alias, args);
		default:
			return false;
		}
		
	}
	/**"Usage: /pressalilink <frequency>"*/
	private boolean press(Player player, String alias, String[] inputFrequencies) {
		if (inputFrequencies.length == 0) {
			player.sendMessage("You must specify a link frequency");
			return false;
		}
		
		List<String> inputFrequencyList= Arrays.asList(inputFrequencies);
		for (Link link : linkList) {
			if(inputFrequencyList.contains(link.frequency)){
				link.press(plugin);
			}
		}
		
		player.sendMessage("Link pressed!");
		
		return true;		
	}

	/**Usage: /setalilink <frequency> [x] [y] [z]*/
	public boolean set(Player player, String label, String[] args) {
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
		return true;
	}
	
}

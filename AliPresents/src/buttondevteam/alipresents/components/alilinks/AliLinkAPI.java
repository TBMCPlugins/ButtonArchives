package buttondevteam.alipresents.components.alilinks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.alipresents.components.alilinks.entities.Link;

public class AliLinkAPI {
	public static List<Link> linkList = new ArrayList<Link>();
	/**"Usage: /pressalilink <frequency>"*/
	public static boolean sendPressEvent(CommandSender sender, String[] inputFrequencies, JavaPlugin plugin) {
		if (inputFrequencies.length == 0) {
			sender.sendMessage("You must specify a link frequency");
			return false;
		}
		
		List<String> inputFrequencyList= Arrays.asList(inputFrequencies);
		for (Link link : linkList) {
			if(inputFrequencyList.contains(link.frequency)){
				link.press(plugin);
			}
		}
		sender.sendMessage("Link pressed!");
		return true;		
	}
	public static boolean createAliLink(Player player, String[] args) {
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
	@SuppressWarnings({ "unchecked", "unused" })
	private List<Link> MapToLinkList(List<Map<?, ?>> mapList, Server server) {
		List<Link> linkList = new ArrayList<Link>();
		for (Map<?, ?> MapWithLinkData : mapList){
			linkList.add(new Link((Map<String,String>) MapWithLinkData, server));
		}
		return linkList;
	}
}

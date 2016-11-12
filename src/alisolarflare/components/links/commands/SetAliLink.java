package alisolarflare.components.links.commands;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.links.AliLinkModule;
import alisolarflare.components.links.entities.Link;
import alisolarflare.modules.PlayerCommand;

/**
 * This class manages the command /SetAliLink <frequency> [x] [y] [z]. This command creates an Ali-Link, a location in a world that when called on by {@link PressAliLink}, creates a temporary redstone
 * block, enabling wireless redstone
 * 
 * @see PressAliLink
 * @author Alisolarflare
 *
 */
public class SetAliLink extends PlayerCommand {
	public List<Link> linkList = new ArrayList<Link>();
	AliLinkModule subplugin;
	private JavaPlugin plugin;

	/**
	 * Constructs the SetAliLink class
	 * 
	 * @param plugin
	 *            The plugin that contains the configuration file of SetAliLink
	 */
	public SetAliLink(JavaPlugin plugin) {
		this.plugin = plugin;
		load();
	}

	/**
	 * This command creates an Ali-Link which, when activated by the command /PressAliLink, creates a temporary redstone block if and only if /PressAliLink [frequency] matches the frequency saved when
	 * /SetAliLink [frequency] is called.
	 * 
	 * @see Class#PressAliLink
	 * @param sender
	 *            Player who sent the command
	 * @param command
	 *            Command Object created
	 * @param label
	 *            Name of the command
	 * @param args
	 *            Arguments: [frequency] [x-coordinate] [y-coordinate] [z-coordinate], where the coordinates point to the intended location of the Ali-Link
	 */
	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		sender.sendMessage("you pressed shit");
		if (args == null || args.length < 1) {
			sender.sendMessage("You must specify a link frequency");
			sender.sendMessage("/pressalilink [name]");
			return false;
		}
		Player player = (Player) sender;
		if (args.length < 4) {
			player.sendMessage("short");
			linkList.add(new Link(args[0], player.getLocation()));
			save(player);
			player.sendMessage("end");
			return false;
		}
		if (StringUtils.isNumericSpace(args[1]) && StringUtils.isNumericSpace(args[2])
				&& StringUtils.isNumericSpace(args[3])) {
			player.sendMessage("CUUUSTOM");
			linkList.add(new Link(args[0], new Location(player.getWorld(), Double.parseDouble(args[1]),
					Double.parseDouble(args[2]), Double.parseDouble(args[3]))));
			save(player);
			player.sendMessage("FINISHED");
		} else {
			player.sendMessage("UNCUSTOOM");
			linkList.add(new Link(args[0], player.getLocation()));
			save(player);
			player.sendMessage("UNFINISHED");
			return false;
		}
		return false;
	}

	/**
	 * Tries to save the entire SetAliLink class into memory, which includes all of the current Ali-links saved and in use.
	 * 
	 * @param player
	 */
	private void save(Player player) {
		player.sendMessage("SAAAVING");
		player.sendMessage("SAVE FAILED: TELL ALI TO FIX THE SAVE AND UN-COMMENT THE PARAGRAPH SHE COMMENTED");
		player.sendMessage("Link will only last until next server restart");
		return;
		/*
		 * subplugin.plugin.getConfig().set("aliLinkList", subplugin.linkList); try { player.sendMessage("SAVIN"); subplugin.plugin.saveConfig(); player.sendMessage("GOOD SAVE"); } catch (Exception e)
		 * { player.sendMessage("YOU FUCKED STUFF UP"); // TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}

	/**
	 * Attempts to load the previous saved state of AliLinks, from the plugin configuration file
	 */
	@SuppressWarnings("unchecked")
	private void load() {
		try {
			linkList = (List<Link>) plugin.getConfig().getList("aliLinkList");
			if (linkList == null || linkList.isEmpty()) {
				linkList = new ArrayList<Link>();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}
}

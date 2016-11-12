package alisolarflare.components.creativeboundaries.commands;

import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.components.PlayerCommand;
import alisolarflare.components.creativeboundaries.CreativeBoundariesComponent;

public class Cbgm0 extends PlayerCommand{
	
	private CreativeBoundariesComponent module;

	public Cbgm0(CreativeBoundariesComponent module) {
		this.module = module;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String arg2, String[] arg3) {
		if (!(sender instanceof Player)){
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		
		Player player = (Player) sender;
		player.setGameMode(GameMode.SURVIVAL);
		module.cbCreatives.remove(player);
		return false;
	}
}

package alisolarflare.modules.creativeboundaries.commands;

import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.modules.PlayerCommand;
import alisolarflare.modules.creativeboundaries.CreativeBoundariesModule;

public class Cbgm0 extends PlayerCommand{
	
	private CreativeBoundariesModule module;

	public Cbgm0(CreativeBoundariesModule module) {
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

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}
}

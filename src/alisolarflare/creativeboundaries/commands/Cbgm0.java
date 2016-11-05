package alisolarflare.creativeboundaries.commands;

import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.creativeboundaries.CreativeBoundariesModule;
import buttondevteam.lib.chat.TBMCCommandBase;

public class Cbgm0 extends TBMCCommandBase{
	
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

	@Override
	public boolean GetPlayerOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean GetModOnly() {
		// TODO Auto-generated method stub
		return false;
	}

}

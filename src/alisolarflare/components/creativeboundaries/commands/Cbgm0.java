package alisolarflare.components.creativeboundaries.commands;

import org.bukkit.entity.Player;

import alisolarflare.architecture.commands.PlayerCommand;
import alisolarflare.components.creativeboundaries.CreativeBoundariesAPI;

public class Cbgm0 extends PlayerCommand{
	@Override
	public boolean OnCommand(Player player, String arg2, String[] arg3) {
		CreativeBoundariesAPI.toSurvival(player);
		return true;
	}
	public String[] GetHelpText(String alias){
		return new String[]{"Creative Boundaries Usage: /cbgm0"};
	}
}

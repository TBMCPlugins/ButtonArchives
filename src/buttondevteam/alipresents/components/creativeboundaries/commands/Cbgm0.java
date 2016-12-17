package buttondevteam.alipresents.components.creativeboundaries.commands;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.PlayerCommand;
import buttondevteam.alipresents.components.creativeboundaries.CreativeBoundariesAPI;

public class Cbgm0 extends PlayerCommand{
	@Override
	public String GetCommandPath() {
		return "cb gm0";
	}
	@Override
	public boolean OnCommand(Player player, String arg2, String[] arg3) {
		CreativeBoundariesAPI.toSurvival(player);
		return true;
	}
	public String[] GetHelpText(String alias){
		return new String[]{"Creative Boundaries Usage: /cbgm0"};
	}
}

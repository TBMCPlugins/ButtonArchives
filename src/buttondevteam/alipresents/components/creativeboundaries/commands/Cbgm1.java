package buttondevteam.alipresents.components.creativeboundaries.commands;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.PlayerCommand;
import buttondevteam.alipresents.components.creativeboundaries.CreativeBoundariesAPI;

public class Cbgm1 extends PlayerCommand {
	@Override
	public String GetCommandPath() {
		return "cb gm0";
	}
	@Override
	public boolean OnCommand(Player player, String arg2, String[] arg3) {
		return CreativeBoundariesAPI.toCreative(player);
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[] {
			"Usage: When in a town that you either own or are a resident of, type /cbgm1 to gain creative"
		};
	}
}

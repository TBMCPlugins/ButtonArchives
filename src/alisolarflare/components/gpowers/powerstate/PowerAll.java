package alisolarflare.components.gpowers.powerstate;

import org.bukkit.entity.Player;

import alisolarflare.architecture.commands.ModCommand;
import alisolarflare.components.gpowers.api.GPowerAPI;

public class PowerAll extends ModCommand{
	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		GPowerAPI.PowerUpAllPlayers();
		return true;
	}
	public String[] GetHelpText(String alias){
		return new String[]{
				"Usage: Type /PowerAll to activate all powers for all players with gpowers"
		};
	}
}

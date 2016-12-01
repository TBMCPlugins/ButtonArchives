package alisolarflare.components.gpowers.powerstate;

import org.bukkit.entity.Player;

import alisolarflare.architecture.commands.PlayerCommand;
import alisolarflare.components.gpowers.api.GPowerAPI;

public class PowerDown extends PlayerCommand {
	@Override
	public boolean OnCommand(Player player, String label, String[] args) {
		GPowerAPI.PowerDownPlayer(player);
		return true;
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{
			"Usage: Type /PowerDown to disable your g-power"
		};
	}
}

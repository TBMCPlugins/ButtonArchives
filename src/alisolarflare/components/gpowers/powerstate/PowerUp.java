package alisolarflare.components.gpowers.powerstate;

import org.bukkit.entity.Player;

import alisolarflare.architecture.commands.PlayerCommand;
import alisolarflare.components.gpowers.GPowerAPI;

public class PowerUp extends PlayerCommand {
	@Override
	public boolean OnCommand(Player player, String label, String[] args) {
		GPowerAPI.PowerUpPlayer(player);
		return true;
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{
				"Usage: Type /PowerUp to activate your registered G-Power"
		};
	}
}

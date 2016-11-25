package alisolarflare.components.gpowers.commands;

import org.bukkit.entity.Player;

import alisolarflare.components.PlayerCommand;
import alisolarflare.components.gpowers.GPowerMemory;

public class PowerUp extends PlayerCommand {

	private GPowerMemory gPowerMemory;

	public PowerUp(GPowerMemory gPowerMemory) {
		this.gPowerMemory = gPowerMemory;
	}

	@Override
	public boolean OnCommand(Player player, String label, String[] args) {
		gPowerMemory.PowerUpPlayer(player);
		return true;
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{
				"Usage: Type /PowerUp to activate your registered G-Power"
		};
	}
}

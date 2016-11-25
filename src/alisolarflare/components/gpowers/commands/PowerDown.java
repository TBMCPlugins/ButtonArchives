package alisolarflare.components.gpowers.commands;

import org.bukkit.entity.Player;

import alisolarflare.components.PlayerCommand;
import alisolarflare.components.gpowers.GPowerMemory;

public class PowerDown extends PlayerCommand {

	private GPowerMemory gPowerMemory;

	public PowerDown(GPowerMemory gPowerMemory) {
		this.gPowerMemory = gPowerMemory;
	}

	@Override
	public boolean OnCommand(Player player, String label, String[] args) {
		gPowerMemory.PowerDownPlayer(player);
		return true;
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{
			"Usage: Type /PowerDown to disable your g-power"
		};
	}
}

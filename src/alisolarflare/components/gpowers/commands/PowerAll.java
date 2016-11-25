package alisolarflare.components.gpowers.commands;

import org.bukkit.entity.Player;

import alisolarflare.components.ModCommand;
import alisolarflare.components.gpowers.GPowerMemory;
import alisolarflare.components.gpowers.GPowerMemory.poweredPlayer;

public class PowerAll extends ModCommand{
	private GPowerMemory gPowerMemory;

	public PowerAll(GPowerMemory gPowerMemory) {
		this.gPowerMemory = gPowerMemory;
	}
	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		for (poweredPlayer poweredPlayer : gPowerMemory.poweredPlayerList.values()){
			poweredPlayer.isPowersActive = true;
		}
		return true;
	}
	public String[] GetHelpText(String alias){
		return new String[]{
				"Usage: Type /PowerAll to activate all powers for all players with gpowers"
		};
	}
}

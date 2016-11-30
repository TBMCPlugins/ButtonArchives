/*package graveyard.minigames.commands;

import org.bukkit.entity.Player;

import alisolarflare.architecture.commands.PlayerCommand;
import graveyard.minigames.MinigameComponent;

public class ListFighters extends PlayerCommand {
	private MinigameComponent component;

	public ListFighters(MinigameComponent component) {
		this.component = component;
	}

	@Override
	public boolean OnCommand(Player player, String arg2, String[] arg3) {
		player.sendMessage(component.fighters.toString());
		return true;
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{
				"Usage: Type /ListFighters to get the list of fighters in the current minigame"
		};
	}
}
*/
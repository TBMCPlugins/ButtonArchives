package buttondevteam.alipresents.graveyard.minigames.commands;
/*package graveyard.minigames.commands;

import java.util.List;

import org.bukkit.entity.Player;

import alisolarflare.architecture.commands.PlayerCommand;
import graveyard.minigames.MinigameComponent;

public class JoinMinigame extends PlayerCommand {
	private List<String> fighterList;

	public JoinMinigame(MinigameComponent component) {
		this.fighterList = component.fighters;
	}

	@Override
	public boolean OnCommand(Player player, String arg2, String[] arg3) {	
		if (fighterList.contains(player.getName())) {
			player.sendMessage("You are already in the minigame!");
		}else{
			fighterList.add(player.getName());
			player.sendMessage("You have joined the minigame!");
		}
		return true;
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{
				"Usage: Type /JoinMinigame to join a current button minigame!"
		};
	}
}
*/
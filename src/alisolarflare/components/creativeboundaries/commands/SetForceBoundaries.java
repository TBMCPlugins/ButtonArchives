package alisolarflare.components.creativeboundaries.commands;

import org.bukkit.entity.Player;

import alisolarflare.architecture.commands.ModCommand;
import alisolarflare.components.creativeboundaries.CreativeBoundariesAPI;

public class SetForceBoundaries extends ModCommand{
	@Override
	public boolean OnCommand(Player player, String label, String[] args) {
		return (CreativeBoundariesAPI.setForceBoundaries(player, args));
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{"Usage: /SetForceBoundaries <True/False/0/1>"};
	}
}

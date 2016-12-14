package buttondevteam.alipresents.components.creativeboundaries.commands;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.ModCommand;
import buttondevteam.alipresents.components.creativeboundaries.CreativeBoundariesAPI;

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

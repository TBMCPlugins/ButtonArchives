package buttondevteam.alipresents.components.gpower.powerstate;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.ModCommand;
import buttondevteam.alipresents.components.gpower.api.GPowerAPI;

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

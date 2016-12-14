package buttondevteam.alipresents.components.gpowers.powerstate;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.PlayerCommand;
import buttondevteam.alipresents.components.gpowers.api.GPowerAPI;

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

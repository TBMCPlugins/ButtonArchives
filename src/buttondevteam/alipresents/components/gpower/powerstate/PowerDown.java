package buttondevteam.alipresents.components.gpower.powerstate;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.PlayerCommand;
import buttondevteam.alipresents.components.gpower.api.GPowerAPI;

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

	@Override
	public String GetCommandPath() {
		return "gpower powerdown";
	}
}

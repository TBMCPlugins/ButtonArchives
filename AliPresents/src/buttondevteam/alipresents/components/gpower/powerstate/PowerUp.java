package buttondevteam.alipresents.components.gpower.powerstate;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.PlayerCommand;
import buttondevteam.alipresents.components.gpower.api.GPowerAPI;

public class PowerUp extends PlayerCommand {
	@Override
	public boolean OnCommand(Player player, String label, String[] args) {
		GPowerAPI.PowerUpPlayer(player);
		return true;
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{
				"Usage: Type /"+this.GetCommandPath()+" to activate your registered G-Power"
		};
	}
	@Override
	public String GetCommandPath() {
		return "gpower powerup";
	}
}

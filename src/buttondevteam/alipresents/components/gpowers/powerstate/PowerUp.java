package buttondevteam.alipresents.components.gpowers.powerstate;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.PlayerCommand;
import buttondevteam.alipresents.components.gpowers.api.GPowerAPI;

public class PowerUp extends PlayerCommand {
	@Override
	public boolean OnCommand(Player player, String label, String[] args) {
		GPowerAPI.PowerUpPlayer(player);
		return true;
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{
				"Usage: Type /PowerUp to activate your registered G-Power"
		};
	}
}

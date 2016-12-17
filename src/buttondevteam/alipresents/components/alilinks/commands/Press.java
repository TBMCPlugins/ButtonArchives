package buttondevteam.alipresents.components.alilinks.commands;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.PlayerCommand;
import buttondevteam.alipresents.components.alilinks.AliLinkAPI;
import buttondevteam.alipresents.components.alilinks.AliLinkComponent;

public class Press extends PlayerCommand {
	@Override
	public String GetCommandPath() {
		return "alilink press";
	}

	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		if (args.length < 1)
			return false;
		return AliLinkAPI.sendPressEvent(player, args, AliLinkComponent.getPlugin());
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[] {
			"Usage:  type /"+this.GetCommandPath()+" <frequency> activate a wireless redstone block listening",
			"to your frequency of choice"
		};
	}
}

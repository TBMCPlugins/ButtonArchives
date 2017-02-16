package buttondevteam.alipresents.components.alilinks.commands;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.ModCommand;
import buttondevteam.alipresents.components.alilinks.AliLinkAPI;

public class Set extends ModCommand {
	@Override
	public String GetCommandPath() {
		return "alilink set";
	}

	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		if (args.length < 1)
			return false;
		return AliLinkAPI.createAliLink(player, args);
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[] {
			"Usage:  type /"+this.GetCommandPath()+" <frequency> set a wireless redstone block that listens",
			"for signals from the players pressing the frequency of your choice"
		};
	}
}

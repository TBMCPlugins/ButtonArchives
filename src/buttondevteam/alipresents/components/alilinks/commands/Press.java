package buttondevteam.alipresents.components.alilinks.commands;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.subcommands.SubCommand;

public class Press extends SubCommand{

	@Override
	protected boolean onCommand(Player player, String label, String[] args) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getPlayerOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getModOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}
}

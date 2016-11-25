package alisolarflare.components;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class PlayerCommand extends BaseCommand{
	@Override
	public boolean OnCommand(CommandSender sender, String alias, String[] args){
		return OnCommand((Player) sender, alias, args);
	}
	public abstract boolean OnCommand(Player player, String alias, String[] args);
	@Override
	public boolean GetPlayerOnly() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean GetModOnly() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[] {
			"This command doesn't have help text.	",
			"If you're a player, ask a mod to write one",
			"If you're a mod, ask a dev to write one",
			"If you're a dev, write the help text you lazy bastard. -Ali"
		};
	}
	
}

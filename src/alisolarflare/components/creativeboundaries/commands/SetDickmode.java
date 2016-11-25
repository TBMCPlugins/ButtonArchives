package alisolarflare.components.creativeboundaries.commands;

import org.bukkit.entity.Player;

import alisolarflare.architecture.commands.ModCommand;
import alisolarflare.components.creativeboundaries.CreativeBoundariesComponent;

public class SetDickmode extends ModCommand{
	boolean dickMode;

	public SetDickmode(CreativeBoundariesComponent component){
		this.dickMode = component.dickmode;
	}

	@Override
	public boolean OnCommand(Player player, String label, String[] args) {		
		if(args.length < 1){
			player.sendMessage("You must use True, False, 1, or 0 as arguments!");
			return false;
		}
		String firstArgument = args[0];
		if(firstArgument.startsWith("t") || firstArgument.equals("1")){
			player.sendMessage("Dickmode has been turned on!");
			dickMode = true;
			return true;
		}
		if(firstArgument.startsWith("f") || firstArgument.equals("0")){
			player.sendMessage("Dickmode has been turned off!");
			dickMode = false;
			return true;
		}
		return false;
	}
}

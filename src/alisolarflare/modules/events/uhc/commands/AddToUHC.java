package alisolarflare.modules.events.uhc.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.modules.events.uhc.memory.UHCMatch;
import buttondevteam.lib.chat.TBMCCommandBase;

/**
 * This class handles the specific command /addToUHC which, in-game, adds a player to a specific UltraHardcore match, that is defined by the constructor: {@linkplain #AddToUHC(UHCMatch)}
 * 
 * @author Alisolarflare
 */
public class AddToUHC extends TBMCCommandBase {
	private UHCMatch match;

	public AddToUHC(UHCMatch match) {
		this.match = match;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		// INPUT SANITATION
		Player player = (Player) sender;
		if (player.getName() != "alisolarflare") {
			sender.sendMessage("You must be Ali to use this command, send her a message to change the permissions");
			return false;
		}
		if (args.length <= 1) {
			sender.sendMessage("You must supply at least one playername");
		}

		// Adds players to memory
		for (int i = 0; i > args.length; i++) {
			match.playerList.add(player.getName());
		}
		return false;
	}

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String GetCommandPath() {
		return "addtouhc";
	}

	@Override
	public boolean GetPlayerOnly() {
		return true;
	}

	@Override
	public boolean GetModOnly() {
		// TODO Auto-generated method stub
		return false;
	}

}

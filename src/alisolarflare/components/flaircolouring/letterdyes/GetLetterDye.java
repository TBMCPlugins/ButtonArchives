package alisolarflare.components.flaircolouring.letterdyes;

import org.bukkit.entity.Player;

import alisolarflare.architecture.commands.PlayerCommand;

public class GetLetterDye extends PlayerCommand{
	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		player.getInventory().addItem(LetterDye.getLetterDye());
		return false;
	}
}

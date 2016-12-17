package buttondevteam.alipresents.components.flaircolour.letterdyes;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.PlayerCommand;

public class GetLetterDye extends PlayerCommand{
	@Override
	public String GetCommandPath() {
		return "flaircolour getletterdye";
	}
	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		player.getInventory().addItem(LetterDye.getLetterDye());
		return false;
	}
}

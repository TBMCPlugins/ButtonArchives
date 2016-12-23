package buttondevteam.alipresents.components.dungeons.commands;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.ModCommand;
import buttondevteam.alipresents.components.dungeons.DungeonComponent;

public class SetExit extends ModCommand {

	private DungeonComponent component;

	public SetExit(DungeonComponent component) {
		this.component = component;
	}

	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		player.sendMessage("Setting DungeonA1's Exit!");
		component.dungeonA1.setExit(player.getLocation());
		player.sendMessage("DungeonA1's Exit Set!");
		return true;
	}
	@Override
	public String GetCommandPath(){
		return "dungeons set exit";
	}

}

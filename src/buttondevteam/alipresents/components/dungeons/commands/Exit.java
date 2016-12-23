package buttondevteam.alipresents.components.dungeons.commands;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.PlayerCommand;
import buttondevteam.alipresents.components.dungeons.DungeonComponent;

public class Exit extends PlayerCommand {

	private DungeonComponent component;
	public Exit(DungeonComponent component) {
		this.component = component;
	}
	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		component.dungeonA1.exitDungeon(player);
		return false;
	}
	public String getCommandPath(){
		return "dungeon exit";
	}

}

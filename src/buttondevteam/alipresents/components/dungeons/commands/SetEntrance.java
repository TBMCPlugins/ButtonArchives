package buttondevteam.alipresents.components.dungeons.commands;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.ModCommand;
import buttondevteam.alipresents.components.dungeons.DungeonComponent;

public class SetEntrance extends ModCommand {

	private DungeonComponent component;
	public SetEntrance(DungeonComponent component) {
		this.component = component;
	}
	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		player.sendMessage("Setting DungeonA1's Entrance!");
		component.dungeonA1.setEntrance(player.getLocation());
		player.sendMessage("Entrance Set!");
		return true;
	}
	public String GetCommandPath(){
		return "dungeons set entrance";
	}

}

package buttondevteam.alipresents.components.dungeons.commands;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.ModCommand;
import buttondevteam.alipresents.components.dungeons.DungeonComponent;

public class DisplayDebug extends ModCommand {

	private DungeonComponent component;

	public DisplayDebug(DungeonComponent component) {
		this.component = component;
	}

	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		player.sendMessage("Entrance Location: "+component.dungeonA1.getDungeonEntrance().toString());
		player.sendMessage("Exit Location: "+component.dungeonA1.getDungeonExit().toString());
		return true;
	}
	
	@Override
	public String GetCommandPath(){
		return "dungeons display debug";
	}

}

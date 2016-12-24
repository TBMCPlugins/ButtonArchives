package buttondevteam.alipresents.components.dungeons.commands;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.ModCommand;
import buttondevteam.alipresents.components.dungeons.DungeonComponent;

public class Enter extends ModCommand{
	private DungeonComponent component;
	public Enter(DungeonComponent component) {
		this.component = component;
	}
	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		component.dungeonA1.enterDungeon(player);
		return true;
	}
	@Override
	public String GetCommandPath(){
		return "dungeons enter";
	}
	
}

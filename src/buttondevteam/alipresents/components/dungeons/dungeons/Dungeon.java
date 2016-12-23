package buttondevteam.alipresents.components.dungeons.dungeons;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**Dungeon Object that represents a dungeon*/
public abstract class Dungeon {
	public abstract Location getDungeonEntrance();
	public abstract Location getDungeonExit();
	public boolean enterDungeon(Player player){
		
		if (getDungeonEntrance() == null){
			player.sendMessage("There has been a collapse! You may not enter the dungeon now.");
			return false;
		}
		player.teleport(getDungeonEntrance());
		player.setGameMode(GameMode.ADVENTURE);
		return true;
	}
	public boolean exitDungeon(Player player){
		if (getDungeonExit() == null){
			player.sendMessage("Oh god, something went horribly wrong with exiting... Yell for help!");
			return false;
		}
		player.teleport(getDungeonExit());
		player.setGameMode(GameMode.SURVIVAL);
		return true;
	}
}

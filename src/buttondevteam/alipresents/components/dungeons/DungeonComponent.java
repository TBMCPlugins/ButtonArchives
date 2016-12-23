package buttondevteam.alipresents.components.dungeons;

import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.alipresents.architecture.Component;
import buttondevteam.alipresents.components.dungeons.commands.Enter;
import buttondevteam.alipresents.components.dungeons.commands.Exit;
import buttondevteam.alipresents.components.dungeons.dungeons.GenericDungeonA1;

public class DungeonComponent extends Component {
	public GenericDungeonA1 dungeonA1;
	@Override
	public void register(JavaPlugin plugin) {
		dungeonA1 = new GenericDungeonA1(plugin);
		registerCommand(plugin, new Enter(this));
		registerCommand(plugin, new Exit(this));

	}

}

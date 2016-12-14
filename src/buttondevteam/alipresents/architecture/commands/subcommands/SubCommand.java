package buttondevteam.alipresents.architecture.commands.subcommands;

import org.bukkit.entity.Player;

public abstract class SubCommand {
	public abstract boolean run(Player player, String label, String[] args);
	public abstract boolean getPlayerOnly();
	public abstract boolean getModOnly();
	public abstract String[] GetHelpText(String alias);
}
